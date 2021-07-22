package com.spring.analisisdatos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
    private static final String TITLE = "titulo";

    @GetMapping({ "/index", "", "/" })
    public String index() {
        return "vistas/params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "") String textoOtro,
            Model model) {
        model.addAttribute(TITLE, "Spring leer parametros.");
        model.addAttribute("resultado", "El texto enviado es : ".concat(textoOtro));
        return "vistas/params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam(required = false, defaultValue = "") String saludo,
            @RequestParam Long numero, Model model) {
        model.addAttribute(TITLE, "Spring leer parametros.");
        model.addAttribute("resultado", "El texto enviado es : ".concat(saludo));
        model.addAttribute("numero", "El número enviado es : ".concat(numero.toString()));
        return "vistas/params/ver";
    }
    
    @GetMapping("/mix-params-requests")
    public String param(HttpServletRequest request, Model model) {
        model.addAttribute(TITLE, "Spring leer parametros.");
        model.addAttribute("resultado", "El texto enviado es : ".concat(request.getParameter("saludo")));
        model.addAttribute("numero", "El número enviado es : ".concat(request.getParameter("numero")));
        return "vistas/params/ver";
    }

}
