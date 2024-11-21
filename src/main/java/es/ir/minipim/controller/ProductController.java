package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountAttributeRepository;
import es.ir.minipim.dao.AttributeRepository;
import es.ir.minipim.dao.ProductRepository;
import es.ir.minipim.entity.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected AttributeRepository attributeRepository;

    @Autowired
    protected AccountAttributeRepository accountAttributeRepository;

    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        List<ProductEntity> lista = this.productRepository.findAll();
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
        ProductEntity producto = new ProductEntity();
        model.addAttribute("producto", producto);
        return "nuevoProducto";
    }

    @GetMapping("/delete")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session) {
        this.productRepository.deleteById(id);
        return "redirect:/products/";
    }
}
