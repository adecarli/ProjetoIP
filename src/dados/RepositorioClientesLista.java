package dados;

import classesBasicas.Cliente;


public class RepositorioClientesLista implements RepositorioClientes {
	// atributos
	private Cliente cliente;
	private RepositorioClientesLista next;

	// construtor
	public RepositorioClientesLista() {
		this.cliente = null;
		this.next = null;
	}

	public void inserirCliente(Cliente cliente) {
		if (this.cliente == null) { // caso não haja um cliente naquela posicao,
									// o novo cliente eh inserido la
			this.cliente = cliente;
			this.next = new RepositorioClientesLista();
		} else {
			this.next.inserirCliente(cliente); // caso haja, chama o metodo recursivo
										// no proximo item da lsita
		}
	}

	public void removerCliente(String CPF){ //metodo recursivo de remocao
		if(this.cliente !=null){
			if(this.cliente.getCPF().equals(CPF)){ //quando encontro o cpf igual, faco a substituicao
				this.cliente = this.next.cliente; //faco o ponteiro desse cliente apontar para o proximo
				this.next = this.next.next; //e assim sucessivamente
			}
			else{
				this.next.removerCliente(CPF); //se não encontro, chamo o metodo recursivamente
			}
		}
			
	}

	public Cliente procurarCliente(String CPF) {
		Cliente encontrado = null;
		if(this.cliente!=null) {	
			if (this.cliente.getCPF().equals(CPF)) { //quando encontra um cliente com o CPF igual ao procurado
				encontrado = this.cliente;	
			}
			else{ //se nao for encontrado, chama o metodo recursivamente com o proximo elemento
				encontrado = this.next.procurarCliente(CPF);
			}	
		}
		return encontrado; //retorna o objeto encontrado
	}

	public void atualizarCliente(Cliente clienteAtualizado) {
		if (this.cliente.getCPF().equals(clienteAtualizado.getCPF())) {
			this.cliente = clienteAtualizado;		
		} else {
			this.next.atualizarCliente(clienteAtualizado);
		}
	}
		
	public boolean existeCliente(String CPF){
		boolean existe = false;
		if(this.next != null){
			if(this.cliente.getCPF().equals(CPF)){
				existe = true;
			}else {
				existe = this.next.existeCliente(CPF);
			}
		}
		return existe;
	}
	
	public void zerarGastosCliente(String CPF) {
		if(this.cliente!=null){
			if(this.cliente.getCPF().equals(CPF)){	
				this.cliente.zerarGastosCliente();
			}
		}
		this.next.zerarGastosCliente(CPF);
	}
	
	public void adicionarGastosCliente(String CPF, double gasto){
		if(this.cliente!=null){
			if(this.cliente.getCPF().equals(CPF)){	
				this.cliente.totalGastos(gasto);
			}
		}
		this.next.zerarGastosCliente(CPF);
	}
		
	public double gastosCliente(String CPF){
		double gastos = 0;
		if(this.cliente != null){
			if(this.cliente.getCPF().equals(CPF)){
				gastos = this.cliente.getGastos();
			} else {
				this.next.gastosCliente(CPF);
			}
		}
		return gastos;
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

	

}