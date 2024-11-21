package es.ir.minipim.controller;

import es.ir.minipim.dao.CategoryRepository;
import es.ir.minipim.entity.AttributeEntity;
import es.ir.minipim.entity.CategoryEntity;
import es.ir.minipim.entity.ProductAttributeEntity;
import es.ir.minipim.entity.ProductEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    protected CategoryRepository categoryRepository;

    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        List<CategoryEntity> lista = this.categoryRepository.findAll();
        model.addAttribute("lista", lista);
        return "listadoCategorias";
    }

    @GetMapping("/delete")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session) {

        this.categoryRepository.deleteById(id);

        return "redirect:/categories/";
    }

    @GetMapping("/new")
    public String doNuevo (Model model, HttpSession session) {

        CategoryEntity categoria = new CategoryEntity();
        model.addAttribute("category", categoria);

        return "redirect:/categories/";    //"newCategory"
    }

    /*@GetMapping("/details")
    public String doDetails(@RequestParam("id") Integer id, Model model){
        CategoryEntity categoria = this.categoryRepository.findById(id).get();
        List<CategoryEntity> CategoryAttributes = (List<CategoryEntity>) categoria.getProductCategoriesByCategoryId();
        List<AttributeEntity> attributes = new ArrayList<>();
        for(ProductAttributeEntity p : productAttributes){
            attributes.add(p.getAttributeByAttributeIdFk());
        }
        model.addAttribute("producto", producto);
        model.addAttribute("productAttributes", productAttributes);
        model.addAttribute("attributes", attributes);
        return "consultarProducto";
    }*/
}
