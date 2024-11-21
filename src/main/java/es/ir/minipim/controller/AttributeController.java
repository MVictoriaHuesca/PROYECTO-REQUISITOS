package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.dao.AttributeRepository;
import es.ir.minipim.entity.AccountEntity;
import es.ir.minipim.entity.AttributeEntity;
import es.ir.minipim.entity.AttributeType;
import es.ir.minipim.entity.CategoryEntity;
import es.ir.minipim.ui.Attribute;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    protected AttributeRepository attributeRepository;
    @Autowired
    protected AccountRepository accountRepository;

    @GetMapping("/")
    public String doListar(Model model){
        List<AttributeEntity> lista = this.attributeRepository.listarAtributosCuenta(1);
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
        attribute.setIdAttribute(-1);

        model.addAttribute("attribute", attribute);

        model.addAttribute("attributeTypes", AttributeType.values());

        return "atributo";
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("attribute") Attribute theAttribute, HttpSession session) {
        AttributeEntity attribute = this.attributeRepository.findById(theAttribute.getIdAttribute()).orElse(new AttributeEntity());

        //attribute.setAccountByAccountIdFk(this.accountRepository.findById((Integer) session.getAttribute("account")).get());
        attribute.setAccountByAccountIdFk(this.accountRepository.findById(1).get());
        attribute.setAttributeName(theAttribute.getName());
        attribute.setAttributeType(theAttribute.getType());
        attribute.setCreatedAt(Timestamp.valueOf(LocalDate.now().atStartOfDay()));
        this.attributeRepository.save(attribute);

        return "redirect:/attributes/";
    }

    @GetMapping("/editar")
    public String doConsult (@RequestParam("id") Integer id, Model model) {
        AttributeEntity attribute = this.attributeRepository.findById(id).get();
        Attribute attributeUI = new Attribute();
        attributeUI.setIdAttribute(attribute.getAttributeId());
        attributeUI.setName(attribute.getAttributeName());
        attributeUI.setType(attribute.getAttributeType());

        model.addAttribute("attribute", attributeUI);
        model.addAttribute("attributeTypes", AttributeType.values());

        return "atributo";
    }

    @GetMapping("/details")
    public String doDetails(@RequestParam("id") Integer id, Model model){
        AttributeEntity attribute = this.attributeRepository.findById(id).get();
        model.addAttribute("attribute", attribute);
        return "consultarAtributo";
    }

}
