package exceptions;

public class EstoqueInsuficienteException extends Exception {
	private int quantidade;
	public EstoqueInsuficienteException(int quantidade){
		super("Estoque Insuficiente.\nEstoque atual: "+ quantidade+"\n");
		this.quantidade=quantidade;
	}
}
