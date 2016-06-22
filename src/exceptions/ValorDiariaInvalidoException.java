package exceptions;

public class ValorDiariaInvalidoException extends Exception {
	public ValorDiariaInvalidoException() {
		super("Valor da diaria invalido. Digite um numero positivo.");
	}
}
