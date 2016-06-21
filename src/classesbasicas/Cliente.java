package classesbasicas;

public class Cliente {
	private String nome;
	private String CPF;
	private double gastos;
	private int vezes;
	
	
	
	public Cliente(String nome, String CPF) { //construtor do Cliente indo pela primeira vez
		this(nome,CPF,0);
	}
	
	
	public Cliente(String nome, String CPF, int vezes) { //construtor do Cliente que já veio ao hotel anteriormente
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
		this.gastos = this.gastos + gastos;
	}
	
	public int getVezes(){
		return this.vezes;
	}
	
	public void setVezes(){
		this.vezes++;
	}
	public void zerarGastosCliente(){
		this.gastos = 0;
	}
	
	
	
	
}
