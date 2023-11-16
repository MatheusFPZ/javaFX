package com.example.caixamercado.model;

import javafx.beans.property.*;

public class Produto {

    private final IntegerProperty codigo = new SimpleIntegerProperty();
    private final StringProperty descricao = new SimpleStringProperty();
    private final DoubleProperty valorUnitario = new SimpleDoubleProperty();
    private final IntegerProperty quantidade = new SimpleIntegerProperty();
    private final DoubleProperty total = new SimpleDoubleProperty();
    private final IntegerProperty contador = new SimpleIntegerProperty();



    public Produto(int codigo, String descricao, double valorUnitario) {
        this.codigo.set(codigo);
        this.descricao.set(descricao);
        this.valorUnitario.set(valorUnitario);
    }


    // Métodos de acesso para código
    public int getCodigo() {
        return codigo.get();
    }

    public void setCodigo(int codigo) {
        this.codigo.set(codigo);
    }

    public IntegerProperty codigoProperty() {
        return codigo;
    }

    // Métodos de acesso para descrição
    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    // Métodos de acesso para valor unitário
    public double getValorUnitario() {
        return valorUnitario.get();
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario.set(valorUnitario);
    }

    public DoubleProperty valorUnitarioProperty() {
        return valorUnitario;
    }

    // Métodos de acesso para quantidade
    public int getQuantidade() {
        return quantidade.get();
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.set(quantidade);
    }

    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }

    // Métodos de acesso para subtotal
    public double getSubtotal() {
        return total.get();
    }

    public void setSubtotal(double subtotal) {
        this.total.set(subtotal);
    }

    public DoubleProperty subtotalProperty() {
        return total;
    }

    // Métodos de acesso para contador
    public int getContador() {
        return contador.get();
    }

    public void setContador(int contador) {
        this.contador.set(contador);
    }

    public IntegerProperty contadorProperty() {
        return contador;
    }



    public  void limpar(){

        this.descricao.set(" ");
        this.total.set(0);
        this.valorUnitario.set(0);
        this.codigo.set(0);
    }
}