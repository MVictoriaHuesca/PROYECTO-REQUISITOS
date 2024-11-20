package es.ir.minipim.controller;

import es.ir.minipim.dto.AccountDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")
    public String doHome(HttpSession session, Model model) {
        AccountDto account = (AccountDto) session.getAttribute("usuario");
        model.addAttribute("usuario", "usuarioprueba");
        return "home";
    }
}
