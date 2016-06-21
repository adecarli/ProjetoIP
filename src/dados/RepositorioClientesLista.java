package dados;

import classesbasicas.Cliente;
import classesbasicas.Produto;
import exceptions.*;

public class RepositorioClientesLista implements RepositorioClientes {
	// atributos
	private Cliente cliente;
	private RepositorioClientesLista next;

	// construtor
	public RepositorioClientesLista() {
		this.cliente = null;
		this.next = null;
	}

	public void inserir(Cliente cliente) {
		if (this.cliente == null) { // caso não haja um cliente naquela posicao,
									// o novo cliente eh inserido la
			this.cliente = cliente;
			this.next = new RepositorioClientesLista();
		} else {
			this.next.inserir(cliente); // caso haja, chama o metodo recursivo
										// no proximo item da lsita
		}
	}

	public void remover(String CPF) throws ClienteNaoEncontradoException{ //metodo recursivo de remocao
		if(this.cliente !=null){
			if(this.cliente.getCPF().equals(CPF)){ //quando encontro o cpf igual, faco a substituicao
				this.cliente = this.next.cliente; //faco o ponteiro desse cliente apontar para o proximo
				this.next = this.next.next; //e assim sucessivamente
			}
			else{
				this.next.remover(CPF); //se não encontro, chamo o metodo recursivamente
			}
		}
		else{ 
			throw new ClienteNaoEncontradoException();
		}	
	}

	public Cliente procurar(String CPF) throws ClienteNaoEncontradoException {
		Cliente encontrado;
		if(this.cliente!=null) {	
			if (this.cliente.getCPF().equals(CPF)) { //quando encontra um cliente com o CPF igual ao procurado
				encontrado = this.cliente;	
			}
			else{ //se nao for encontrado, chama o metodo recursivamente com o proximo elemento
				encontrado = this.next.procurar(CPF);
			}
			return encontrado; //retorna o objeto encontrado
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}

	public void atualizar(Cliente clienteAtualizado) throws ClienteNaoEncontradoException {
		boolean achou = false;
		while (!achou || this.cliente != null) {
			if (this.cliente.getCPF().equals(clienteAtualizado.getCPF())) {
				this.cliente = clienteAtualizado;
				achou = true;
			}
			this.cliente = this.next.cliente;
		}
		if (!achou) {
			throw new ClienteNaoEncontradoException();
		}
	}
	
	public boolean existe(String CPF){
		boolean existe = false;
		if(this.cliente != null){
			if(this.cliente.getCPF().equals(CPF)){
				existe = true;
				return existe;
			}
			this.next.existe(CPF);
		}
		return existe;
	}
	
	public void pedido(Produto produto, int qtde, String CPF) throws ClienteNaoEncontradoException, ProdutoNaoCadastradoException{
		boolean achou = false;
	/*	if( !( produto.getNome().existe() ) ){
			throw new ProdutoNaoCadastradoException();
		} else {
			*/while(this.cliente != null  || !achou){
				if(this.cliente.getCPF().equals(CPF)){
					this.cliente.setGastos(produto.getPreco() * qtde);
					achou = true;
				}
			}
			if(!achou){
				throw new ClienteNaoEncontradoException();
			}
			
		//}
	
	}
	
	public void checkoutCliente(String CPF) throws ClienteNaoEncontradoException{
		boolean achou = false;
		while(this.cliente != null){
			if(this.cliente.getCPF().equals(CPF)){
				this.cliente.zerarGastos();
				achou = true;
			}
		}
		if(!achou){
			throw new ClienteNaoEncontradoException();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public RepositorioClientesLista getNext() {
		return next;
	}

	public void setNext(RepositorioClientesLista next) {
		this.next = next;
	}

	@Override
	public void pedido(String pedido, String CPF) throws ClienteNaoEncontradoException, ProdutoNaoCadastradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zerarGastos(String CPF) throws ClienteNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
