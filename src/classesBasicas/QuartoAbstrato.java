package classesBasicas;

public abstract class QuartoAbstrato {
	//O numero do quarto servira como identificador do mesmo
	private String numero;
	private Cliente hospede;
	private double valorDiaria;
	private double total;
	private boolean limpo;
	
	public QuartoAbstrato(String numero, double valorDiaria) {
		this.numero = numero;
		this.valorDiaria = valorDiaria;
		this.hospede = null;
		this.total = 0;
		this.limpo = true;
	}
	
	public abstract void pedido(double valor);
	
	public void checkin(Cliente cliente, int dias) {
		this.hospede = cliente;
		this.total = this.valorDiaria*dias;
		this.limpo = false;
	}
	
	public double checkout(){
		this.hospede = null;
		double total = this.total;
		this.total = 0;
		return total;
	}
	
	public void limpar(){
		limpo = true;
	}
	
	public Cliente getHospede(){
		return hospede;
	}
	public String getNumero() {
		return numero;
	}
	public double getDiaria() {
		return valorDiaria;
	}
	protected void setTotal(double total) {
		this.total = total;
	}
	public double getTotal() {
		return total;
	}
	public boolean getLimpo() {
		return limpo;
	}
	
}
