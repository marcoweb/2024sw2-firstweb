package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model ui,
            @RequestParam("nome") String nome) {
        String msg = "Olá " + nome + "!!!";
        ui.addAttribute("message", msg);
        return "index";
    }
}
