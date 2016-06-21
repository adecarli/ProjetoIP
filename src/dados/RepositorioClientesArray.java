package dados;

import classesBasicas.Cliente;
import classesBasicas.QuartoLuxo;
import classesBasicas.QuartoStandard;


public class RepositorioClientesArray implements RepositorioClientes { // cadastrar, remover, procurar, atualizar
	int maximo;
	private Cliente[] ArrayClientes;
	private int indice;

	public RepositorioClientesArray() {
		this.maximo = 100;
		this.ArrayClientes = new Cliente[maximo];
		this.indice = 0;
	}

	private int getIndiceCliente(String CPF){
		int i = 0;
		boolean achou = false;
		while ( i < indice && !achou) { // procura a posicao do array onde o Cliente procurado esta
			if (ArrayClientes[i].getCPF().equals(CPF)) { 
				achou = true; //se encontrar o indice, sai do laco e muda o valor da variavel para a excessao
			} else {
				i++;				
			}
		}
			return i; //retorna a posicao do cliente no array
	
	}

	public void inserirCliente(Cliente cliente) {
		if (indice >= maximo) { // testo pra ver se o array ainda tem posicao disponivel
			Cliente[] newArrayClientes = new Cliente[2 * maximo]; // Caso esteja cheio, crio um array auxiliar para aumentar, com o dobro do tamanho
			for (int i = 0; i < maximo; i++) {
				newArrayClientes[i] = ArrayClientes[i]; // insiro os clientes ja cadastrados no array "antigo" no novo array
			}
			ArrayClientes = newArrayClientes; // o ponteiro o array antigo, agora aponta para o novo ponteiro
			maximo = 2 * maximo; // o inteiro auxiliar, que testa o tamanho do array recebe agora o dobro dele mesmo (ou seja, o novo tamanho)
		}

		ArrayClientes[indice] = cliente; // insere o cliente naquele indice
		indice++; // incrementa o indice para proximo cadastro
	}

	public void removerCliente(String CPF){
		if (getIndiceCliente(CPF) != indice) {
			int i = getIndiceCliente(CPF);
			// caso encontre aquele cliente, a posicao dele recebe o cliente da
			// posicao segunte e o indice eh decrementado posteriormente
			if (ArrayClientes[i].getCPF().equals(CPF)) {
				for (int j = i; (j + 1) < indice; j++) {
					ArrayClientes[j] = ArrayClientes[j + 1];

				}
				indice--;
			}
		} 
	}

	public Cliente procurarCliente(String CPF){ 
		Cliente achou = null;
		for(int i =0; i<indice ; i++){
			if(ArrayClientes[i].getCPF().equals(CPF)){
				achou = ArrayClientes[i];
			}
		}
		return achou;
		
	}

	public void atualizarCliente(Cliente clienteAtualizado){
		for(int i = 0; i<indice; i++){
			if(ArrayClientes[i].getCPF().equals(clienteAtualizado.getCPF())){
				ArrayClientes[i] = clienteAtualizado;
			}
		}	
	}
	
	public boolean existeCliente(String CPF){
		boolean existe = false;
		for(int i = 0; i<indice;i++){
			if(ArrayClientes[i].getCPF().equals(CPF)){
				existe = true;
			}
		}
		return existe;
		
	}	
	public void zerarGastosCliente(String CPF){
		boolean achou = false;
			for(int i = 0; i<indice || (!achou); i++){
				if(ArrayClientes[i].getCPF().equals(CPF)){
					achou = true;
					ArrayClientes[i].zerarGastosCliente();
				}
		}
			
	}
	public void adicionarGastosCliente(String CPF, double gasto){
		boolean achou = false;
			for(int i = 0; i<indice || (!achou); i++){
				if(ArrayClientes[i].getCPF().equals(CPF)){
					achou = true;
					ArrayClientes[i].setGastos(gasto);
				}
		}
			
	}
	//-----Testes
	public static void main(String[] args) {
		RepositorioClientesArray rep = new RepositorioClientesArray();
		Cliente c = new Cliente("Andre", "086");
		rep.inserirCliente(c);
		rep.inserirCliente(new Cliente("Malu", "123"));
		System.out.println(rep.procurarCliente("086").getNome());
		System.out.println(rep.procurarCliente("123").getNome());
		rep.removerCliente("086");
		System.out.println(rep.procurarCliente("123").getNome());
		rep.inserirCliente(c);
		c = new Cliente("Andre De Carli", "086");
		rep.atualizarCliente(c);
		System.out.println(rep.procurarCliente("086").getNome());
//		rep.remover("2");
//		System.out.println(rep.toString());
//		rep.inserir(new QuartoLuxo("3", 20));
//		System.out.println(rep.toString());
//		q = new QuartoStandard("3", 10);
//		rep.atualizar(q);
//		System.out.println(rep.toString());
	}

		

}
