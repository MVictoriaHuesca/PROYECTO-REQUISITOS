package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.entity.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

    @Autowired
    protected AccountRepository accountRepository;
    @GetMapping("/")
    public String doHome(HttpSession session, Model model) {
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        Account account = (Account) session.getAttribute("account");

        model.addAttribute("account", account);
        return "home";

    }
}
