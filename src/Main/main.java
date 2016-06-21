package Main;
import java.util.Scanner;
import java.io.*;
import exceptions.*;
import negocio.*;
import dados.*;
import classesBasicas.*;
public class main {

	public static void main(String[] args) {
		try{
		Hotel hotel= new Hotel();
		Scanner in = new Scanner (new File("teste.txt"));
		if (in.nextLine().equals("Array")){
			System.out.println("Metodo de Armazenamento: Array");
			hotel=new Hotel(new RepositorioQuartosArray(),new RepositorioProdutosArray (), new RepositorioClientesArray(), new RepositorioFuncionariosArray());
		}
		else{
			System.out.println("Metodo de Armazenamento: Lista");
			hotel=new Hotel(new RepositorioQuartosLista(),new RepositorioProdutosLista(), new RepositorioClientesLista(), new RepositorioFuncionariosLista());
		}
		//primeiro funcionario
		try{
			hotel.cadastrarFuncionario("Edivaldo", "1814514", "faxineiro", 900.00);
		}catch(FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//tentando recadastrar o primeiro funcionario
		try{
			hotel.cadastrarFuncionario("Edivaldo", "1814514", "faxineiro", 900.00);
		}catch(FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//cadastrando com preco invalido o primeiro produto
		try{
			hotel.cadastrarProduto("Agua",0.00, 2);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//cadastrando com quantidade invalida o primeiro produto
		try{
			hotel.cadastrarProduto("Agua",1.00, -3);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//cadastrando o primeiro produto de forma correta
		try{
			hotel.cadastrarProduto("Agua",1.00, 2);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//tentando cadastrar o primeiro produto de novo
		try{
			hotel.cadastrarProduto("Agua",1.00, 2);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//removendo o primeiro e unico produto
		try{
			hotel.removerProduto("Agua");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//tentando remover um produto nao cadastrado
		try{
			hotel.removerProduto("Biscoito");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//Recadastrando o produto
		try{
			hotel.cadastrarProduto("Agua",1.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//Mais um produto
		try{
			hotel.cadastrarProduto("Sanduiche",7.00, 1);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//Cadastrando o primeiro quarto
		try{
			hotel.cadastrarQuarto("103", 500.50, "Luxo");
		}catch(QuartoJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//Cadastrando o primeiro cliente
		try{
			hotel.cadastrarCliente(new Cliente("Inês Brasil", "696694734"));
		}catch(ClienteJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//primeiro pedido
		try{
			hotel.fazerPedido("696694734", "Sanduiche", 2);
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}catch(EstoqueInsuficienteException e){
			System.out.println(e.getMessage());
		}
		//visualizacao do Estoque
			System.out.print(hotel.visualizarEstoque());

		//faltou comida, peça só um
				try{
					hotel.fazerPedido("696694734", "Sanduiche", 1);
				}catch(ClienteNaoEncontradoException e){
					System.out.println(e.getMessage());
				}catch(ProdutoNaoCadastradoException e){
					System.out.println(e.getMessage());
				}catch(EstoqueInsuficienteException e){
					System.out.println(e.getMessage());
				}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
}
}
