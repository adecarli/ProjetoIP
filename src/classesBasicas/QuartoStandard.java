package classesBasicas;

public class QuartoStandard extends QuartoAbstrato {

	public QuartoStandard(String numero, double valorDiaria) {
		super(numero, valorDiaria);
	}
	@Override
	public void pedido(double valor) {
		this.setTotal(this.getTotal() + valor);
	}
	public String toString() {
		String s = "";
		s += super.toString() + " | Tipo: Standard\n";
		return s;
	}
}
