package exceptions;

public class QuartoLimpoException extends Exception {
	private String numero;
	public QuartoLimpoException(String numero) {
		super("Quarto ja esta limpo.\n");
		this.numero = numero;
	}
	public String getNumero() {
		return numero;
	}
}
