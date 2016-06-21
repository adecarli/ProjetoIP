package negocio;
import classesBasicas.Cliente;
import exceptions.*;
import dados.RepositorioClientes;
import dados.RepositorioClientesArray;


public class CadastroClientes {

	private RepositorioClientes repositorio;

	public CadastroClientes(RepositorioClientes repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	
	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException {
		if( !( repositorio.existeCliente(cliente.getCPF()) ) ){
			this.repositorio.inserirCliente(cliente);
		}else{
			throw new ClienteJaCadastradoException();
		}
	}
	
	public void removerCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		if( repositorio.existeCliente(cliente.getCPF() ) ){
			this.repositorio.removerCliente(cliente.getCPF());
		} else {
			throw new ClienteNaoEncontradoException();
		}
		
	}
	
	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException{
		if( repositorio.existeCliente(cliente.getCPF() ) ){
			this.repositorio.atualizarCliente(cliente);
		} else {
			throw new ClienteNaoEncontradoException();
		}	
	}
	
	public Cliente procurarCliente(String CPF) throws ClienteNaoEncontradoException{
		if( repositorio.existeCliente(CPF) ){
			return this.repositorio.procurarCliente(CPF);
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
	public void adicionarGastosCliente(String CPF, double gasto){
		repositorio.adicionarGastosCliente(CPF, gasto);
	}
	}	
