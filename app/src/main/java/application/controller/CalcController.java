package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    @RequestMapping("/calc")
    public String form() {
        return "calc/form";
    }

    @RequestMapping("/soma")
    public String soma(Model ui,
            @RequestParam("numA") int nA,
            @RequestParam("numB") int nB) {
        ui.addAttribute("resultado", nA + nB);
        return "calc/form";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String calc(Model ui,
    @RequestParam("numA") int nA,
    @RequestParam("numB") int nB,
    @RequestParam("operacao") String op) {
        double resultado = 0;
        switch (op) {
            case "soma":
                resultado = nA + nB;
                break;
            case "subtracao":
                resultado = nA - nB;
                break;
            case "multiplicacao":
                resultado = nA * nB;
                break;
            case "divisao":
                resultado = nA / nB;
                break;
        }
        ui.addAttribute("resultado", resultado);
        return "calc/form";
    }
}
