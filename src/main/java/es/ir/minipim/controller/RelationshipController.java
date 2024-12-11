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
        Account account = this.accountRepository.findById(1).get();
        List<Relationship> lista = account.getRelationships();
        model.addAttribute("account", account);
        model.addAttribute("lista", lista);

        return "listadoRelaciones";
    }

    @GetMapping("/delete")
    public String doBorrar(@RequestParam("id") Integer id, HttpSession session) {

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
    public String doNuevo(Model model, HttpSession session) {

        // Crear un objeto RelationshipUI para vincularlo al formulario
        RelationshipUI relationship = new RelationshipUI();
        relationship.setIdRelationship(-1);
        relationship.setAccount(this.accountRepository.findById(1).get());

        // Obtener la lista de productos asociados a la cuenta
        Account account = this.accountRepository.findById(1).get();
        List<Product> listaprod = account.getProducts();

        model.addAttribute("account", account);
        model.addAttribute("listaprod", listaprod);
        model.addAttribute("relacion", relationship);

        return "crearRelacion";
    }

    @RequestMapping("/save")
    public String doGuardarRelacion(
            @RequestParam("name") String name,
            @RequestParam("product1") Integer product1Id,
            @RequestParam("product2") Integer product2Id,
            HttpSession session) {

        // Validar que se seleccionaron dos productos diferentes
        if (product1Id.equals(product2Id)) {
            session.setAttribute("error", "Los productos seleccionados no pueden ser los mismos.");
            return "redirect:/relationships/new";
        }

        // Buscar los productos seleccionados
        Product product1 = this.productRepository.findById(product1Id).orElse(null);
        Product product2 = this.productRepository.findById(product2Id).orElse(null);
        Account account = this.accountRepository.findById(1).get();

        if (product1 != null && product2 != null) {
            // Crear la nueva relación
            Relationship relationship = new Relationship();
            relationship.setName(name);
            account.getRelationships().add(relationship);
            relationship.setProduct1IdFk(product1); // Asignar el primer producto
            relationship.setProduct2IdFk(product2); // Asignar el segundo producto

            // Guardar la relación
            this.relationshipRepository.save(relationship);
            this.accountRepository.save(account);

            System.out.println("Relación guardada con éxito: " + relationship.getId());
        } else {
            System.err.println("Error: uno de los productos no existe");
        }


        return "redirect:/relationships/";
    }



}
