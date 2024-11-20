package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.dto.AccountDto;
import es.ir.minipim.entity.AccountEntity;
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
        Integer id = (Integer) session.getAttribute("account");
        AccountEntity account = this.accountRepository.findById(id).orElse(null);
        model.addAttribute("account", account.toDto());
        return "home";
    }
}
