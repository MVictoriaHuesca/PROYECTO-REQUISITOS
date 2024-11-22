package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.dao.AttributeRepository;

import es.ir.minipim.entity.Account;
import es.ir.minipim.entity.Attribute;
import es.ir.minipim.entity.AttributeType;
import es.ir.minipim.ui.AttributeUI;
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
        List<Attribute> lista = this.attributeRepository.listarAtributosCuenta(1);
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
        attribute.setId(-1);

        model.addAttribute("attribute", attribute);

        model.addAttribute("attributeTypes", AttributeType.values());

        return "atributo";
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("attribute") Attribute theAttribute, HttpSession session) {
        Attribute attribute = this.attributeRepository.findById(theAttribute.getId()).orElse(new Attribute());

        //attribute.setAccountByAccountIdFk(this.accountRepository.findById((Integer) session.getAttribute("account")).get());
        List<Account> listaAccount = this.accountRepository.findAll();
        for(Account account : listaAccount){
            if(account.getId() == 1){   //TODO: Cambiar por el id de la cuenta logueada
                attribute.setAccountIdFk(account);
            }
        }

        attribute.setAttributeName(theAttribute.getAttributeName());
        attribute.setAttributeType(theAttribute.getAttributeType());
        //La fecha no hace falta ponerla porque se pone por defecto en la base de datos
        this.attributeRepository.save(attribute);

        return "redirect:/attributes/";
    }

    @GetMapping("/editar")
    public String doConsult (@RequestParam("id") Integer id, Model model) {
        Attribute attribute = this.attributeRepository.findById(id).get();
        Attribute attributeUI = new Attribute();
        attributeUI.setId(attribute.getId());
        attributeUI.setAttributeName(attribute.getAttributeName());
        attributeUI.setAttributeType(attribute.getAttributeType());

        model.addAttribute("attribute", attributeUI);
        model.addAttribute("attributeTypes", AttributeType.values());

        return "atributo";
    }

    @GetMapping("/details")
    public String doDetails(@RequestParam("id") Integer id, Model model){
        Attribute attribute = this.attributeRepository.findById(id).get();
        model.addAttribute("attribute", attribute);
        return "consultarAtributo";
    }

}
