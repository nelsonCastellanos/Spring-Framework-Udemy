package com.spring.analisisdatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariablesRutaController {
    private static final String TITLE = "Pasando parametros url usando ";

    @GetMapping({ "/", "" })
    public String variable(Model model) {
        model.addAttribute("titulo", TITLE);
        return "vistas/variables/index";
    }

    @GetMapping({ "/string/{texto}/{number}" , "/string/{texto}/", "/string/{texto}"})
    public String variable(@PathVariable String texto, @PathVariable(required = false) Integer number, Model model) {
        model.addAttribute("titulo", TITLE);
        model.addAttribute("resultado", "El texto enviado en PathVariable texto es : ".concat(texto));
        model.addAttribute("numero",
                "El número enviado en PathVariable numero es : ".concat(number != null ? number.toString() : ""));
        return "vistas/variables/ver";
    }

}
