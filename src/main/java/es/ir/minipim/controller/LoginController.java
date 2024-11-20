package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.dto.AccountDto;
import es.ir.minipim.entity.AccountEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController extends BaseController {

    @Autowired
    protected AccountRepository accountRepository;
    @GetMapping("/")
    public String doLogin(HttpSession session) {
        AccountEntity account = this.accountRepository.findById(1).orElse(null);
        session.setAttribute("account", account.toDto().getAccountId());
        return "redirect:/home/";    //ESTO ES ASÍ HASTA QUE IMPLEMENTEMOS EL LOGIN BIEN
    }
}
