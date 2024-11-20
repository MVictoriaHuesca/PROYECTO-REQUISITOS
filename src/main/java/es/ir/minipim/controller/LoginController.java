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
    public String doLogin(HttpSession session, Model model) {
        AccountDto account = this.accountRepository.findById(1).get().toDto();
        session.setAttribute("account", account);
        return "/home";    //ESTO ES ASÍ HASTA QUE IMPLEMENTEMOS EL LOGIN BIEN
    }
}
