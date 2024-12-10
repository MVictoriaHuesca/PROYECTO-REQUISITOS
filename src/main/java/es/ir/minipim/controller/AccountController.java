package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.entity.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{

    @Autowired
    protected AccountRepository accountRepository;

    @GetMapping("/info")
    public String doInfo(HttpSession session, Model model, Integer id) {
        Account account = this.accountRepository.findById(id).orElse(null);
        if(account == null) {
            return "redirect:/";
        }
        model.addAttribute("account", account);
        List<Account> users = this.accountRepository.findByGroupName(account.getGroupName());
        model.addAttribute("users", users);
        return "/Account/mostrarCuenta";
    }


}
