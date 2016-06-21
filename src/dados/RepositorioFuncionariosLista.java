package dados;
import classesBasicas.Funcionario;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios {
	private Funcionario funcionario;
	private RepositorioFuncionariosLista proximo;
	
	public RepositorioFuncionariosLista(){
		this.funcionario = null;
		this.proximo = null;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public RepositorioFuncionariosLista getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioFuncionariosLista proximo) {
		this.proximo = proximo;
	}

	public void inserir(Funcionario funcionario){
		// inserir novo funcionario no fim da lista, preciso procurar o ultimo objeto
		if (this.proximo == null){ //qnd proximo nao fizer referencia a nenhum outro, cheguei no fim, insiro
			this.funcionario = funcionario;
			this.proximo = new RepositorioFuncionariosLista(); 
		} else { // chamo o metodo recursivamente ate achar o ultimo elemento
			this.proximo.inserir(funcionario);
		}
	}
	
	public Funcionario procurar(String CPF) {
		Funcionario retorno;
		// percorro a lista enquanto nao encontrar o funcionario 
		if (this.funcionario.getCPF().equals(CPF)){
			retorno = this.funcionario;
		} else { 
			retorno = this.proximo.procurar(CPF);
		}
		return retorno;
	}
	
	public void remover(String CPF) {
		// percorro a lista procurando o funcionario a ser removido
		if (this.funcionario.getCPF().equals(CPF)){ // vejo se esse eh o funcionario procurado
			this.funcionario = this.proximo.funcionario;
			this.proximo = this.proximo.proximo;
		} else { // se nao for, chamo o remover do proximo funcionario
			this.proximo.remover(CPF);
		}
	}
	
	public void atualizar(Funcionario funcionario) {
		String CPF = funcionario.getCPF(); //armazeno o CPF do funcionario recebido como parametro numa variavel
		if (this.funcionario.getCPF().equals(CPF)){ //checo se esse eh o funcionario a ser atualizado
			this.funcionario = funcionario; // atualizo
		} else { // se nao for, chamo atualizar no proximo funcionario
			this.proximo.atualizar(funcionario);
		}
	}
	
	public boolean existe(String CPF){
		boolean existe;
		if(this.funcionario != null){ 
			if(this.funcionario.getCPF().equals(CPF)){
				existe = true; // se o CPF do funcionario armazenado for igual ao CPF recebido como parametro, entao o funcionario existe
			} else { // se ainda nao chegou no fim da lista e nao foi encontrado o funcionario, chamo o proximo para checar
				existe = this.proximo.existe(CPF);
			}
		} else { // chegou no fim da lista e nao encontrou, entao o funcionario nao existe
			existe = false;
		}
		return existe;
	}
	
	public String toString(){
		Funcionario funcionario = this.funcionario;
		String lista = "";
		while(funcionario != null){
			lista += funcionario.toString();
			funcionario = proximo.getFuncionario();
		}
		return lista;
	}

}
