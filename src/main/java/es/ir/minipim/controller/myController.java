package es.ir.minipim.controller;

import es.ir.minipim.dao.AccountRepository;
import es.ir.minipim.dao.ProductRepository;
import es.ir.minipim.entity.AccountEntity;
import es.ir.minipim.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class myController {
/*
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<AccountEntity> accounts = accountRepository.findAll();
        model.addAttribute("accounts", accounts);
        return "index";
    }
*/
}


