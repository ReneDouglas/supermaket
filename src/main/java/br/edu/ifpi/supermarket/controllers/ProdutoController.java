package br.edu.ifpi.supermarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping("/cadastrar")
    public String getCadastroProduto(Model model) {
        return "productManagement/produto-cadastro";
    }

}
