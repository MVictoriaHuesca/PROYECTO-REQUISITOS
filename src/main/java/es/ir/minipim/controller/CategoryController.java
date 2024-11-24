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

        CategoryUI categoria = new CategoryUI();
        categoria.setIdCategory(-1);
        model.addAttribute("categoria", categoria);

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
        Category category = this.categoryRepository.findById(theCategory.getIdCategory()).orElse(new Category());
        boolean isNew = category.getId() == null;

        category.setCategoryName(theCategory.getName());
        category.setCreatedAt(Instant.now());


        if (isNew) {
            Account account = this.accountRepository.findById(1).get();
            category.setAccountIdFk(account);

            List<Account> accounts = category.getAccounts();
            accounts.add(account);
            category.setAccounts(accounts);

            this.categoryRepository.save(category);

            List<Category> categories = account.getCategories();
            categories.add(category);
            account.setCategories(categories);
        }

        this.categoryRepository.save(category);

        return "redirect:/categories/";
    }
}
