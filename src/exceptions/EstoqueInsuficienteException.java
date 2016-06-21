package exceptions;

public class EstoqueInsuficienteException extends Exception {
	private int quantidade;
	public EstoqueInsuficienteException(int quantidade){
		super("Estoque Insuficiente. Estoque atual: "+ quantidade);
		this.quantidade=quantidade;
	}
}
