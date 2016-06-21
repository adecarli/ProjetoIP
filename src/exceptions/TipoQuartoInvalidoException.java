package exceptions;

public class TipoQuartoInvalidoException extends Exception {
	public TipoQuartoInvalidoException() {
		super("Tipo invalido. Escolha entre Standard ou Luxo");
	}

}
