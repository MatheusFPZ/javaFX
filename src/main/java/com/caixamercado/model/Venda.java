package com.caixamercado.model;
import java .util.HashMap;

public class Venda {
    private HashMap<Integer, DescontoProduto> produtos;

    public Venda() {
        this.produtos = new HashMap<>();

        DescontoProduto bis = new DescontoProduto(0.1, 3, 0); // Desconto de 10% ao atingir 3 itens
        produtos.put(4, bis);
    }

    public double quantidade(int codigoProduto, int quantidade) {
        double desconto = 0;
        if (produtos.containsKey(codigoProduto)) {
            DescontoProduto produto = produtos.get(codigoProduto);
            produto.incrementarQuantidade();


            if (produto.getQuantidadeExistente() >= produto.getQuantidadeMinima()|| quantidade>=produto.getQuantidadeMinima()) {

                desconto = aplicarDesconto(codigoProduto);
                produto.zerarQuantidade();
            }
        }
        return desconto;
    }

    public double aplicarDesconto(int codigoProduto) {
        double desconto = 0;
        if (produtos.containsKey(codigoProduto)) {
            DescontoProduto produto = produtos.get(codigoProduto);
            desconto = produto.getValorDesconto();

        }
        return desconto;
    }
}




