package br.edu.ifpi.supermarket.controllers;

import br.edu.ifpi.supermarket.models.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    @GetMapping()
    public String getCadastroProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "productManagement/produto-cadastro";
    }

    @PostMapping("/save")
    public String cadastrar(@ModelAttribute Produto produto) {
        produto.setId(UUID.randomUUID());
        produtos.add(produto);
        return "redirect:/produtos";
    }

}
