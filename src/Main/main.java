package Main;

import java.util.Scanner;
import java.io.*;
import exceptions.*;
import negocio.*;
import dados.*;
import classesBasicas.*;

public class main {

	public static void main(String[] args) {
		try {

			System.out.println("	**BEM VINDO AO HOTEL DA'GENTE**");
			System.out.println("Gerente de infraestrutura e presidente: André De'Carli");
			System.out.println("Gerente de equipe: Laricia Mota");
			System.out.println("Gerente de produtos e servicos: Rafael Prado");
			System.out.println("Gerente de relacionamento com o cliente: Maria Luiza Menezes");
			System.out.println();
			System.out.println("______________________________________________________________________");
			System.out.println();

			Hotel hotel;
			Scanner in = new Scanner(new File("config.txt"));
			String tiporep = in.nextLine();
			if (tiporep.equals("Array")) {
				System.out.println("Metodo de Armazenamento: Array");
				hotel = new Hotel(new RepositorioQuartosArray(), new RepositorioProdutosArray(),
						new RepositorioClientesArray(), new RepositorioFuncionariosArray());
			} else if (tiporep.equals("Lista")) {
				System.out.println("Metodo de Armazenamento: Lista");
				hotel = new Hotel(new RepositorioQuartosLista(), new RepositorioProdutosLista(),
						new RepositorioClientesLista(), new RepositorioFuncionariosLista());
			} else {
				throw new TipoRepositorioInvalidoException();
			}
			// primeiro funcionario

			try {
				hotel.cadastrarFuncionario("Edivaldo", "1814514", "faxineiro", 900.00);
				System.out.println("Bom trabalho!");
			} catch (FuncionarioJaCadastradoException e) {
				System.out.println(e.getMessage());
			}

			// tentando recadastrar o primeiro funcionario

			try {
				hotel.cadastrarFuncionario("Edivaldo", "1814514", "faxineiro", 900.00);
				System.out.println("Bom trabalho!");
			} catch (FuncionarioJaCadastradoException e) {
				System.out.println(e.getMessage());
			}

			// segundo funcionario

			try {
				hotel.cadastrarFuncionario("Maria", "12345678900", "cozinheira", 900.00);
				System.out.println("Bom trabalho!");
			} catch (FuncionarioJaCadastradoException e) {
				System.out.println(e.getMessage());
			}

			// terceiro funcionario

			try {
				hotel.cadastrarFuncionario("Vitor", "09876543211", "cozinheiro", 900.00);
				System.out.println("Bom trabalho!");
			} catch (FuncionarioJaCadastradoException e) {
				System.out.println(e.getMessage());
			}

			// atualizando segundo funcionario

			try {
				hotel.atualizarFuncionario("Maria", "12345678900", "faxineira", 910.00);
				System.out.println("Funcionario atualizado!");
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}

			// atualizando funcionario nao existente

			try {
				hotel.atualizarFuncionario("Luan", "12345678908", "faxineiro", 910.00);
				System.out.println("Funcionario atualizado!");
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}

			// procurando funcionario existente

			try {
				Funcionario funcionario = hotel.procurarFuncionario("12345678900");
				System.out.println("Dados do funcionario: \n" + funcionario.toString());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}

			// procurando funcionario inexistente

			try {
				Funcionario funcionario = hotel.procurarFuncionario("123456789");
				System.out.println("Dados do funcionario: \n" + funcionario.toString());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}

			// removendo o terceiro funcionario

			try {
				hotel.removerFuncionario("09876543211");
				System.out.println("funcionario removido com sucesso");
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}

			// tentando remover funcionario inexistente

			try {
				hotel.removerFuncionario("098765211");
				System.out.println("funcionario removido com sucesso");
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}

			// imprimindo listagem de Funcionarios

			System.out.println(hotel.listarFuncionarios());

			// cadastrando com preco invalido o primeiro produto
			try {
				hotel.cadastrarProduto("Agua", 0.00, 2);
				System.out.println("produto adicionado ao Cardapio");
			} catch (ProdutoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (PrecoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// cadastrando com quantidade invalida o primeiro produto
			try {
				hotel.cadastrarProduto("Agua", 1.00, -3);
				System.out.println("produto adicionado ao Cardapio");
			} catch (ProdutoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (PrecoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// cadastrando o primeiro produto de forma correta
			try {
				hotel.cadastrarProduto("Agua", 1.00, 2);
				System.out.println("produto adicionado ao Cardapio");
			} catch (ProdutoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PrecoInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProdutoNaoCadastradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// tentando cadastrar o primeiro produto de novo
			try {
				hotel.cadastrarProduto("Agua", 1.00, 2);
				System.out.println("produto adicionado ao Cardapio");
			} catch (ProdutoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (PrecoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// removendo o primeiro e unico produto
			try {
				hotel.removerProduto("Agua");
				System.out.println("Produto removido do cardapio");
			} catch (ProdutoNaoCadastradoException e) {
				System.out.println(e.getMessage());
			}
			// tentando remover um produto nao cadastrado
			try {
				hotel.removerProduto("Biscoito");
				System.out.println("Produto removido do cardapio");

			} catch (ProdutoNaoCadastradoException e) {
				System.out.println(e.getMessage());
			}
			// Recadastrando o produto
			try {
				hotel.cadastrarProduto("Agua", 1.00, 10);
				System.out.println("Produto atualizado");
			} catch (ProdutoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (PrecoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Mais um produto
			try {
				hotel.cadastrarProduto("Sanduiche", 7.00, 1);
				System.out.println("produto adicionado ao Cardapio");
			} catch (ProdutoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (PrecoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Cadastrando o primeiro quarto
			try {
				hotel.cadastrarQuarto("103", 500.50, "Luxo");
				System.out.println("Novo quarto disponivel");
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Cadastrando o primeiro cliente
			try {
				hotel.cadastrarCliente("Inês Brasil", "001");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			try {
				hotel.cadastrarCliente("Ranger Rosa", "010");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			try {
				hotel.cadastrarCliente("Birl", "011");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			try {
				hotel.cadastrarCliente("BamBam", "100");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			try {
				hotel.cadastrarCliente("cachorrineo", "101");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			try {
				hotel.cadastrarCliente("Gatineo", "110");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			// primeiro pedido
			try {
				hotel.fazerPedido("010", "Sanduiche", 2);
				System.out.println("Pedido realizado");
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (EstoqueInsuficienteException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// visualizacao do Estoque
			System.out.print(hotel.visualizarEstoque());
			// pedido com quantidade insuficiente
			try {
				hotel.fazerPedido("010", "Sanduiche", 6);
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (EstoqueInsuficienteException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			}
			// pedido com cliente nao encontrado
			try {
				hotel.fazerPedido("004", "Sanduiche", 1);
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (EstoqueInsuficienteException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			}
			// pedido de produto nao cadastrado
			try {
				hotel.fazerPedido("004", "Sushi", 1);
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (EstoqueInsuficienteException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			}
			// pedido de produto numa quantidade invalida
			try {
				hotel.fazerPedido("004", "Sanduiche", -3);
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoNaoCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (EstoqueInsuficienteException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			}

		} catch (TipoRepositorioInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
