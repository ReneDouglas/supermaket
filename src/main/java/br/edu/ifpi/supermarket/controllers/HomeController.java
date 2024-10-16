package br.edu.ifpi.supermarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class HomeController {

    private Logger logger = Logger.getLogger(HomeController.class.getName());

    @GetMapping("/home")
    public String getHomePage(@RequestParam("nome") String nome,
                              Model model){
        model.addAttribute("nome", nome);
        logger.severe("printando mensagem");
        return "homepage";
    }
}
