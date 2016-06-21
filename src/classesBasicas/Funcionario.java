package classesBasicas;

public class Funcionario {
	
	private String nome;
	private String CPF;
	private String funcao;
	private double salario;
	private double gorjeta;
	
	public Funcionario(String nome, String CPF, String funcao, double salario){
		this.nome = nome;
		this.CPF = CPF;
		this.funcao = funcao;
		this.salario = salario;
		this.gorjeta = 0;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setCPF(String CPF){
		this.CPF = CPF;
	}
	
	public String getCPF(){
		return this.CPF;
	}
	
	public void setFuncao(String funcao){
		this.funcao = funcao;
	}
	
	public String getFuncao(){
		return this.funcao;
	}
	
	public void setSalario(double salario){
		this.salario = salario;
	}
	
	public double getSalario(){
		return this.salario;
	}
	
	public void setGorjeta(double valor){
		this.gorjeta = valor;
	}
	
	public double getGorjeta(){
		return this.gorjeta;
	}
	
	public double getPagamento(){
		double pagamento = salario + gorjeta;
		return pagamento;
	}
	
	public void trabalhar(double valor){
		gorjeta = gorjeta + valor;
	}
	
	public String toString(){
		String funcionario = "";
		funcionario += "Nome: " + getNome() + ", CPF: " + getCPF() + ", Funcao: " + getFuncao() + ", Pagamento: " + getPagamento() + ".\n";
		return funcionario;
	}

}
