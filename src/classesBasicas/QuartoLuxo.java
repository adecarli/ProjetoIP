package classesBasicas;

public class QuartoLuxo extends QuartoAbstrato {
	private static final double desconto = 0.1;
	public QuartoLuxo(String numero, double valorDiaria) {
		super(numero, valorDiaria);
	}
	@Override
	public void pedido(double valor) {
		double novoValor = valor*(1-desconto);
		this.setTotal(this.getTotal() + novoValor);
	}
	@Override
	public String toString() {
		String s = "";
		s += "Numero: " + this.getNumero() + " | Valor da Diaria: " + this.getDiaria() + " | Tipo: Luxo\n";
		return s;
	}
}
