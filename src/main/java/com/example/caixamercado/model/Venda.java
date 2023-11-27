package com.example.caixamercado.model;
import java .util.HashMap;

public class Venda {

    private HashMap<Integer, DescontoProduto> produtos;


    public Venda() {
        // Inicialize o HashMap com os produtos (chave: código do produto, valor: objeto DescontoProduto)
        this.produtos = new HashMap<>();
        // Adicione seus produtos ao HashMap produtos
        DescontoProduto bis = new DescontoProduto(0.1, 3, 0);// Definindo a quantidade inicial
        produtos.put(4, bis); // Exemplo de produto "Bis" com desconto de 10% se comprar 3 ou mais
        // Adicione mais produtos conforme necessário...
    }

    public double calcularDesconto(int codigoProduto, int quantidade) {
        int novaqtd= 0;
        if (produtos.containsKey(codigoProduto)) {

            DescontoProduto infoProduto = produtos.get(codigoProduto);
            int quantidadeExistente = infoProduto.getQuantidadeExistente();
            novaqtd = novaqtd + quantidadeExistente;
            System.out.println("Quantidade existente antes: " + novaqtd);

            // Atualiza a quantidade existente no objeto DescontoProduto
            infoProduto.setQuantidadeExistente(quantidadeExistente + quantidade);
            quantidadeExistente = infoProduto.getQuantidadeExistente(); // Atualiza a variável após a mudança
            System.out.println("Quantidade existente depois: " + quantidadeExistente);

            if (quantidadeExistente >= infoProduto.getQuantidadeMinima()) {
                double desconto = infoProduto.getValorDesconto();
                return quantidade * desconto;
            }
        }
        return 0.0; // Se o produto não estiver no HashMap ou não atingir a quantidade mínima, retorna desconto 0
    }
}







