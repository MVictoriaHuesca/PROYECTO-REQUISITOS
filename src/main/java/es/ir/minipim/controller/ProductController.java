package es.ir.minipim.controller;

import es.ir.minipim.dao.*;
import es.ir.minipim.entity.*;
import es.ir.minipim.ui.ProductDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.Timestamp;
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

    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        // Obtener lista de productos de un usuario
        Integer idAccount = (Integer) session.getAttribute("account");
        Account account = this.accountRepository.findById(idAccount).get();
        List<Product> lista = account.getProducts();

        //List<Product> lista = this.productRepository.findAll();
        model.addAttribute("lista", lista);
        return "listadoProductos";
    }

    @GetMapping("/details")
    public String doDetails(@RequestParam("id") Integer id, Model model){
        ProductDTO producto = this.productRepository.findById(id).get();
        // Atributos
        List<ProductAttribute> productAttributes = (List<ProductAttribute>) producto.getProductAttributesByProductId();
        List<Attribute> attributes = new ArrayList<>();
        for(ProductAttribute p : productAttributes){
            attributes.add(p.getAttributeByAttributeIdFk());
        }

        // Categorias
        List<ProductCategory> productCategories = (List<ProductCategory>) producto.getProductCategoriesByProductId();
        List<Category> categories = new ArrayList<>();
        for(ProductCategory p : productCategories){
            categories.add(p.getCategoryByCategoryIdFk());
        }

        model.addAttribute("producto", producto);
        model.addAttribute("productAttributes", productAttributes);
        model.addAttribute("attributes", attributes);
        model.addAttribute("productCategories", productCategories);
        model.addAttribute("categories", categories);

        return "consultarProducto";
    }

    @GetMapping("/new")
    public String doNuevo(Model model, HttpSession session){
        ProductDTO producto = new ProductDTO();
        producto.setId(-1);
        producto.setCreationDate(new Timestamp(System.currentTimeMillis()));
        model.addAttribute("product", producto);
        return "editarProducto";
    }

    @PostMapping("/save")
    public String doGuardar(@ModelAttribute("product") ProductDTO product, HttpSession session){
        ProductDTO producto = this.productRepository.findById(product.getId()).orElse(new ProductDTO());

        producto.setLabel(product.getLabel());
        producto.setSku(product.getSKU());
        producto.setGtin(product.getGTIN());
        producto.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.productRepository.save(producto);
        //Product productoGuardado = this.productRepository.ultimoId();

        Account account = this.accountRepository.findById(1).get();

        AccountProduct accountProduct = new AccountProduct();
        accountProduct.setAccountIdFk(1);
        accountProduct.setProductIdFk(producto.getProductId());
        accountProduct.setProductByProductIdFk(producto);
        accountProduct.setAccountByAccountIdFk(account);

        producto.getAccountProductsByProductId().add(accountProduct);
        account.getAccountProductsByAccountId().add(accountProduct);

        this.accountProductRepository.save(accountProduct);

        this.productRepository.save(producto);
        this.accountRepository.save(account);




        return "redirect:/products/";
    }

    @GetMapping("/delete")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session) {
        this.productRepository.deleteById(id);
        return "redirect:/products/";
    }
}
