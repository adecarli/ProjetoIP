package exceptions;
import classesbasicas.Cliente;
public class QuartoOcupadoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numero;
	private Cliente cliente; 
	public QuartoOcupadoException(String numero, Cliente cliente) {
		super("Quarto ocupado.");
		this.numero = numero;
		this.cliente = cliente;
	}
	public String getNumero() {
		return numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
}
