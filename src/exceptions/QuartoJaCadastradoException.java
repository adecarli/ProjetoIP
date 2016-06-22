package exceptions;

public class QuartoJaCadastradoException extends Exception {
	private String numero;
	public QuartoJaCadastradoException(String numero) {
		super("Quarto ja cadastrado.");
		this.numero = numero;
	}
	public String getNumero() {
		return this.numero;
	}
}
