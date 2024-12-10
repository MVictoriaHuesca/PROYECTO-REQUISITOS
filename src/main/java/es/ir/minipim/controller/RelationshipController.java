package es.ir.minipim.controller;


import es.ir.minipim.dao.*;
import es.ir.minipim.entity.*;
import es.ir.minipim.ui.CategoryUI;
import es.ir.minipim.ui.RelationshipUI;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/relationships")
public class RelationshipController {

    @Autowired
    protected RelationshipRepository relationshipRepository;

    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected AccountRelationshipRepository accountRelationshipRepository;

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected ProductRelationshipRepository productRelationshipRepository;


    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        List<AccountRelationship> lista = this.accountRelationshipRepository.findByAccountId(1);
        model.addAttribute("lista", lista);
        return "listadoRelaciones";
    }

    @GetMapping("/delete")
    public String doBorrar(@RequestParam("id") Integer id, HttpSession session, Model model) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        // Buscar la relación a eliminar
        Relationship relationship = this.relationshipRepository.findById(id).get();

        // Eliminar relacion de los productos asociados
        List<ProductRelationship> productRelationships = relationship.getProductRelationships();
        for(ProductRelationship pr : productRelationships){
            Product p = this.productRepository.findById(pr.getProductIdFk().getId()).get();
            List<ProductRelationship> relationships = p.getProductRelationships();
            relationships.remove(pr);
            p.setProductRelationships(relationships);
            this.productRepository.save(p);
        }
        this.productRelationshipRepository.deleteAll(productRelationships);

        // Eliminar relacion de las cuentas asociadas
        List<Account> accounts = relationship.getAccounts();
        for(Account a : accounts){
            List<Relationship> relationships = a.getRelationships();
            relationships.remove(relationship);
            a.setRelationships(relationships);
            this.accountRepository.save(a);
        }

        this.relationshipRepository.delete(relationship);

        return "redirect:/relationships/";
    }


    @GetMapping("/new")
    public String doNuevo (Model model, HttpSession session) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        RelationshipUI relationship = new RelationshipUI();
        relationship.setIdRelationship(-1);
        relationship.setAccount(this.accountRepository.findById(1).get());
        model.addAttribute("relacion", relationship);

        return "crearRelacion";    //"newCategory"
    }
}
