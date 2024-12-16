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
import org.springframework.web.bind.annotation.ModelAttribute;
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

        if(session.getAttribute("error") != null) {
            model.addAttribute("error", session.getAttribute("error"));
            session.removeAttribute("error");
        }
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
        int numeroRelaciones = this.relationshipRepository.findAll().size();
        if(numeroRelaciones >=3){
            session.setAttribute("error", "Could not make more than 3 relationship.");
            return "redirect:/relationships/";
        }
        RelationshipUI relationship = new RelationshipUI();
        relationship.setIdRelationship(-1);
        relationship.setAccount(this.accountRepository.findById(1).get());

        // Obtener la lista de productos asociados a la cuenta
        Account account = this.accountRepository.findById(1).get();
        List<Product> listaprod = account.getProducts();

        model.addAttribute("account", account);
        model.addAttribute("lista", listaprod);
        model.addAttribute("relacion", relationship);
        if(session.getAttribute("error") != null) {
            model.addAttribute("error", session.getAttribute("error"));
            session.removeAttribute("error");
        }
        return "crearRelacion";
    }

    @RequestMapping("/save")
    public String doGuardarRelacion(@ModelAttribute("relacion") RelationshipUI relacion, HttpSession session) {
        // Buscar los productos seleccionados
        Product product1 = this.productRepository.findById(relacion.getProduct_1()).orElse(null);
        Product product2 = this.productRepository.findById(relacion.getProduct_2()).orElse(null);
        Account account = this.accountRepository.findById(1).get();

        // Validar que se haya completado el campo nombre
        if (relacion.getName().isEmpty()) {
            session.setAttribute("error", "You should name the relationship.");
            return "redirect:/relationships/new";
        }

        int relaciones = this.relationshipRepository.existeNombreRelacion(relacion.getName());
        if(relaciones > 0){
            session.setAttribute("error", "There is already one relationship with the same name.");
            return "redirect:/relationships/new";
        }

        // Validar que se seleccionaron dos productos diferentes
        if (product1 == null || product2 ==null) {
            session.setAttribute("error", "You must select two products.");
            return "redirect:/relationships/new";
        }

        // Validar que se seleccionaron dos productos diferentes
        if (product1.equals(product2)) {
            session.setAttribute("error", "You can't select the the same product.");
            return "redirect:/relationships/new";
        }

        if (product1 != null && product2 != null) {
            // Crear la nueva relación
            Relationship relationship = new Relationship();
            relationship.setName(relacion.getName());
            relationship.setProduct1IdFk(product1); // Asignar el primer producto
            relationship.setProduct2IdFk(product2); // Asignar el segundo producto

            this.relationshipRepository.save(relationship);

            ProductRelationship productRelationship1 = new ProductRelationship();

            ProductRelationshipId productRelationshipId1 = new ProductRelationshipId();
            productRelationshipId1.setProductIdFk(product1.getId());
            productRelationshipId1.setRelationshipIdFk(relationship.getId());
            productRelationshipId1.setAccountIdFk(account.getId());

            productRelationship1.setId(productRelationshipId1);
            productRelationship1.setProductIdFk(product1);
            productRelationship1.setRelationshipIdFk(relationship);
            productRelationship1.setAccountIdFk(account);

            ProductRelationship productRelationship2 = new ProductRelationship();

            ProductRelationshipId productRelationshipId2 = new ProductRelationshipId();
            productRelationshipId2.setProductIdFk(product2.getId());
            productRelationshipId2.setRelationshipIdFk(relationship.getId());
            productRelationshipId2.setAccountIdFk(account.getId());

            productRelationship2.setId(productRelationshipId2);
            productRelationship2.setProductIdFk(product2);
            productRelationship2.setRelationshipIdFk(relationship);
            productRelationship2.setAccountIdFk(account);

            // Guardar la relación
            this.productRelationshipRepository.save(productRelationship1);
            this.productRelationshipRepository.save(productRelationship2);

            account.getRelationships().add(relationship);

            this.accountRepository.save(account);

            System.out.println("Relación guardada con éxito: " + relationship.getId() + " -> " +
                    relationship.getProduct1IdFk().getLabel() + " / " + relationship.getProduct2IdFk().getLabel());
        } else {
            System.err.println("Error: uno de los productos no existe");
        }


        return "redirect:/relationships/";
    }
}
