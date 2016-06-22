package classesBasicas;

public class QuartoLuxo extends QuartoAbstrato {
	private static final double desconto = 0.1;
	private boolean camaExtra;
	public QuartoLuxo(String numero, double valorDiaria) {
		super(numero, valorDiaria);
		this.camaExtra = false;
	}
	@Override
	public void pedido(double valor) {
		double novoValor = valor*(1-desconto);
		this.setTotal(this.getTotal() + novoValor);
	}
	public void adicionarCama() {
		this.setDiaria(this.getDiaria()*1.1);
		this.camaExtra = true;
	}
	public void removerCama() {
		this.setDiaria(this.getDiaria()/1.1);
		this.camaExtra = false;
	}
	public boolean getCamaExtra() {
		return this.camaExtra;
	}
	public double checkout() {
		if (this.camaExtra) {
			this.removerCama();
		}
		return super.checkout();
	}
	@Override
	public String toString() {
		String s = "";
		s += super.toString() + " | Tipo: Luxo\n";
		return s;
	}
}
