package Main;

import java.util.Scanner;
import java.io.*;
import exceptions.*;
import negocio.*;
import dados.*;
import classesBasicas.*;

public class mainTeste {

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
			//Cadastrando 2 quartos standard e 3 de luxo
			try {
				hotel.cadastrarQuarto("1A", 15, "Standard");
				System.out.println(">Quarto cadastrado");
				hotel.cadastrarQuarto("1E", 25, "Standard");
				System.out.println(">Quarto cadastrado");
				hotel.cadastrarQuarto("2e", 40, "Luxo");
				System.out.println(">Quarto cadastrado");
				hotel.cadastrarQuarto("2B", 40, "Luxo");
				System.out.println(">Quarto cadastrado");
				hotel.cadastrarQuarto("2A", 80, "Luxo");
				System.out.println(">Quarto cadastrado");
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch(ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Criando dois clientes
			try {
				hotel.cadastrarCliente("Andre", "086");
				System.out.println(">Cliente cadastrado");
				hotel.cadastrarCliente("Luisa", "083");
				System.out.println(">Cliente cadastrado");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			//Listando os quartos cadastrados
			System.out.println(hotel.listarQuartos());
			//Listando os clientes cadastrados
			System.out.println(hotel.listarClientes());
			//Atualizando preco de um quarto
			try {
				hotel.atualizarQuarto("2e", 100, "Luxo");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Listar Quartos
			System.out.println(hotel.listarQuartos());
			//Atualizando tipo de um quarto
			try {
				hotel.atualizarQuarto("2e", 100, "Standard");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Listando Quartos
			System.out.println(hotel.listarQuartos());
			//EXCECOES DE cadastrarQuarto -----
			//Tentando cadastrar um quarto já existente
			try {
				hotel.cadastrarQuarto("1A", 50.0, "Luxo");
				System.out.println(">Quarto cadastrado");
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
				System.out.println("Quarto: " + e.getNumero() + " já existe");
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Tentando cadastrar um quarto com o valor da diaria invalido
			try {
				hotel.cadastrarQuarto("3A", -3, "Luxo");
				System.out.println(">Quarto cadastrado");
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Tentando cadastrar um quarto com o tipo invalido
			try {
				hotel.cadastrarQuarto("3A", 50, "Top");
				System.out.println(">Quarto cadastrado");
			} catch (ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
			//Removendo um quarto
			try {
				hotel.removerQuarto("2e");
				System.out.println(">Quarto removido");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Listando os quartos
			System.out.println(hotel.listarQuartos());
			//EXCECOES DE removerQuarto ----
			//Tentando remover um quarto inexistente
			try {
				hotel.removerQuarto("2E");
				System.out.println(">Quarto removido");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			
			//Adicionando uma cama extra num quarto
			try {
				hotel.adicionarCama("2A");
				System.out.println(">Cama adicionada");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}
			//Listando os quartos
			System.out.println(hotel.listarQuartos());
			//EXCECOES DE adicionarCama
			//Adicionando uma cama extra num quarto inexistente
			try {
				hotel.adicionarCama("1z");
				System.out.println(">Cama cadastrado");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}
			//Adicionando uma cama extra num quarto invalido
			try {
				hotel.adicionarCama("1A");
				System.out.println(">Cama cadastrado");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}
			//Adicionando mais de uma cama extra
			try {
				hotel.adicionarCama("2A");
				System.out.println(">Cama adicionada");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}

			
			//Removendo uma cama extra
			try {
				hotel.removerCama("2A");
				System.out.println(">Cama removida");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			//Listando Quartos
			System.out.println(hotel.listarQuartos());
			//EXCECOES DE removerCama
			//Removendo uma cama extra inexistente
			try {
				hotel.removerCama("2B");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			//Removendo uma cama extra de quarto inexistente
			try {
				hotel.removerCama("1z");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			//Removendo uma cama extra de quarto invalido
			try {
				hotel.removerCama("1A");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			
			//Cliente fazendo checkin
			try {
				hotel.checkin("1A", "086", 5);
				hotel.checkin("2A", "086", 3);
				System.out.println(">Checkin feito com sucesso");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Listando quartos
			System.out.println(hotel.listarQuartos());
			//Tentando remover quarto ocupado
			try {
				hotel.removerQuarto("1A");
				System.out.println(">Quarto removido");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Tentando adicionar cama em quarto ocupado
			try {
				hotel.adicionarCama("2A");
				System.out.println(">Cama adicionada");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}
			//Adicionando cama e fazendo checkin
			try {
				hotel.adicionarCama("2B");
				hotel.checkin("2B", "083", 2);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}
			//Listando Quartos
			System.out.println(hotel.listarQuartos());
			//Removendo cama de quarto ocupado
			try {
				hotel.removerCama("2B");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			//Fazendo checkout
			try {
				hotel.checkoutQuarto("2B");
				System.out.println(">Checkout feito com sucesso");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			}
			//Listando Clientes
			System.out.println(hotel.listarClientes());
			//Fazendo checkout de quarto vazio
			try {
				hotel.checkoutQuarto("2B");
				System.out.println(">Checkout feito com sucesso");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			}
			//Fazendo checkout de quarto invalido
			try {
				hotel.checkoutQuarto("5b");
				System.out.println(">Checkout feito com sucesso");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			}
			//Listando quartos
			System.out.println(hotel.listarQuartos());
			//Fazendo checkin em quarto ocupado
			try {
				hotel.checkin("1A", "083", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Cliente invalido fazendo checkin
			try {
				hotel.checkin("1E", "12345", 3);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());;
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Cadastrando Funcionario
			try {
				hotel.cadastrarFuncionario("Laricia", "666", "camareira", 1000);
			} catch (FuncionarioJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			//Listando funcionarios
			System.out.println(hotel.listarFuncionarios());
			//Requisitando limpeza de quarto
			try {
				hotel.limparQuarto("1A", "666", 5);
				System.out.println(">Limpeza Efetuada");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Listando quartos
			System.out.println(hotel.listarQuartos());
			//Requisitando limpeza de quarto a funcionario invalido
			try {
				hotel.limparQuarto("2A", "669", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Requisitando limpeza de quarto limpo
			try {
				hotel.limparQuarto("1A", "666", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Requisitando limpeza de quarto vazio
			try {
				hotel.limparQuarto("1E", "666", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Requisitando limpeza de quarto invalido
			try {
				hotel.limparQuarto("1z", "666", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Requisitando limpeza com gorjeta negativa
			try {
				hotel.limparQuarto("2A", "666", -5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Listando funcionarios
			System.out.println(hotel.listarFuncionarios());
			//Listando quartos
			System.out.println(hotel.listarQuartos());
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
			}
			//Cadastrando o primeiro cliente
			try {
				hotel.cadastrarCliente("Inês Brasil", "001");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			//Fazendo Check-in do quarto
			try{
				hotel.checkin("103", "001", 3);
			}catch(QuartoNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//primeiro pedido
			try{
				hotel.fazerPedido("001", "Sanduiche", 2);
				System.out.println("pedido feito\n");
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}catch(EstoqueInsuficienteException e){
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//visualizacao do Estoque
				System.out.println(hotel.visualizarEstoque());

			//faltou comida, peca apenas um
					try{
						hotel.fazerPedido("001", "Sanduiche", 1);
						System.out.println("pedido feito\n");
					}catch(ClienteNaoEncontradoException e){
						System.out.println(e.getMessage());
					}catch(ProdutoNaoCadastradoException e){
						System.out.println(e.getMessage());
					}catch(EstoqueInsuficienteException e){
						System.out.println(e.getMessage());
					} catch (QuantidadeInvalidaException e) {
						System.out.println(e.getMessage());
					}
			//Cadastrando cliente
			try{
				hotel.cadastrarCliente("Andrea Mello", "8478");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			//chegou a colega de quarto de Ines
			try{
				hotel.checkin("103", "8478", 3);
			}catch(QuartoNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(QuartoOcupadoException e){
				System.out.println(e.getMessage());
			}
			//mas nao podem ficar no mesmo quarto
			try{
				hotel.cadastrarQuarto("201", 300, "Standard");
			}catch(QuartoJaCadastradoException e){
				System.out.println(e.getMessage());
			} catch (ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//ai que delicia, colegas de hotel
			try{
				hotel.checkin("201", "8478", 3);
			}catch(QuartoNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			try{
				hotel.fazerPedido("001", "Bolo de Morango (Fatia)", 1);
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}catch(EstoqueInsuficienteException e){
				System.out.println(e.getMessage());
			} catch (QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//renovando estoque
			try{
				hotel.renovarEstoque("Sanduiche",20);
			}catch(ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			//cadastrando mais produtos
			try{
				hotel.cadastrarProduto("Bolo de Morango (Fatia)",5.00, 12);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Bolo de Chocolate (Fatia)",6.00, 12);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Cerveja",5.00, 30);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Bolo de Morango (Fatia)",5.00, 12);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Coca-cola",3.00, -10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Coca-cola",3.00, 20);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			//removendo coca-cola
			try{
				hotel.removerProduto("Coca-cola");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			//cadastrando refrigerantes diversos
			try{
				hotel.cadastrarProduto("Refrigerante (diverso)",2.00, 60);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			//atualizando o preco de um produto
			try{
				hotel.atualizarPreco("Refrigerante (diverso)", 3.00);
			}catch(ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.removerProduto("Refrigerante (diverso)");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Coca-cola",3.00, 20);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Fanta",3.00, 20);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Guarana",3.00, 20);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Sprite",3.00, 20);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Aquarius Fresh",4.00, 20);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Chicabom",5.00, 10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Frutare",4.00, 20);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Sorvete",3.00, 0);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Sorvete (1 bola)",3.00, 10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Misto",5.00, 10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("X-Burguer",8.00, 10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Batata-Frita (Pequena)",5.00, 10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Batata-Frita (Grande)",8.00, 10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Pirulito",0.25, 100);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Ice Kiss",0.10, 100);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Coco",6.00, 20);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarProduto("Café (pequeno)",1.00, 10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.removerProduto("Café (pequeno)");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.removerProduto("Ice Kiss");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			
			//visualizacao do Estoque
			System.out.println(hotel.visualizarEstoque());
			
			//Cadastrando cliente mais de uma vez repetido
			try{
				hotel.cadastrarCliente("Andrea Mello", "8478");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.checkoutQuarto("201");
			}catch(QuartoNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch (QuartoVazioException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.checkoutCliente("8478");
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.cadastrarCliente("Jessikylaine", "1831");
				System.out.println("Bem vindo(a) ao hotel Da'Gente");
			}catch(ClienteJaCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.checkin("201","1831", 2);
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(QuartoNaoEncontradoException e){
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Jessikylaine é viciada em pirulitos
			try{
				hotel.fazerPedido("1831", "Pirulito", 100);
				System.out.println("pedido feito\n");
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}catch(ClienteNaoEncontradoException e){
				System.out.println(e.getMessage());
			}catch(ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			} catch (EstoqueInsuficienteException e) {
				System.out.println(e.getMessage());
			}
			try{
				System.out.println(hotel.informacoesProduto("Pirulito"));;
			}catch(ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.renovarEstoque("Pirulito", 200);
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			//visualizando estoque
			System.out.println(hotel.visualizarEstoque());
			//removendo mais alguns
			try{
				hotel.removerProduto("Bolo de Morango (Fatia)");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.removerProduto("Bolo de Morango (Fatia)");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			//erro de digitacao
			try{
				hotel.removerProduto("Bolo de Chocolate(Fatia)");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			//consertando o erro de digitacao
			try{
				hotel.removerProduto("Bolo de Chocolate (Fatia)");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			try{
				hotel.removerProduto("Agua");
			}catch (ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}
			//readicionando agua
			try{
				hotel.cadastrarProduto("Agua",1.00, 10);
			}catch(ProdutoJaCadastradoException e){
				System.out.println(e.getMessage());
			}catch(PrecoInvalidoException e){
				System.out.println(e.getMessage());
			}catch(QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			//aumetando o estoque de agua
			try{
				hotel.renovarEstoque("Agua", 90);
			}catch(ProdutoNaoCadastradoException e){
				System.out.println(e.getMessage());
			}catch (QuantidadeInvalidaException e){
				System.out.println(e.getMessage());
			}
			//visualizando estoque
				System.out.println(hotel.visualizarEstoque());
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
