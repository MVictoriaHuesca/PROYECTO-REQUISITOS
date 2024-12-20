package es.ir.minipim.controller;

import es.ir.minipim.dao.*;
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

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected ProductCategoryRepository productCategoryRepository;

    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        List<AccountCategory> lista = this.accountCategoryRepository.findByAccountId(1);
        model.addAttribute("lista", lista);
        return "listadoCategorias";
    }

    @GetMapping("/delete")
    public String doBorrar (@RequestParam("id") Integer id, HttpSession session, Model model) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        Category category = this.categoryRepository.findById(id).get();
        // Eliminar attributo de los productos asociados
        List<ProductCategory> productCategories = category.getProductCategories();
        for(ProductCategory pc : productCategories){
            Product p = this.productRepository.findById(pc.getProductIdFk().getId()).get();
            List<ProductCategory> categories = p.getProductCategories();
            categories.remove(pc);
            p.setProductCategories(categories);
            this.productRepository.save(p);
        }
        this.productCategoryRepository.deleteAll(productCategories);

        // Eliminar atributo de las cuentas asociadas
        List<Account> accounts = category.getAccounts();
        for(Account a : accounts){
            List<Category> categories = a.getCategories();
            categories.remove(category);
            a.setCategories(categories);
            this.accountRepository.save(a);
        }

        this.categoryRepository.delete(category);

        return "redirect:/categories/";
    }

    @GetMapping("/new")
    public String doNuevo (Model model, HttpSession session) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        CategoryUI categoria = new CategoryUI();
        categoria.setIdCategory(-1);
        categoria.setAccount(this.accountRepository.findById(1).get());
        model.addAttribute("categoria", categoria);

        return "crearCategoria";    //"newCategory"
    }

    @GetMapping("/edit")
    public String doEditar(@RequestParam("id") Integer id, Model model, HttpSession session) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
        Category categoria = this.categoryRepository.findById(id).get();
        CategoryUI categoryUI = new CategoryUI();
        categoryUI.setIdCategory(categoria.getId());
        categoryUI.setName(categoria.getCategoryName());
        categoryUI.setAccount(categoria.getAccountIdFk());
        model.addAttribute("category", categoryUI);
        model.addAttribute("categoryModel", new CategoryUI());

        return "editarCategoria";
    }

    @PostMapping("/save")
    public String doGuardar (@ModelAttribute("category") CategoryUI theCategory, HttpSession session, Model model) {
        Account accountCabecera = (Account) session.getAttribute("account");
        model.addAttribute("account", accountCabecera);
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
