package es.ir.minipim.controller;

import es.ir.minipim.dao.CategoryRepository;
import es.ir.minipim.entity.*;
import es.ir.minipim.ui.Attribute;
import es.ir.minipim.ui.Category;
import es.ir.minipim.dao.AccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Autowired
    protected AccountRepository accountRepository;

    @GetMapping("/")
    public String doListar(Model model, HttpSession session){
        List<CategoryEntity> lista = this.categoryRepository.findAll();
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

        CategoryEntity categoria = new CategoryEntity();
        model.addAttribute("category", categoria);

        List<String> nombres = new ArrayList<>();
        List<CategoryEntity> categorias = this.categoryRepository.findAll();
        for(CategoryEntity c : categorias){
            nombres.add(c.getCategoryName());
        }
        model.addAttribute("nombres", nombres);

        return "añadirCategoria";
    }

    @PostMapping("/save")
    public String doGuardar(@RequestParam("categoryName") String categoryName, Model model, HttpSession session) {
        String error = null;

        // Validaciones de la categoría
        if (categoryName == null || categoryName.trim().isEmpty()) {
            error = "The category name cannot be empty.";
        }
        if (categoryName.length() > 50) {
            error = "The category name cannot exceed 50 characters.";
        }

        if (error == null) {
            List<CategoryEntity> categorias = categoryRepository.findAll();
            for (CategoryEntity categoria : categorias) {
                if (categoria.getCategoryName().equalsIgnoreCase(categoryName)) {
                    error = "A category with this name already exists.";
                    break;
                }
            }
        }

        if (error != null) {
            model.addAttribute("error", error);
            return "añadirCategoria";  // Regresar a la vista con error
        }

        // Guardar la nueva categoría
        CategoryEntity nuevaCategoria = new CategoryEntity();
        nuevaCategoria.setCategoryName(categoryName);
        nuevaCategoria.setCreatedAt(new Timestamp(new Date().getTime()));
        categoryRepository.save(nuevaCategoria);

        return "redirect:/categories/";  // Redirigir a la lista de categorías
    }

    @PostMapping("/guardar")
    public String doGuardar (@ModelAttribute("category") Category theCategory, HttpSession session) {
        CategoryEntity category = this.categoryRepository.findById(theCategory.getIdCategory()).orElse(new CategoryEntity());

        //attribute.setAccountByAccountIdFk(this.accountRepository.findById((Integer) session.getAttribute("account")).get());
        category.setAccountByAccountIdFk(this.accountRepository.findById(1).get());
        category.setCategoryName(theCategory.getName());
        category.setCreatedAt(Timestamp.valueOf(LocalDate.now().atStartOfDay()));

        Integer numProd = category.getProductCategoriesByCategoryId().size();

        category.setProductCategoriesByCategoryId();

        this.categoryRepository.save(category);
        return "redirect:/categories/";
    }


    @PostMapping("/edit")
    public String actualizarCategoria(@RequestParam("categoryId") Integer id,
                                      @RequestParam("categoryNameUpdated") String nuevoNombre,
                                      RedirectAttributes redirectAttributes) {
        // Buscar la categoría por ID
        CategoryEntity categoria = categoryRepository.findById(id).orElse(null);

        if (categoria == null) {
            redirectAttributes.addFlashAttribute("error", "Category not found.");
            return "redirect:/categories";
        }

        // Actualizar el nombre y guardar
        categoria.setCategoryName(nuevoNombre);
        categoryRepository.save(categoria);

        redirectAttributes.addFlashAttribute("success", "Category updated successfully.");
        return "redirect:/categories";
    }

    @GetMapping("/cancel")
    public String doCancelar() {
        return "redirect:/categories/";
    }


}
