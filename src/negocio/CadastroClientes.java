package negocio;
import exceptions.*;
import classesBasicas.Cliente;
import dados.RepositorioClientes;


public class CadastroClientes {

	private RepositorioClientes repositorio;

	public CadastroClientes(RepositorioClientes repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	//Insere o cliente no repositorio
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException { 
		if( !( repositorio.existeCliente(cliente.getCPF()) ) ){
			this.repositorio.inserirCliente(cliente);
		}else{
			throw new ClienteJaCadastradoException();
		}
	}
	
	//Remove o cliente do repositorio
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		if( repositorio.existeCliente(cpf)){
			this.repositorio.removerCliente(cpf);
		} else {
			throw new ClienteNaoEncontradoException();
		}
		
	}
	
	//Atualiza dados do cliente 
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
		if( repositorio.existeCliente(cliente.getCPF() ) ){
			this.repositorio.atualizarCliente(cliente);
		} else {
			throw new ClienteNaoEncontradoException();
		}	
	}
	
	//Procura um cliente pelo CPF no repositorio
	public Cliente procurar(String CPF) throws ClienteNaoEncontradoException{
		if( repositorio.existeCliente(CPF) ){
			return this.repositorio.procurarCliente(CPF);
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
	
	//adiciona gastos de um cliente no total
	public void adicionarGastos(String CPF, Double gastos)throws ClienteNaoEncontradoException{
	if(repositorio.existeCliente(CPF)){
			this.repositorio.adicionarGastosCliente(CPF, gastos);
	 } else {
		 throw new ClienteNaoEncontradoException();
	 }
		
	}
	//retorna os gastos do cliente até aquele momentos
	public double gastosCliente(String CPF) throws ClienteNaoEncontradoException{
		if(repositorio.existeCliente(CPF)){
			return this.repositorio.gastosCliente(CPF);
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}

	public String toString() {
		return this.repositorio.toString();
	}


	
}
