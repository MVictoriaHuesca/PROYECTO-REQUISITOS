package es.ir.minipim.controller;

import es.ir.minipim.dao.*;

import es.ir.minipim.entity.*;
import es.ir.minipim.ui.AttributeUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.Instant;
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
    @Autowired
    protected ProductRepository productRepository;

    @GetMapping("/")
    public String doListar(Model model){
        List<Attribute> lista = this.attributeRepository.listarAtributosCuenta(1);
        model.addAttribute("attributesList", lista);
        return "listadoAtributos";
    }

    @GetMapping("/borrar")
    public String doBorrar (@RequestParam("id") Integer id) {
        Attribute attribute = this.attributeRepository.findById(id).get();

        // Eliminar attributo de los productos asociados
        List<ProductAttribute> productAttributes = attribute.getProductAttributes();
        for(ProductAttribute pa : productAttributes){
            Product p = this.productRepository.findById(pa.getProductIdFk().getId()).get();
            List<ProductAttribute> attributes = p.getProductAttributes();
            attributes.remove(pa);
            p.setProductAttributes(attributes);
            this.productRepository.save(p);
        }

        // Eliminar atributo de las cuentas asociadas
        List<Account> accounts = attribute.getAccounts();
        for(Account a : accounts){
            List<Attribute> attributes = a.getAttributes();
            attributes.remove(attribute);
            a.setAttributes(attributes);
            this.accountRepository.save(a);
        }

        this.attributeRepository.delete(attribute);

        return "redirect:/attributes/";
    }

    @GetMapping("/crear")
    public String doNuevo (Model model) {
        Account account = this.accountRepository.findById(1).get();
        if(account.getAttributes().size() >= 5){
            return "alerta";
        }else {
            AttributeUI attribute = new AttributeUI();
            attribute.setIdAttribute(-1);

            model.addAttribute("attribute", attribute);
            model.addAttribute("attributeTypes", AttributeType.values());

            return "atributo";
        }
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("attribute") AttributeUI theAttribute) {
        Attribute attribute = this.attributeRepository.findById(theAttribute.getIdAttribute()).orElse(new Attribute());
        boolean isNew = attribute.getId() == null;

        attribute.setAttributeName(theAttribute.getName());
        attribute.setAttributeType(theAttribute.getType());
        attribute.setCreatedAt(Instant.now());

        if (isNew) {
            Account account = this.accountRepository.findById(1).get();
            attribute.setAccountIdFk(account);

            List<Account> accounts = attribute.getAccounts();
            accounts.add(account);
            attribute.setAccounts(accounts);

            this.attributeRepository.save(attribute);

            List<Attribute> attributes = account.getAttributes();
            attributes.add(attribute);
            account.setAttributes(attributes);
        }

        this.attributeRepository.save(attribute);

        return "redirect:/attributes/";
    }

    @GetMapping("/editar")
    public String doEditar (@RequestParam("id") Integer id, Model model) {
        Attribute attribute = this.attributeRepository.findById(id).get();
        AttributeUI attributeUI = new AttributeUI();
        attributeUI.setIdAttribute(attribute.getId());
        attributeUI.setName(attribute.getAttributeName());
        attributeUI.setAccount(attribute.getAccountIdFk());
        attribute.setAttributeType(attribute.getAttributeType());
        model.addAttribute("attributeModel", new AttributeUI());
        model.addAttribute("attribute", attributeUI);
        model.addAttribute("attributeTypes", AttributeType.values());

        return "/Attribute/editarAtributo";
    }

    @GetMapping("/details")
    public String doDetails(@RequestParam("id") Integer id, Model model){
        Attribute attribute = this.attributeRepository.findById(id).get();
        model.addAttribute("attribute", attribute);
        return "consultarAtributo";
    }

}
