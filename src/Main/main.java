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
		Hotel hotel;
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
		
		//segundo funcionario
		
		try{
			hotel.cadastrarFuncionario("Maria", "12345678900", "cozinheira", 900.00);
		}catch(FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		
		//terceiro funcionario
		
		try{
			hotel.cadastrarFuncionario("Vitor", "09876543211", "cozinheiro", 900.00);
		}catch(FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		
		//atualizando segundo funcionario
		
		try{
			hotel.atualizarFuncionario("Maria", "12345678900", "faxineira", 910.00);
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//atualizando funcionario nao existente
		
		try{
			hotel.atualizarFuncionario("Luan", "12345678908", "faxineiro", 910.00);
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//procurando funcionario existente
		
		try{
			Funcionario funcionario = hotel.procurarFuncionario("12345678900");
			System.out.println("Dados do funcionario: \n" + funcionario.toString());
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//procurando funcionario inexistente
		
		try{
			Funcionario funcionario = hotel.procurarFuncionario("123456789");
			System.out.println("Dados do funcionario: \n" + funcionario.toString());
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//removendo o terceiro funcionario
		
		try{
			hotel.removerFuncionario("09876543211");
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//tentando remover funcionario inexistente
		
		try{
			hotel.removerFuncionario("098765211");
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//imprimindo listagem de Funcionarios
		
		System.out.println(hotel.listarFuncionarios());
		
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
			hotel.cadastrarCliente("Ines Brasil", "696694734");
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

		//faltou comida, pe�a s� um
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
