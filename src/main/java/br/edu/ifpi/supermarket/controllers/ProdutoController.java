package br.edu.ifpi.supermarket.controllers;

import br.edu.ifpi.supermarket.models.Categoria;
import br.edu.ifpi.supermarket.models.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();
    private List<Categoria> categorias;

    public ProdutoController() {
        this.categorias = List.of(
                new Categoria(1, "Alimentos"),
                new Categoria(2, "Laticínios"),
                new Categoria(3, "Bebidas")
        );
    }

    @GetMapping
    public String getPaginaProduto(Model model,
                                   @RequestParam(required = false) UUID id) {

        model.addAttribute("categorias", categorias);

        if (id != null) {
            Produto produto = produtos
                    .stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst().get();
            model.addAttribute("produto", produto);
            return "productManagement/produto-cadastro";
        }

        model.addAttribute("produto", new Produto());
        return "productManagement/produto-cadastro";
    }

    @GetMapping("/listar")
    public String getProductsPage(Model model) {
        model.addAttribute("produtos", produtos);
        return "productManagement/produto-listar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Produto produto) {

        produto.setId(UUID.randomUUID());
        Categoria categoria = categorias
                .stream()
                .filter(c -> c.getId().equals(produto.getCategoria().getId()))
                .findFirst()
                .get();
        produto.setCategoria(categoria);
        produtos.add(produto);

        return "redirect:/produtos";
    }

    @PostMapping("/editar")
    public String atualizar(@ModelAttribute Produto produto, Model model) {

        produtos.forEach(p -> {
            if (p.getId().equals(produto.getId())) {

                p.setNome(produto.getNome());
                p.setPrecoDeCusto(produto.getPrecoDeCusto());
                p.setEstoque(produto.getEstoque());
                p.setDescricao(produto.getDescricao());
                p.setCategoria(produto.getCategoria());
                p.setDataValidade(produto.getDataValidade());

                Categoria categoria = categorias
                        .stream()
                        .filter(c -> c.getId().equals(produto.getCategoria().getId()))
                        .findFirst()
                        .get();
                p.setCategoria(categoria);
            }
        });

        return "redirect:/produtos/listar";
    }

    @DeleteMapping("/{id}/deletar")
    public String deletar(@PathVariable UUID id) {

        produtos.removeIf(p -> p.getId().equals(id));
        return "redirect:/produtos/listar";
    }



}
