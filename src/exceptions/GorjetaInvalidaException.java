package exceptions;

public class GorjetaInvalidaException extends Exception {
	public GorjetaInvalidaException() {
		super("Gorjeta invalida. Valor n�o pode ser negativo.");
	}
}
