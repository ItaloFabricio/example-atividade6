/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaatividade6;

import java.util.Scanner;

/**
 *
 * @author danielfelizardo
 */
public class ProgramaAtividade6 {
  
  public static String verificaProdutoComMaiorDesconto(Produto[] products) {
    String produtoComMaiorDesconto = products[0].getNome();
    double precoProdutoComMaiorDesconto = calculaValorComDesconto(products[0].getPreco());

    for (Produto produto: products) {
      double calculaDescontoDoProduto = calculaValorComDesconto(produto.getPreco());
      
      if (precoProdutoComMaiorDesconto < calculaDescontoDoProduto) {
        produtoComMaiorDesconto = produto.getNome();
        precoProdutoComMaiorDesconto = calculaDescontoDoProduto;
      }
    }

    return produtoComMaiorDesconto;
  }
  
  public static double calculaSomatorioDescontos(Produto[] products) {
    double soma = 0.0;
    
    for (int i = 0; i < products.length; i++) {
      double calcula = calculaValorComDesconto(products[i].getPreco());
      
      soma += calcula;
    }
    
    return soma;
  }

  public static double calculaValorComDesconto(double valorProduto){
    if (valorProduto < 50){
      return (valorProduto);
    } else if (valorProduto < 100){
      return (valorProduto - (valorProduto*0.05));
      //5% de desconto se valor entre 50 e 100 (sem incluir 100)
    } else {
      //10% de desconto
      return (valorProduto - (valorProduto*0.10));
    }
  }

  public static void main(String [] args){
    Scanner leitor = new Scanner(System.in);

    System.out.println("Quantos produtos você quer comprar?");
    int quant = Integer.parseInt(leitor.nextLine());
    
    Produto [] produtos = new Produto[quant];

    for (int k=0; k < quant; k++){
      System.out.println("Qual o nome do produto?");
      String nome = leitor.nextLine();
      
      System.out.println("Qual o preço original do produto?");
      double preco = Double.parseDouble(leitor.nextLine());    
      
      Produto product = new Produto(nome, preco);
      
      double valorComDesconto = calculaValorComDesconto(preco);
      System.out.printf(
        "O valor a pagar pelo produto é R$ %.2f\n",valorComDesconto
      );
      produtos[k] = product;
    }
    
    System.out.println("Calculando produto com maior desconto...");
    System.out.println(verificaProdutoComMaiorDesconto(produtos));
    
    System.out.println("Somando descontos dos produtos...");
    System.out.println(calculaSomatorioDescontos(produtos));

    leitor.close();
  }
}