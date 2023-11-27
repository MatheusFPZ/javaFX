package com.example.caixamercado.model;

import java.util.HashMap;

class DescontoProduto {
    private double valorDesconto;
    private int quantidadeMinima;
    private int quantidadeExistente;

    public DescontoProduto(double valorDesconto, int quantidadeMinima, int quantidadeExistente) {
        this.valorDesconto = valorDesconto;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeExistente = quantidadeExistente;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public int getQuantidadeExistente() {
        return quantidadeExistente;
    }

    public void setQuantidadeExistente(int quantidadeExistente) {
        this.quantidadeExistente = quantidadeExistente;
    }
}