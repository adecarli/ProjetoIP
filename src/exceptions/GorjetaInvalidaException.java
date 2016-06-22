package exceptions;

public class GorjetaInvalidaException extends Exception {
	public GorjetaInvalidaException() {
		super("Gorjeta invalida. Valor não pode ser negativo.");
	}
}
