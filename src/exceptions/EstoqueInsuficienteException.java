package Fachada;

public class EstoqueInsuficienteException extends Exception {
	private int quantidade;
	public EstoqueInsuficienteException(int quantidade){
		this.quantidade=quantidade;
		super("Estoque Insuficiente. Estoque atual: "+this.quantidade);
	}
}
