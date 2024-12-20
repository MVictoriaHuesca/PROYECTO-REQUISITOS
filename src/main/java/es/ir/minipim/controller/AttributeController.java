package es.ir.minipim.controller;

import es.ir.minipim.dao.*;

import es.ir.minipim.entity.*;
import es.ir.minipim.ui.AttributeUI;
import jakarta.servlet.http.HttpSession;
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
    @Autowired
    protected ProductAttributeRepository productAttributeRepository;

    @GetMapping("/")
    public String doListar(Model model, HttpSession session) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);

        List<Attribute> lista = this.attributeRepository.listarAtributosCuenta(1);
        model.addAttribute("attributesList", lista);
        return "listadoAtributos";
    }

    @GetMapping("/borrar")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session, Model model) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);

        Attribute attribute = this.attributeRepository.findById(id).get();

        List<ProductAttribute> productAttributes = attribute.getProductAttributes();
        for (ProductAttribute pa : productAttributes) {
            this.productAttributeRepository.delete(pa);
        }

        List<AccountAttribute> accountAttributes = this.accountAttributeRepository.findByAttributeId(attribute.getId());
        for (AccountAttribute aa : accountAttributes) {
            this.accountAttributeRepository.delete(aa);
        }

        List<Account> accounts = attribute.getAccounts();
        for (Account account : accounts) {
            account.getAttributes().remove(attribute);
            this.accountRepository.save(account);
        }

        this.attributeRepository.delete(attribute);

        return "redirect:/attributes/";
    }

    @GetMapping("/crear")
    public String doNuevo (Model model, HttpSession session) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
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
    public String doGuardar (@ModelAttribute("attribute") AttributeUI theAttribute, Model model, HttpSession session) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);

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

            List<Product> products = account.getProducts();
            for (Product p : products) {
                ProductAttribute pa = new ProductAttribute();
                ProductAttributeId paId = new ProductAttributeId();
                paId.setProductIdFk(p.getId());
                paId.setAttributeIdFk(attribute.getId());
                paId.setAccountIdFk(account.getId());
                pa.setId(paId);
                pa.setProductIdFk(p);
                pa.setAttributeIdFk(attribute);
                pa.setValue("Undefined");
                pa.setAccountIdFk(account);
                this.productAttributeRepository.save(pa);
            }

        }

        this.attributeRepository.save(attribute);

        return "redirect:/attributes/";
    }

    @GetMapping("/editar")
    public String doEditar (@RequestParam("id") Integer id, Model model, HttpSession session) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);

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
    public String doDetails(@RequestParam("id") Integer id, Model model, HttpSession session) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        Attribute attribute = this.attributeRepository.findById(id).get();
        model.addAttribute("attribute", attribute);
        return "consultarAtributo";
    }

}
