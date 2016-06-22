package negocio;

import classesBasicas.*;
import dados.*;
import exceptions.*;

public class Hotel {
	private CadastroQuartos cadQuartos;
	private CadastroProdutos cadProdutos;
	private CadastroClientes cadClientes;
	private CadastroFuncionarios cadFuncionarios;
	private static final double taxaLimpeza = 2;
	
	public Hotel(){
		
	}
	public Hotel(RepositorioQuartos repQ, RepositorioProdutos repP, RepositorioClientes repC, RepositorioFuncionarios repF) {
		cadQuartos = new CadastroQuartos(repQ);
		cadProdutos = new CadastroProdutos(repP);
		cadClientes = new CadastroClientes(repC);
		cadFuncionarios = new CadastroFuncionarios(repF);
	}
	
	//Metodos relacionados a Quarto
	
	public void cadastrarQuarto(String numero, double valorDiaria, String tipo) throws ValorDiariaInvalidoException, QuartoJaCadastradoException, TipoQuartoInvalidoException {
		if (valorDiaria >= 0) {
			QuartoAbstrato temp;
			if (tipo.equals("Standard")) {
				temp = new QuartoStandard(numero, valorDiaria);
			} else if (tipo.equals("Luxo")) {
				temp = new QuartoLuxo(numero, valorDiaria); 
			} else {
				throw new TipoQuartoInvalidoException();
			}
			cadQuartos.cadastrar(temp);			
		} else {
			throw new ValorDiariaInvalidoException();
		}
	}
	public void removerQuarto(String numero) throws QuartoNaoEncontradoException, QuartoOcupadoException {
		QuartoAbstrato target = cadQuartos.procurar(numero);
		if (target.getHospede() == null) {
			cadQuartos.remover(numero);
		} else {
			throw new QuartoOcupadoException(numero, target.getHospede());
		}
	}
	public void atualizarQuarto(String numero, double valorDiaria, String tipo) throws QuartoNaoEncontradoException, TipoQuartoInvalidoException {
		if (tipo.equals("Standard")) {
			cadQuartos.atualizar(new QuartoStandard(numero, valorDiaria));
		} else if (tipo.equals("Luxo")) {
			cadQuartos.atualizar(new QuartoLuxo(numero, valorDiaria));
		} else {
			throw new TipoQuartoInvalidoException();
		}
	}
	public void adicionarCama(String numero) throws QuartoNaoEncontradoException, QuartoOcupadoException, AdicionarCamaException, CamaExtraPresenteException {
		QuartoAbstrato quarto = cadQuartos.procurar(numero);
		if (quarto instanceof QuartoLuxo) {
			if (quarto.getHospede() == null) {
				if (!((QuartoLuxo) quarto).getCamaExtra()) {
					((QuartoLuxo) quarto).adicionarCama();									
				} else {
					throw new CamaExtraPresenteException();
				}
			} else {
				throw new QuartoOcupadoException(numero, quarto.getHospede());
			}
		} else {
			throw new AdicionarCamaException();
		}
	}
	public void removerCama(String numero) throws QuartoNaoEncontradoException, CamaExtraAusenteException, QuartoOcupadoException, AdicionarCamaException {
		QuartoAbstrato quarto = cadQuartos.procurar(numero);
		if (quarto instanceof QuartoLuxo) {
			if (quarto.getHospede() == null) {
				if (((QuartoLuxo) quarto).getCamaExtra()) {
					((QuartoLuxo) quarto).removerCama();									
				} else {
					throw new CamaExtraAusenteException();
				}
			} else {
				throw new QuartoOcupadoException(numero, quarto.getHospede());
			}
		} else {
			throw new AdicionarCamaException();
		}
	}
	public void checkin(String numeroQuarto, String cpfCliente, int numDias) throws QuartoNaoEncontradoException, ClienteNaoEncontradoException, QuartoOcupadoException {
		QuartoAbstrato quarto = cadQuartos.procurar(numeroQuarto);
		Cliente cliente = cadClientes.procurar(cpfCliente);
		if (quarto.getHospede() == null) {			
			quarto.checkin(cliente, numDias);
		} else {
			throw new QuartoOcupadoException(numeroQuarto, quarto.getHospede());
		}
	}
	//Este metodo relaciona QuartoAbstrato e Cliente
	public void checkoutQuarto(String numeroQuarto) throws QuartoNaoEncontradoException, QuartoVazioException {
		QuartoAbstrato quarto = cadQuartos.procurar(numeroQuarto);
		if (quarto.getHospede() != null) {
			Cliente hospede = quarto.getHospede();
			double total = quarto.checkout();
			hospede.totalGastos(total);			
		} else {
			throw new QuartoVazioException(numeroQuarto);
		}
	}
	public String listarQuartos() {
		String s = "Listagem de Quartos\n" + cadQuartos.toString();
		return s;
	}
	//Este metodo relaciona QuartoAbstrato e Funcionario
	public void limparQuarto(String numeroQuarto, String cpfFuncionario, double gorjeta) throws QuartoNaoEncontradoException, FuncionarioNaoEncontradoException, QuartoVazioException, QuartoLimpoException, GorjetaInvalidaException {
		if (gorjeta >= 0) {
			QuartoAbstrato quarto = cadQuartos.procurar(numeroQuarto);
			if (quarto.getHospede() != null) { 
				if (!quarto.getLimpo()) {
					quarto.pedido(taxaLimpeza);
					Funcionario funcionario = cadFuncionarios.procurar(cpfFuncionario);
					funcionario.trabalhar(gorjeta);
					quarto.limpar();				
				} else {
					throw new QuartoLimpoException(numeroQuarto);
				}
			} else {
				throw new QuartoVazioException(numeroQuarto);
			}
		} else {
			throw new GorjetaInvalidaException();
		}
	}
	
	//Metodos relacionados a Funcionario
	
	public void cadastrarFuncionario(String nome, String CPF, String funcao, double salario) throws FuncionarioJaCadastradoException {
		Funcionario funcionario = new Funcionario(nome, CPF, funcao, salario);
		cadFuncionarios.cadastrar(funcionario);
	}
	
	public void atualizarFuncionario(String nome, String CPF, String funcao, double salario) throws FuncionarioNaoEncontradoException{
		Funcionario funcionario = new Funcionario(nome, CPF, funcao, salario);
		cadFuncionarios.atualizar(funcionario);
	}
	
	public void removerFuncionario(String CPF) throws FuncionarioNaoEncontradoException{
		cadFuncionarios.remover(CPF);
	}
	
	public Funcionario procurarFuncionario(String CPF) throws FuncionarioNaoEncontradoException{
		return cadFuncionarios.procurar(CPF);
	} 
	
	public String listarFuncionarios(){
		String listagem = "Listagem de Funcionarios: \n" + cadFuncionarios.toString();
		return listagem;
	}
	//Metodos relacionados a Cliente
	
	//cadastra o cliente 
	public void cadastrarCliente(String nome, String cpf) throws ClienteJaCadastradoException{
		Cliente cliente = new Cliente(nome, cpf);
		cadClientes.cadastrar(cliente);
	}
	
	//atualiza dados do cliente
	public void atualizarCliente(String nome, String cpf) throws ClienteNaoEncontradoException {
		Cliente cliente = new Cliente(nome, cpf);
		cadClientes.atualizar(cliente);
	}
	
	//retorna os gastos de um cliente
	public double gastosCliente(String CPF) throws ClienteNaoEncontradoException {
		return cadClientes.gastosCliente(CPF);
	}
	
	//remove um cliente do repositorio
	public void removerCliente(String cpf) throws ClienteNaoEncontradoException {
		cadClientes.remover(cpf);
	}
	
	//faz checkout, retornando o valor da conta e removendo ele da lista
	public double checkoutCliente(String cpf) throws ClienteNaoEncontradoException { // vai  
		double gastos = cadQuartos.checkoutCliente(cpf);
		cadClientes.adicionarGastos(cpf, gastos);
		gastos = cadClientes.gastosCliente(cpf);
		cadClientes.remover(cpf);
		return gastos;
	}
	
	public String listarClientes() {
		String s = "Listagem de Clientes\n" + cadClientes.toString();
		return s;
	}
	
	//Metodos relacionados a Produto
	
	public void cadastrarProduto (String nome, double preco, int quantidade) throws QuantidadeInvalidaException,PrecoInvalidoException, ProdutoJaCadastradoException{
		//verifica se o preco é maior que 0
		if(preco<=0){
			throw new PrecoInvalidoException();
		}
		//verifica se a quantidade é maior que 0

		if(quantidade<=0){
			throw new QuantidadeInvalidaException();
		}
		cadProdutos.cadastrarProduto(new Produto (nome, preco, quantidade));
	}
	public void removerProduto(String nome) throws ProdutoNaoCadastradoException{
		//apenas chama o metodo remover
		cadProdutos.removerProduto(nome);
	}
	public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException, PrecoInvalidoException{
		//o preco pode ser invalido
		if (preco<=0){
			throw new PrecoInvalidoException();
		}
		else
		cadProdutos.atualizarPreco(nome, preco);
	}
	public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException, QuantidadeInvalidaException{
		//se o estoque estiver zerado, lança o erro
		if (quantidade<=0){
			throw new QuantidadeInvalidaException();
		}
		else
		cadProdutos.renovarEstoque(nome, quantidade);
	}
		//retorna uma string com as informaçoes do Produto
	public String visualizarEstoque(){
		return cadProdutos.visualizarEstoque();
	}
	//retorna uma string com o cardapio
	public String informacoesProduto(String nome)throws ProdutoNaoCadastradoException{
		return cadProdutos.informacoesProduto(nome);
	}
	public void fazerPedido(String cpf, String produto, int qtde) throws QuantidadeInvalidaException,EstoqueInsuficienteException,ProdutoNaoCadastradoException, ClienteNaoEncontradoException{
		if (qtde<=0){
			throw new QuantidadeInvalidaException();
		}
		Produto pedido = cadProdutos.procurarProduto(produto);
		if (pedido==null){
			throw new ProdutoNaoCadastradoException(produto);
		}
		else{
		//verifica se tem a quantidade certa para fazer uma retirada no estoque
		if ((pedido.getEstoque()-qtde)<0){
			throw new EstoqueInsuficienteException(pedido.getEstoque());
		}
		else{
		//calcula o valor a ser gasto
		double valor = pedido.getPreco()*qtde;
		//debita na conta do cliente
		cadClientes.adicionarGastos(cpf, valor);
		pedido.setEstoque(pedido.getEstoque()-qtde);
		}
		}
	}
}
