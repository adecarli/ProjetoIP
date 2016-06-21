package negocio;

import classesBasicas.*;
import dados.*;
import exceptions.*;

public class Hotel {
	private CadastroQuartos cadQuartos;
	private CadastroProdutos cadProdutos;
	private CadastroClientes cadClientes;
	private CadastroFuncionarios cadFuncionarios;
	
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
		Cliente cliente = cadClientes.procurarCliente(cpfCliente);
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
		Funcionario funcionario = cadFuncionarios.procurarFuncionario(cpfFuncionario);
		funcionario.trabalhar(gorjeta);
		quarto.limpar();
	}
	
	//Metodos relacionados a Funcionario
	
	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaCadastradoException {
		cadFuncionarios.cadastrarFuncionario(funcionario);
	}
	
	public void atualizarFuncionario(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		cadFuncionarios.atualizarFuncionario(funcionario);
	}
	
	public void removerFuncionario(String CPF) throws FuncionarioNaoEncontradoException{
		cadFuncionarios.removerFuncionario(CPF);
	}
	
	public Funcionario procurarFuncionario(String CPF) throws FuncionarioNaoEncontradoException{
		return cadFuncionarios.procurarFuncionario(CPF);
	} 
	
	//Metodos relacionados a Cliente
	
	public void cadastrarCliente(String nome, String cpf) throws ClienteJaCadastradoException {
		Cliente cliente = new Cliente(nome, cpf);
		cadClientes.cadastrarCliente(cliente);
	}
	
	public void atualizarCliente(String nome, String cpf) throws ClienteNaoEncontradoException {
		Cliente cliente = new Cliente(nome, cpf);
		cadClientes.atualizarCliente(cliente);
	}
	public void removerCliente(String cpf) throws ClienteNaoEncontradoException {
		cadClientes.removerCliente(cpf);
	}
	
	/*public void checkoutCliente(String cpf) throws ClienteNaoEncontradoException {
		double gastos = cadQuartos.getQuarto(cpf)
		cadClientes.adicionarGastosCliente(CPF, gastos);
	}*/
	
	public void fazerPedido(String cpf, String produto, int qtde) throws ProdutoNaoCadastradoException, ClienteNaoEncontradoException, PrecoInvalidoException{
		Produto pedido = cadProdutos.procurarProduto(produto);
		double valor = pedido.getPreco()*qtde;
		cadClientes.adicionarGastosCliente(cpf, valor);
	}
	
	
	
}























