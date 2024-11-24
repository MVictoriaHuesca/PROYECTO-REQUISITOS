package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountCategoryRepository;
import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.dao.CategoryRepository;
import es.ir.minipim.entity.*;
import es.ir.minipim.ui.AttributeUI;
import es.ir.minipim.ui.CategoryUI;
import es.ir.minipim.ui.ProductDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected AccountCategoryRepository accountCategoryRepository;

    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        List<AccountCategory> lista = this.accountCategoryRepository.findByAccountId(1);
        model.addAttribute("lista", lista);
        return "listadoCategorias";
    }

    @GetMapping("/delete")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session) {

        this.categoryRepository.deleteById(id);

        return "redirect:/categories/";
    }

    @GetMapping("/new")
    public String doNuevo (Model model, HttpSession session) {

        Category categoria = new Category();
        model.addAttribute("category", categoria);

        return "crearCategoria";    //"newCategory"
    }

    @GetMapping("/edit")
    public String doEditar(@RequestParam("id") Integer id, Model model){
        Category categoria = this.categoryRepository.findById(id).get();
        model.addAttribute("categoria", categoria);


        return "editarCategoria";
    }

    @PostMapping("/save")
    public String doGuardar (@ModelAttribute("category") CategoryUI theCategory, HttpSession session) {
        // Carga de la cuenta asociada
        Account account = this.accountRepository.findById(1).get();
        Category categoria;

        // Si el ID de la categoría es null, crea una nueva categoría, sino, actualiza la existente
        if (theCategory.getIdCategory() != null) {
            categoria = this.categoryRepository.findById(theCategory.getIdCategory())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        } else {
            categoria = new Category(); // Nueva categoría
        }
        // Actualización de la categoría
        categoria.setCategoryName(theCategory.getName());  // Asegúrate de que 'theCategory.getName()' no sea null
        categoria.setCreatedAt(Instant.now());
        this.categoryRepository.save(categoria);    /// ME DA ERROR EN ESTA LINEA

        // Relación AccountCategory (opcional, solo si necesitas crearla)
        AccountCategory accountCategory = new AccountCategory();
        accountCategory.setAccountIdFk(account);
        accountCategory.setCategoryIdFk(categoria);

        // Guardado final (actualización de la relación)
        account.getCategories().add(categoria);
        this.accountRepository.save(account);

        return "redirect:/categories/";
    }
}
