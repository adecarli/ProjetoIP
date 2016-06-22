package ui;
import java.util.Scanner;
import java.io.*;
import exceptions.*;
import negocio.*;
import dados.*;
import classesBasicas.*;
public class mainTesteCliente {

	public static void main(String[] args) {
		
		System.out.println("**BEM VINDO AO HOTEL DA'GENTE");
		
		try{
			Hotel hotel;
			Scanner in = new Scanner (new File("teste.txt"));
			String tiporep = in.nextLine();
			if (tiporep.equals("array")){
				System.out.println("Metodo de Armazenamento: Array");
				hotel=new Hotel(new RepositorioQuartosArray(),new RepositorioProdutosArray (), new RepositorioClientesArray(), new RepositorioFuncionariosArray());
			} else if(tiporep.equals("lista")){
				System.out.println("Metodo de Armazenamento: Lista");
				hotel=new Hotel(new RepositorioQuartosLista(),new RepositorioProdutosLista(), new RepositorioClientesLista(), new RepositorioFuncionariosLista());
			} else{
				throw new TipoRepositorioInvalidoException();
			}
			
			
		
			//Cadastrando clientes corretamente
			try{
				hotel.cadastrarCliente("Inês Brasil", "001");
				System.out.println("Bem vindo(a) ao hotel");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarCliente("Ranger Rosa", "010");
				System.out.println("Bem vindo(a) ao hotel");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarCliente("Birl", "011");
				System.out.println("Bem vindo(a) ao hotel");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarCliente("BamBam", "100");
				System.out.println("Bem vindo(a) ao hotel");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarCliente("cachorrineo", "101");
				System.out.println("Bem vindo(a) ao hotel");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarCliente("Monitor", "110");
				System.out.println("Bem vindo(a) ao hotel");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			//Cadastrando um cliente que já existe (ERRO)
			try{
				hotel.cadastrarCliente("Inês Brasil", "001");
				System.out.println("Bem vindo(a) ao hotel");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			//Cadastrando um cliente de nome diferente no mesmo CPF (ERRO)
			try{
				hotel.cadastrarCliente("Inês", "001");
				System.out.println("Bem vindo(a) ao hotel");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			//Listar Clientes
					System.out.println(hotel.listarClientes());
			//Remover Cliente
			try{
				hotel.removerCliente("010");
				System.out.println("Cliente removido");
			} catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}
			//Remover cliente que nao existe
			try{
				hotel.removerCliente("004");
				System.out.println("cliente removido");
			} catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}
			//Listar Clientes
					System.out.println(hotel.listarClientes());
			//Atualizar cliente 
			try{
				hotel.cadastrarCliente("Ranger Rosa", "010");
				System.out.println("Cliente adicionado");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.atualizarCliente("Kimberly", "010");
				System.out.println("Cliente atualizado");
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}
			//Atualizar cliente que nao existe
			try{
				hotel.atualizarCliente("Kimberly", "004");
		
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}
			
			//Listar Clientes
			System.out.println(hotel.listarClientes());
			
			//produto
			try {
				hotel.cadastrarProduto("Sanduiche", 5, 3);
			} catch (QuantidadeInvalidaException | PrecoInvalidoException | ProdutoJaCadastradoException
					| ProdutoNaoCadastradoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//primeiro pedido
			try{
				hotel.fazerPedido("010", "Sanduiche", 2);
				System.out.println("pedido feito");
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}catch(EstoqueInsuficienteException e){
				System.out.println(e.getMessage());
			} 
			System.out.println(hotel.listarClientes());
			//Checkout Cliente valido
			try{
				hotel.checkoutCliente("010");
				System.out.println("até a proxima");
			} catch (ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}
			//Listar Clientes
					System.out.println(hotel.listarClientes());
			//checkout Cliente invalido
			try{
				hotel.checkoutCliente("004");	
				System.out.println("até a proxima");
			} catch (ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}
		
		
		
		}catch(TipoRepositorioInvalidoException e){
			System.out.println(e.getMessage());
		} catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}