package es.ir.minipim.controller;

import es.ir.minipim.dao.AttributeRepository;
import es.ir.minipim.entity.AttributeEntity;
import es.ir.minipim.entity.CategoryEntity;
import es.ir.minipim.ui.Attribute;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    protected AttributeRepository attributeRepository;

    @GetMapping("/")
    public String doListar(Model model){
        List<AttributeEntity> lista = this.attributeRepository.findAll();
        model.addAttribute("attributesList", lista);
        return "listadoAtributos";
    }

    @GetMapping("/borrar")
    public String doBorrar (@RequestParam("id") Integer id) {
        this.attributeRepository.deleteById(id);

        return "redirect:/attributes/";
    }

    @GetMapping("/crear")
    public String doNuevo (Model model) {
        Attribute attribute = new Attribute();
        model.addAttribute("attribute", attribute);

        return "atributo";
    }

}
