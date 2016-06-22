package classesBasicas;

public abstract class QuartoAbstrato {
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
	public void checkin(Cliente hospede, int dias) {
		this.hospede = hospede;
		this.total = dias*this.valorDiaria;
		this.limpo = false;
	}
	public double checkout() {
		this.hospede = null;
		double total = this.total;
		this.total = 0;
		this.limpo = true;
		return total;
	}
	public void limpar() {
		limpo = true;
	}
	public Cliente getHospede() {
		return this.hospede;
	}
	public String getNumero() {
		return this.numero;
	}
	public void setDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public double getDiaria() {
		return this.valorDiaria;
	}
	protected void setTotal(double total) {
		this.total = total;
	}
	public double getTotal() {
		return this.total;
	}
	public boolean getLimpo() {
		return this.limpo;
	}
	public String toString() {
		String s = "";
		s += "Numero: " + this.numero + " | Valor da Diaria: " + this.valorDiaria + " | Gastos: " + this.total;
		if (this.hospede == null) {
			s += " | Status: Disponivel";
		} else {
			s += " | Status: Ocupado";
		}
		return s;
	}
}
