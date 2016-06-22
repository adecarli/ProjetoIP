package negocio;

import classesBasicas.*;
import dados.*;
import exceptions.*;

//uma alteração de teste
//testando

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
	
	public void cadastrarQuarto(String numero, double valorDiaria, String tipo) throws QuartoJaCadastradoException, TipoQuartoInvalidoException {
		QuartoAbstrato temp;
		if (tipo.equals("Standard")) {
			temp = new QuartoStandard(numero, valorDiaria);
		} else if (tipo.equals("Luxo")) {
			temp = new QuartoLuxo(numero, valorDiaria); 
		} else {
			throw new TipoQuartoInvalidoException();
		}
		cadQuartos.cadastrar(temp);
	}
	public void removerQuarto(String numero) throws QuartoNaoEncontradoException, QuartoOcupadoException {
		QuartoAbstrato target = cadQuartos.procurar(numero);
		if (target.getHospede() == null) {
			cadQuartos.remover(numero);
		} else {
			throw new QuartoOcupadoException(numero, target.getHospede());
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
	//Possibilidades: Ao inves de o metodo retornar um double, ele retorna void e acrescenta
	//o valor recebido por "quarto.checkout()" ao atributo "gastos" de Cliente
	public void checkoutQuarto(String numeroQuarto) throws QuartoNaoEncontradoException, QuartoVazioException {
		QuartoAbstrato quarto = cadQuartos.procurar(numeroQuarto);
		Cliente hospede = quarto.getHospede();
		double total = quarto.checkout();
		hospede.totalGastos(total);
	}
	public String listarQuartos() {
		String s = "Listagem de Quartos\n" + cadQuartos.toString();
		return s;
	}
	//Este metodo relaciona QuartoAbstrato e Funcionario
	public void limparQuarto(String numeroQuarto, String cpfFuncionario, double gorjeta) throws QuartoNaoEncontradoException, FuncionarioNaoEncontradoException {
		QuartoAbstrato quarto = cadQuartos.procurar(numeroQuarto);
		quarto.pedido(taxaLimpeza);
		Funcionario funcionario = cadFuncionarios.procurar(cpfFuncionario);
		funcionario.trabalhar(gorjeta);
		quarto.limpar();
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
	
	//Metodos relacionados a Cliente
	
	public void cadastrarCliente(String nome, String cpf) throws ClienteJaCadastradoException{
		Cliente cliente = new Cliente(nome, cpf);
		cadClientes.cadastrar(cliente);
	}
	public void atualizarCliente(String nome, String cpf) throws ClienteNaoEncontradoException {
		Cliente cliente = new Cliente(nome, cpf);
		cadClientes.atualizar(cliente);
	}
	public void removerCliente(String cpf) throws ClienteNaoEncontradoException {
		cadClientes.remover(cpf);
	}
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
	
	public void cadastrarProduto (String nome, double preco, int quantidade) throws QuantidadeInvalidaException,PrecoInvalidoException, ProdutoJaCadastradoException, ProdutoNaoCadastradoException{
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
	public String visualizarEstoque(){
		return cadProdutos.visualizarEstoque();
	}
	public void fazerPedido(String cpf, String produto, int qtde) throws EstoqueInsuficienteException,ProdutoNaoCadastradoException, ClienteNaoEncontradoException{
		Produto pedido = cadProdutos.procurarProduto(produto);
		if (pedido==null){
			throw new ProdutoNaoCadastradoException();
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