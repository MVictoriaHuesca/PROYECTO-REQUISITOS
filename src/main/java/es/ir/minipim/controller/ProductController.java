package es.ir.minipim.controller;

import es.ir.minipim.dao.*;
import es.ir.minipim.dto.AccountDto;
import es.ir.minipim.entity.*;
import es.ir.minipim.ui.Product;
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
        AccountEntity account = this.accountRepository.findById(idAccount).get();
        List<AccountProductEntity> productsAccount= account.getAccountProductsByAccountId();
        List<ProductEntity> lista = new ArrayList<>();
        for(AccountProductEntity p : productsAccount){
            lista.add(p.getProductByProductIdFk());
        }

        //List<ProductEntity> lista = this.productRepository.findAll();
        model.addAttribute("lista", lista);
        return "listadoProductos";
    }

    @GetMapping("/details")
    public String doDetails(@RequestParam("id") Integer id, Model model){
        ProductEntity producto = this.productRepository.findById(id).get();
        // Atributos
        List<ProductAttributeEntity> productAttributes = (List<ProductAttributeEntity>) producto.getProductAttributesByProductId();
        List<AttributeEntity> attributes = new ArrayList<>();
        for(ProductAttributeEntity p : productAttributes){
            attributes.add(p.getAttributeByAttributeIdFk());
        }

        // Categorias
        List<ProductCategoryEntity> productCategories = (List<ProductCategoryEntity>) producto.getProductCategoriesByProductId();
        List<CategoryEntity> categories = new ArrayList<>();
        for(ProductCategoryEntity p : productCategories){
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
        Product producto = new Product();
        producto.setId(-1);
        producto.setCreationDate(new Timestamp(System.currentTimeMillis()));
        model.addAttribute("product", producto);
        return "editarProducto";
    }

    @PostMapping("/save")
    public String doGuardar(@ModelAttribute("product") Product product, HttpSession session){
        ProductEntity producto = this.productRepository.findById(product.getId()).orElse(new ProductEntity());

        producto.setLabel(product.getLabel());
        producto.setSku(product.getSKU());
        producto.setGtin(product.getGTIN());
        producto.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.productRepository.save(producto);
        ProductEntity productoGuardado = this.productRepository.ultimoId();

        AccountProductEntity accountProduct = new AccountProductEntity();
        accountProduct.setAccountIdFk((Integer) session.getAttribute("account"));
        accountProduct.setProductIdFk(productoGuardado.getProductId());
        this.accountProductRepository.save(accountProduct);

        return "redirect:/products/";
    }

    @GetMapping("/delete")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session) {
        this.productRepository.deleteById(id);
        return "redirect:/products/";
    }
}
