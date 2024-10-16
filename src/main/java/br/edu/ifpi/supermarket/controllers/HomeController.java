package br.edu.ifpi.supermarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHomePage(@RequestParam("nome") String nome,
                              Model model){
        model.addAttribute("nome", nome);
        return "homepage";
    }
}
