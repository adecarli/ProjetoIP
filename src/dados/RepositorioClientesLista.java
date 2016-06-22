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
		if (this.cliente.getCPF().equals(clienteAtualizado.getCPF())) {	//quando encontra um cliente, atualiza a informacao dele
			this.cliente = clienteAtualizado;		
		} else { 	//se nao, lanca exception
			this.next.atualizarCliente(clienteAtualizado);
		}
	}
		
	public boolean existeCliente(String CPF){
		boolean existe = false;
		if(this.next != null){
			if(this.cliente.getCPF().equals(CPF)){ //quando encontra um cliente, retorna um boolean com verdadeiro, caso contrario, retorna falso
				existe = true;
			}else {
				existe = this.next.existeCliente(CPF); //metodo recursivo para procurar na lista
			}
		}
		return existe;
	}
	

	public void adicionarGastosCliente(String CPF, double gasto){
		if(this.cliente!=null){
			if(this.cliente.getCPF().equals(CPF)){	//adiciona num double de gasto na conta do cliente
				this.cliente.totalGastos(gasto);
			} else {
				this.next.adicionarGastosCliente(CPF, gasto);
			}
		}
		
	}
		
	public double gastosCliente(String CPF){ 
		double gastos = 0;
		if(this.cliente != null){
			if(this.cliente.getCPF().equals(CPF)){ //quando encontra o cliente com o cpf dado, retorna o valor da conta dele
				gastos = this.cliente.getGastos();
			} else {
				this.next.gastosCliente(CPF);
			}
		}
		return gastos;
	}
	public String toString() {
		String s = "";
		if (this.next != null) {
			s += this.cliente.toString();
			s += this.next.toString();
		}
		return s;
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