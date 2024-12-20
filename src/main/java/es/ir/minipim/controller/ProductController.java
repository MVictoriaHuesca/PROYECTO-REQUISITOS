package es.ir.minipim.controller;

import es.ir.minipim.dao.*;
import es.ir.minipim.entity.*;
import es.ir.minipim.ui.Filtro;
import es.ir.minipim.ui.ProductDTO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected AccountProductRepository accountProductRepository;

    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected CategoryRepository categoryRepository;

    @Autowired
    protected ProductCategoryRepository productCategoryRepository;

    @Autowired
    protected ProductAttributeRepository productAttributeRepository;

    @Autowired
    protected AttributeRepository attributeRepository;

    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        // Obtener lista de productos de un usuario
        Account account = this.accountRepository.findById(1).get();
        List<Product> lista = account.getProducts();
        //List<Attribute> attributes = account.getAttributes();
        List<ProductAttribute> pa = account.getProductAttributes();
        //List<Product> lista = this.productRepository.findAll();
        model.addAttribute("account", account);
        model.addAttribute("lista", lista);
        model.addAttribute("accountAttributes", pa);
        return "listadoProductos";
    }

    @GetMapping("/details")
    public String doDetails(@RequestParam("id") Integer id, Model model, HttpSession session){
        Account account = (Account) session.getAttribute("account");
        model.addAttribute("account", account);
        Product producto = this.productRepository.findById(id).get();
        // Atributos
        List<ProductAttribute> productAttributes = producto.getProductAttributes();
        List<Attribute> attributes = new ArrayList<>();
        for(ProductAttribute p : productAttributes){
            attributes.add(p.getAttributeIdFk());
        }

        // Categorias
        List<ProductCategory> productCategories =  producto.getProductCategories();
        List<Category> categories = new ArrayList<>();
        for(ProductCategory p : productCategories){
            categories.add(p.getCategoryIdFk());
        }

        // Relaciones
        List<ProductRelationship> productRelationships =  producto.getProductRelationships();
        List<Relationship> relationships = new ArrayList<>();
        for(ProductRelationship pr : productRelationships){
            relationships.add(pr.getRelationshipIdFk());
        }

        model.addAttribute("producto", producto);

        model.addAttribute("productAttributes", productAttributes);
        model.addAttribute("attributes", attributes);

        model.addAttribute("productCategories", productCategories);
        model.addAttribute("categories", categories);

        model.addAttribute("relationships", relationships);
        model.addAttribute("productRelationships", productRelationships);

        return "consultarProducto";
    }

    @GetMapping("/new")
    public String doNuevo(Model model, HttpSession session){
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        ProductDTO producto = new ProductDTO();
        producto.setId(-1);
        producto.setCreationDate(Instant.now());
        model.addAttribute("product", producto);

        Account account = this.accountRepository.findById(1).get();
        List<Category> categories = account.getCategories(); // Lista de categorias de la cuenta
        model.addAttribute("categories", categories);

        List<Attribute> attributes = account.getAttributes(); // Lista de atributos de la cuenta
        model.addAttribute("attributes", attributes);

        List<ProductAttribute> productAttributes = account.getProductAttributes();
        model.addAttribute(("productAttributes"), productAttributes);

        return "nuevoProducto";
    }

    @GetMapping("/edit")
    public String doEditar(@RequestParam("id") Integer id, Model model, HttpSession session){
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        Product producto = this.productRepository.findById(id).get();
        producto.getProductCategories(); // Quiero las categorias
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(producto.getId());
        productDTO.setLabel(producto.getLabel());
        productDTO.setSKU(producto.getSku());
        productDTO.setGTIN(producto.getGtin());
        productDTO.setCreationDate(producto.getCreatedAt());
        model.addAttribute("product", productDTO);

        Account account = this.accountRepository.findById(1).get();
        List<Category> categories = account.getCategories(); // Lista de categorias de la cuenta
        model.addAttribute("categories", categories);

        // Categorias
        List<ProductCategory> productCategories = producto.getProductCategories();
        List<Integer> categoriesIds = new ArrayList<>();
        for(ProductCategory pc : productCategories){
            categoriesIds.add(pc.getCategoryIdFk().getId());
        }
        productDTO.setCategories(categoriesIds);
        model.addAttribute("productCategories", productCategories);

        // Atributos
        List<ProductAttribute> productAttributes = producto.getProductAttributes();
        List<Integer> attributesIds = new ArrayList<>();
        for(ProductAttribute pa : productAttributes){
            attributesIds.add(pa.getAttributeIdFk().getId());
        }
        productDTO.setAttributeIds(attributesIds);
        model.addAttribute("productAttributes", productAttributes);

        List<ProductAttribute> productAttributesValues = producto.getProductAttributes();
        List<String> attributesValues = new ArrayList<>();
        for(ProductAttribute pa : productAttributesValues){
            attributesValues.add(pa.getValue());
        }
        productDTO.setAttributeValues(attributesValues);
        model.addAttribute("attributesValue", attributesValues);

        List<Attribute> attributes = account.getAttributes(); // Lista de atributos de la cuenta
        model.addAttribute("attributes", attributes);

        model.addAttribute("productAttributes", productAttributes);

        return "/Product/editarProducto";
    }

    @PostMapping("/save")
    public String doGuardar(@ModelAttribute("product") ProductDTO product, HttpSession session, Model model){
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        Product producto = this.productRepository.findById(product.getId()).orElse(new Product());
        boolean isNew = producto.getId() == null;

        producto.setLabel(product.getLabel());
        producto.setSku(product.getSKU());
        producto.setGtin(product.getGTIN());
        producto.setCreatedAt(Instant.now());

        Account account = this.accountRepository.findById(1).get();

        this.productRepository.save(producto);

        // Asociar producto a cuenta
        if(isNew){
            AccountProduct accountProduct = new AccountProduct();

            AccountProductId accountProductId = new AccountProductId(); // Id compuesto
            accountProductId.setAccountIdFk(1); // Id de la cuenta
            accountProductId.setProductIdFk(producto.getId()); // Id del producto

            accountProduct.setId(accountProductId);
            accountProduct.setProductIdFk(producto);
            accountProduct.setAccountIdFk(account);

            this.accountProductRepository.save(accountProduct);
        }

        // Categorias
        List<ProductCategory> categoriasDelProducto = producto.getProductCategories();

        for(ProductCategory pc : categoriasDelProducto){
            this.productCategoryRepository.delete(pc);
        }

        for(Integer id : product.getCategories()){
            Category categoria = this.categoryRepository.findById(id).get();
            List<ProductCategory> categories = producto.getProductCategories();

            ProductCategory productCategory = new ProductCategory();

            ProductCategoryId productCategoryId = new ProductCategoryId(); // Id compuesto
            productCategoryId.setCategoryIdFk(id); // Id de la categoria
            productCategoryId.setProductIdFk(producto.getId()); // Id del producto
            productCategoryId.setAccountIdFk(account.getId()); // Id de la cuenta

            productCategory.setCategoryIdFk(categoria);
            productCategory.setProductIdFk(producto);
            productCategory.setId(productCategoryId);
            productCategory.setAccountIdFk(account);

            this.productCategoryRepository.save(productCategory);
        }

        // Atributos
        int i = 0;
        for(Integer id : product.getAttributeIds()){
            Attribute attribute = this.attributeRepository.findById(id).get();
            List<ProductAttribute> attributes = producto.getProductAttributes();

            ProductAttribute productAttribute = new ProductAttribute();

            ProductAttributeId productAttributeId = new ProductAttributeId(); // Id compuesto
            productAttributeId.setAttributeIdFk(id); // Id de la categoria
            productAttributeId.setProductIdFk(producto.getId()); // Id del producto
            productAttributeId.setAccountIdFk(account.getId()); // Id de la cuenta

            productAttribute.setAttributeIdFk(attribute);
            productAttribute.setProductIdFk(producto);
            productAttribute.setId(productAttributeId);
            productAttribute.setAccountIdFk(account);
            productAttribute.setValue(product.getAttributeValues().get(i));
            i++;

            this.productAttributeRepository.save(productAttribute);
        }

        return "redirect:/products/";
    }

    @GetMapping("/delete")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session, Model model) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        Product producto = this.productRepository.findById(id).get();

        List<AccountProduct> productosDeCuenta = this.accountProductRepository.productosDeCuenta(producto);
        this.accountProductRepository.deleteAll(productosDeCuenta);

        List<ProductCategory> categoriasDelProducto = producto.getProductCategories();
        this.productCategoryRepository.deleteAll(categoriasDelProducto);

        List<ProductAttribute> atributosDelProducto = producto.getProductAttributes();
        this.productAttributeRepository.deleteAll(atributosDelProducto);

        this.productRepository.deleteById(id);
        return "redirect:/products/";
    }

    @GetMapping("/export")
    public String doExportar(HttpSession session, Model model){
        Account account = this.accountRepository.findById(1).get();
        model.addAttribute("account", account);

        List<Product> lista = account.getProducts();
        model.addAttribute("lista", lista);

        Filtro filtro = new Filtro();
        model.addAttribute("filtro", filtro);

        List<Category> categories = account.getCategories(); // Lista de categorias de la cuenta
        model.addAttribute("categories", categories);

        List<Attribute> atributosFloat = this.attributeRepository.atributosFloat();
        model.addAttribute("atributosFloat", atributosFloat);
        return "/Product/exportarProducto";
    }

    @PostMapping("/filter")
    public String doFilter(@ModelAttribute("filtro") Filtro filtro, HttpSession session, Model model){
        Account account = this.accountRepository.findById(1).get();
        model.addAttribute("account", account);
        List<Product> lista = new ArrayList<>();
        if(filtro.estaVacio()){
            lista = account.getProducts();
        } else {
            Category category = this.categoryRepository.findById(filtro.getCategory()).get();
            List<ProductCategory> productCategories = this.productCategoryRepository.findByCategoryIdFk(category);
            for(ProductCategory pc : productCategories){
                lista.add(pc.getProductIdFk());
            }
        }

        model.addAttribute("filtro", filtro);

        List<Category> categories = account.getCategories(); // Lista de categorias de la cuenta
        model.addAttribute("categories", categories);

        List<Attribute> atributosFloat = this.attributeRepository.atributosFloat();
        model.addAttribute("atributosFloat", atributosFloat);

        model.addAttribute("lista", lista);
        return "/Product/exportarProducto";
    }

    @PostMapping("/generate")
    public void doGenerate(@ModelAttribute("filtro") Filtro filtro, HttpSession session, Model model, HttpServletResponse response) throws IOException {
        Account account = this.accountRepository.findById(1).get();
        model.addAttribute("account", account);
        List<Product> lista = new ArrayList<>();
        if(filtro.estaVacio()){
            lista = account.getProducts();
        } else {
            Category category = this.categoryRepository.findById(filtro.getCategory()).get();
            List<ProductCategory> productCategories = this.productCategoryRepository.findByCategoryIdFk(category);
            for(ProductCategory pc : productCategories){
                lista.add(pc.getProductIdFk());
            }
        }

        Attribute precio = this.attributeRepository.findById(filtro.getPrice()).orElse(null);

        model.addAttribute("lista", lista);

        if(precio != null){
            try(PrintWriter writer = response.getWriter()) {
                response.setContentType("text/csv");
                response.setHeader("Content-Disposition", "attachment; filename=\"products.csv\"");

                // Encabezado
                writer.println("SKU,Title,Fullfilled By,Amazon_SKU,Price,Offer Primer");

                for(Product p:lista){
                    for(ProductAttribute pa : p.getProductAttributes()){
                        if(pa.getAttributeIdFk().getId() == precio.getId()){
                            writer.println(p.getSku() + "," + p.getLabel() + "," + account.getGroupName() + "," + p.getGtin() + "," +
                                    pa.getValue() + ",false");
                        }
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            response.setContentType("text/plain");
            response.getWriter().println("The exportation could not be done. You must have a float attribute");
        }
    }
}
