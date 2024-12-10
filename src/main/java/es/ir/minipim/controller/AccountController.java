package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.entity.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{

    @Autowired
    protected AccountRepository accountRepository;

    @GetMapping("/info")
    public String doInfo(@RequestParam("id") Integer id, HttpSession session, Model model) {
        Account account = this.accountRepository.findById(id).orElse(null);
        if(account == null) {
            return "redirect:/";
        }
        model.addAttribute("account", account);
        List<Account> users = this.accountRepository.findByGroupName(account.getGroupName(), account.getId());
        model.addAttribute("users", users);
        return "/Account/mostrarCuenta";
    }

    @GetMapping("/export")
    @ResponseBody
    public Map<String, Object> doExport(HttpSession session, Model model){
        Map<String, Object> json = new LinkedHashMap<>();

        Account account = this.accountRepository.findById(1).orElse(null);

        List<Account> users = this.accountRepository.findByGroupName(account.getGroupName(), account.getId());
        json.put("AccountName", account.getAccountName());
        json.put("email", account.getEmailAddress());
        json.put("CreatedAt", account.getCreatedAt());
        json.put("Company", account.getGroupName());
        json.put("NumAttributes", account.getAttributes().size());
        json.put("NumProducts", account.getProducts().size());
        json.put("NumCategories", account.getCategories().size());
        json.put("NumRelationships", account.getRelationships().size());
        Map<String, Object> usersJSON = new LinkedHashMap<>();
        for(Account user : users){
            usersJSON.put("AccountName", user.getAccountName());
            usersJSON.put("email", user.getEmailAddress());
            usersJSON.put("CreatedAt", user.getCreatedAt());
        }
        json.put("Users", usersJSON);

        return json;
    }
}
