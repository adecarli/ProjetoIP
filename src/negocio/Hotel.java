package negocio;

import classesBasicas.*;
import dados.*;
import exceptions.*;

//uma alteração de teste
//testando

public class Hotel {
	private CadastroQuartos cadQuartos=new CadastroQuartos();
	private CadastroProdutos cadProdutos=new CadastroProdutos();
	private CadastroClientes cadClientes=new CadastroClientes();
	private CadastroFuncionarios cadFuncionarios= new CadastroFuncionarios();
	
	public Hotel(RepositorioQuartos repQ, RepositorioProdutos repP, RepositorioClientes repC, RepositorioFuncionarios repF) {
		cadQuartos = new CadastroQuartos(repQ);
		//cadProdutos = new CadastroProdutos(repP);
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
		quarto.checkin(cliente, numDias);
	}
	//Este metodo relaciona QuartoAbstrato e Cliente
	//Possibilidades: Ao inves de o metodo retornar um double, ele retorna void e acrescenta
	//o valor recebido por "quarto.checkout()" ao atributo "gastos" de Cliente
	public double checkout(String numeroQuarto) throws QuartoNaoEncontradoException, QuartoVazioException {
		QuartoAbstrato quarto = cadQuartos.procurar(numeroQuarto);
		double total = quarto.checkout();
		return total;
	}
	//Este metodo relaciona QuartoAbstrato e Funcionario
	public void limparQuarto(String numeroQuarto, String cpfFuncionario, double gorjeta) throws QuartoNaoEncontradoException, FuncionarioNaoEncontradoException {
		QuartoAbstrato quarto = cadQuartos.procurar(numeroQuarto);
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
	
	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException{
		cadClientes.cadastrar(cliente);
	}
	
	public void cadastrarProduto (String nome, double preco, int quantidade) throws PrecoInvalidoException, ProdutoJaCadastradoException, ProdutoNaoCadastradoException{
		if(preco<=0){
			throw new PrecoInvalidoException();
		}
		if(quantidade<=0){
			throw new PrecoInvalidoException();
		}
		Produto produto= new Produto (nome, preco, quantidade);
		cadProdutos.cadastrarProduto(produto);
	}
	public void removerProduto(String nome) throws ProdutoNaoCadastradoException{
		cadProdutos.removerProduto(nome);
	}
	public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException, PrecoInvalidoException{
		if (preco<=0){
			throw new PrecoInvalidoException();
		}
		else
		cadProdutos.atualizarPreco(nome, preco);
	}
	public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException, QuantidadeInvalidaException{
		if (quantidade<=0){
			throw new QuantidadeInvalidaException();
		}
		else
		cadProdutos.renovarEstoque(nome, quantidade);
	}
	
	public void fazerPedido(String cpf, String produto, int qtde) throws EstoqueInsuficienteException,ProdutoNaoCadastradoException, ClienteNaoEncontradoException, PrecoInvalidoException{
		Produto pedido = cadProdutos.procurarProduto(produto);
		if (pedido==null){
			throw new ProdutoNaoCadastrado();
		}
		else{
		double valor = pedido.getPreco()*qtde;
		if ((pedido.getQuantidade()-qtde)<0){
			throw new EstoqueInsuficenteException(pedido.getQuantidade());
		}
		else{
		cadClientes.adicionarGastosCliente(cpf, valor);
		pedido.setQuantidade(pedido.getQuantidade()-qtde);
		}
		}
	}
}
