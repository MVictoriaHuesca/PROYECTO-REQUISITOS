package es.ir.minipim.controller;

import es.ir.minipim.dao.ProductRepository;
import es.ir.minipim.entity.ProductEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    protected ProductRepository productRepository;

    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        List<ProductEntity> lista = this.productRepository.findAll();
        model.addAttribute("lista", lista);
        return "listadoProductos";
    }

    @GetMapping("/details")
    public String doDetails(@RequestParam("id") Integer id, Model model, HttpSession session){
        ProductEntity producto = this.productRepository.findById(id).get();
        model.addAttribute("producto", producto);
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
