package exceptions;

public class QuartoVazioException extends Exception{
	private String numero;
	public QuartoVazioException(String numero) {
		super("Quarto vazio.\n");
		this.numero = numero;
	}
	public String getNumero() {
		return numero;
	}
}
