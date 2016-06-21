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
	
	
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		if( !( repositorio.existeCliente(cliente.getCPF()) ) ){
			this.repositorio.inserirCliente(cliente);
		}else{
			throw new ClienteJaCadastradoException();
		}
	}
	
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		if( repositorio.existeCliente(cpf)){
			this.repositorio.removerCliente(cpf);
		} else {
			throw new ClienteNaoEncontradoException();
		}
		
	}
	
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
		if( repositorio.existeCliente(cliente.getCPF() ) ){
			this.repositorio.atualizarCliente(cliente);
		} else {
			throw new ClienteNaoEncontradoException();
		}	
	}
	
	public Cliente procurar(String CPF) throws ClienteNaoEncontradoException{
		if( repositorio.existeCliente(CPF) ){
			return this.repositorio.procurarCliente(CPF);
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
	
	public void adicionarGastos(String CPF, Double gastos)throws PrecoInvalidoException, ClienteNaoEncontradoException{
	if(gastos <= 0){
		throw new PrecoInvalidoException();
	} else if(repositorio.existeCliente(CPF)){
			this.repositorio.adicionarGastosCliente(CPF, gastos);
	 } else {
		 throw new ClienteNaoEncontradoException();
	 }
		
	}
	
	public double gastosCliente(String CPF) throws ClienteNaoEncontradoException{
		if(repositorio.existeCliente(CPF)){
			return this.repositorio.gastosCliente(CPF);
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
	
	public void zerarGastos(String CPF) throws ClienteNaoEncontradoException {
		if(repositorio.existeCliente(CPF)){
			this.repositorio.zerarGastosCliente(CPF);
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
	


	
}
