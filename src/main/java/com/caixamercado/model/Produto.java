package com.caixamercado.model;

import javafx.beans.property.*;

public class Produto {

    private final IntegerProperty codigo = new SimpleIntegerProperty();
    private final StringProperty descricao = new SimpleStringProperty();
    private final DoubleProperty valorUnitario = new SimpleDoubleProperty();
    private final IntegerProperty quantidade = new SimpleIntegerProperty();
    private final DoubleProperty total = new SimpleDoubleProperty();
    private final IntegerProperty contador = new SimpleIntegerProperty();
    private final DoubleProperty subtotal = new SimpleDoubleProperty();
    private final IntegerProperty imprimiu = new SimpleIntegerProperty();

    private final IntegerProperty categoria = new SimpleIntegerProperty();
    private final IntegerProperty quantidadeMinimaDesconto = new SimpleIntegerProperty();
    private final DoubleProperty percentualDesconto = new SimpleDoubleProperty();




    public Produto(int codigo, String descricao, double valorUnitario, int categoria,int quantidadeMinimaDesconto, double percentualDesconto) {
        this.codigo.set(codigo);
        this.descricao.set(descricao);
        this.valorUnitario.set(valorUnitario);
        this.categoria.set(categoria);
        this.quantidadeMinimaDesconto.set(quantidadeMinimaDesconto);
        this.percentualDesconto.set(percentualDesconto);

    }
    @Override
    public String toString() {
        return "Produto: " + getDescricao() + ", Quantidade: " + getQuantidade() + ", Valor Unitário: " + getValorUnitario();
    }

    public int getCategoria() {
        return categoria.get();
    }

    public IntegerProperty categoriaProperty() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria.set(categoria);
    }

    // Métodos de acesso para código
    public int getCodigo() {
        return codigo.get();
    }

    public void setCodigo(int codigo) {
        this.codigo.set(codigo);
    }

    public int getImprimiu() {
        return imprimiu.get();
    }

    public IntegerProperty imprimiuProperty() {
        return imprimiu;
    }

    public void setImprimiu(int imprimiu) {
        this.imprimiu.set(imprimiu);
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
    public double getTotal() {
        return total.get();
    }

    public void setTotal(double total) {
        this.total.set(total);
    }

    public double getSubtotal() {
        return subtotal.get();
    }

    public void setSubtotal(double subtotal) {
        this.subtotal.set(subtotal);
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
    public int getQuantidadeMinimaDesconto() {
        return quantidadeMinimaDesconto.get();
    }

    public void setQuantidadeMinimaDesconto(int quantidadeMinimaDesconto) {
        this.quantidadeMinimaDesconto.set(quantidadeMinimaDesconto);
    }

    public IntegerProperty quantidadeMinimaDescontoProperty() {
        return quantidadeMinimaDesconto;
    }

    // Métodos de acesso para percentual de desconto
    public double getPercentualDesconto() {
        return percentualDesconto.get();
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto.set(percentualDesconto);
    }

    public DoubleProperty percentualDescontoProperty() {
        return percentualDesconto;
    }

    // Método para calcular o desconto com base na quantidade comprada
    public double calcularDesconto(int quantidadeComprada) {
        if (quantidadeComprada >= getQuantidadeMinimaDesconto()) {
            return quantidadeComprada * getValorUnitario() * (getPercentualDesconto() / 100.0);
        }
        return 0.0; // Retorna zero caso não atinja a quantidade mínima para desconto
    }


    public  void limpar(){

        this.descricao.set(" ");
        this.total.set(0);
        this.valorUnitario.set(0);
        this.codigo.set(0);
        this.subtotal.set(0);
    }
}