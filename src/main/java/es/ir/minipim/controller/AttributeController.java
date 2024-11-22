package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountAttributeRepository;
import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.dao.AttributeRepository;

import es.ir.minipim.entity.*;
import es.ir.minipim.ui.AttributeUI;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    protected AttributeRepository attributeRepository;
    @Autowired
    protected AccountRepository accountRepository;
    @Autowired
    protected AccountAttributeRepository accountAttributeRepository;

    @GetMapping("/")
    public String doListar(Model model){
        List<Attribute> lista = this.attributeRepository.listarAtributosCuenta(1);
        model.addAttribute("attributesList", lista);
        return "listadoAtributos";
    }

    @GetMapping("/borrar")
    public String doBorrar (@RequestParam("id") Integer id) {
        Attribute attribute = this.attributeRepository.findById(id).get();
        List<AccountAttribute> accountAttribute = this.accountAttributeRepository.atributosDeCuenta(attribute);
        this.accountAttributeRepository.deleteAll(accountAttribute);

        this.attributeRepository.deleteById(id);

        return "redirect:/attributes/";
    }

    @GetMapping("/crear")
    public String doNuevo (Model model) {
        Account account = this.accountRepository.findById(1).get();
        /*if(account.getAttributes().size() >= 5){
            return "alerta";
        }else {*/

            AttributeUI attribute = new AttributeUI();
            attribute.setIdAttribute(-1);

            model.addAttribute("attribute", attribute);

            model.addAttribute("attributeTypes", AttributeType.values());

            return "atributo";

    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("attribute") AttributeUI theAttribute, HttpSession session) {
        Account account = this.accountRepository.findById(1).get();
        Attribute attribute = this.attributeRepository.findById(theAttribute.getIdAttribute()).orElse(new Attribute());

        //attribute.setAccountByAccountIdFk(this.accountRepository.findById((Integer) session.getAttribute("account")).get());
        attribute.setAccountIdFk(this.accountRepository.findById(1).get());
        attribute.setAttributeName(theAttribute.getName());
        attribute.setAttributeType(theAttribute.getType().toString());
        attribute.setCreatedAt(Instant.now());
        this.attributeRepository.save(attribute);

        AccountAttribute accountAttribute = new AccountAttribute();
        accountAttribute.setAccountIdFk(account);
        accountAttribute.setAttributeIdFk(attribute);

        AccountAttributeId accountAttributeId = new AccountAttributeId();
        accountAttributeId.setAccountIdFk(account.getId());
        accountAttributeId.setAttributeIdFk(attribute.getId());
        accountAttribute.setId(accountAttributeId);

        //account.getAttributes().add(attribute);
        //this.accountRepository.save(account);


        return "redirect:/attributes/";
    }

    @GetMapping("/editar")
    public String doConsult (@RequestParam("id") Integer id, Model model) {
        Attribute attribute = this.attributeRepository.findById(id).get();
        AttributeUI attributeUI = new AttributeUI();
        attributeUI.setIdAttribute(attribute.getId());
        attributeUI.setName(attribute.getAttributeName());
        for(AttributeType type : AttributeType.values()){
            if(type.toString().equals(attribute.getAttributeType())){
                attributeUI.setType(type);
            }
        }


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
