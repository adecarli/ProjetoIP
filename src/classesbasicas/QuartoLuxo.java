package classesbasicas;
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

}
