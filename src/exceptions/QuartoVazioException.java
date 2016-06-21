package exceptions;

public class QuartoVazioException extends Exception{
	private String numero;
	public QuartoVazioException(String numero) {
		super("Quarto vazio.");
		this.numero = numero;
	}
	public String getNumero() {
		return numero;
	}
}
