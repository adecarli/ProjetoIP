package negocio;
import classesbasicas.Cliente;
import exceptions.*;
import dados.RepositorioClientes;


public class CadastroClientes {

	private RepositorioClientes repositorio;

	public CadastroClientes(RepositorioClientes repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		if( !( repositorio.existe(cliente.getCPF()) ) ){
			this.repositorio.inserir(cliente);
		}else{
			throw new ClienteJaCadastradoException();
		}
	}
	
	public void remover(Cliente cliente) throws ClienteNaoEncontradoException {
		if( repositorio.existe(cliente.getCPF() ) ){
			this.repositorio.remover(cliente.getCPF());
		} else {
			throw new ClienteNaoEncontradoException();
		}
		
	}
	
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
		if( repositorio.existe(cliente.getCPF() ) ){
			this.repositorio.atualizar(cliente);
		} else {
			throw new ClienteNaoEncontradoException();
		}	
	}
	
	public Cliente procurar(String CPF) throws ClienteNaoEncontradoException{
		if( repositorio.existe(CPF) ){
			return this.repositorio.procurar(CPF);
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
	
	public void pedido(String produto, String CPF) throws ClienteNaoEncontradoException, ProdutoNaoCadastradoException{
		if( !(repositorio.existe(CPF ) ) ){ // falta ver se o produto existe 
			throw new ClienteNaoEncontradoException();
		}
		/*else if(! produto nao existe){
			throw new ProdutoNaoCadastrado();
		}*/
	
		else{
			this.repositorio.pedido(produto, CPF);
			
		}
	
	}
	

	
}
