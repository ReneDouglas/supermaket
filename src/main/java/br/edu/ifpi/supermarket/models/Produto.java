package br.edu.ifpi.supermarket.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


public class Produto {

    private UUID id;
    private String nome;
    private String descricao;
    private BigDecimal precoDeCusto;
    private int estoque;
    private Categoria categoria;
    private LocalDate dataValidade;

    public Produto(){}

    public Produto(UUID id, String nome, String descricao, BigDecimal precoDeCusto, int estoque, Categoria categoria, LocalDate dataValidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoDeCusto = precoDeCusto;
        this.estoque = estoque;
        this.categoria = categoria;
        this.dataValidade = dataValidade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(BigDecimal precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
