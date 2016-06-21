package classesBasicas;

public class Cliente {
	private String nome;
	private String CPF;
	private double gastos;

	
	public Cliente(String nome, String CPF) { //construtor do Cliente que já veio ao hotel anteriormente
		this.nome = nome;
		this.CPF = CPF;
		this.gastos = 0;	
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Double getGastos() {
		return gastos;
	}

	public void setGastos(Double gastos) {
		this.gastos =  gastos;
	}
	

	public void zerarGastosCliente(){
		this.gastos = 0;
	}
	
	public void totalGastos(Double gastos) {
		this.gastos = this.gastos + gastos;
	}
	public String toString(){
		String funcionario = "";
		funcionario += "Nome: " + getNome() + ", CPF: " + getCPF() + ", Gastos: " + getGastos() + ".\n";
		return funcionario;
	}
	
	
	
	
}
