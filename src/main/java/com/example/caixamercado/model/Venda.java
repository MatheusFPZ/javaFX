package com.example.caixamercado.model;
import java .util.HashMap;

public class Venda {

    private HashMap<Integer, DescontoProduto> produtos;
    private int quant = 0;

    public Venda() {

        this.produtos = new HashMap<>();

        DescontoProduto bis = new DescontoProduto(0.1, 3, 0);// Definindo a quantidade inicial
        produtos.put(4, bis);

        DescontoProduto desc = produtos.get(4);

        //desc.setQuantidadeExistente(9);



    }
    public void quantidade(int codigoProduto){

        if(produtos.containsKey(codigoProduto)){
            DescontoProduto desc = produtos.get(codigoProduto);
            //quant =  desc.getQuantidadeExistente()+quant;
            quant += desc.getQuantidadeExistente();
            desc.setQuantidadeExistente(desc.getQuantidadeExistente()+1);




            System.out.println("Quantidade existente para o produto " + codigoProduto + ": " + desc.getQuantidadeExistente());
        }

    }

//    public double calcularDesconto(int codigoProduto, int quantidade) {
//
//        if (produtos.containsKey(codigoProduto)) {
//
//            DescontoProduto infoProduto = produtos.get(codigoProduto);
//            quantidadeExistente = quantidadeExistente+(quantidade+1);
//
//
//            System.out.println("quantidade" + quantidade);
//            System.out.println("quantidade existente"+ quantidadeExistente);
//
//          if (quantidadeExistente >= infoProduto.getQuantidadeMinima()|| quantidade>= infoProduto.getQuantidadeMinima()) {
//                double desconto = infoProduto.getValorDesconto();
//              System.out.println("pegou desconto?"+desconto);
//                quantidadeExistente=0;
//                return quantidade * desconto;
//            }
//        }
//        return 0.0;
//    }
}







