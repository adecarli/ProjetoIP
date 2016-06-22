package exceptions;

public class AdicionarCamaException extends Exception {
	public AdicionarCamaException() {
		super("Tipo de quarto invalido. Apenas para quartos de luxo.");
	}
}
