package Fachada;

public class EstoqueInsuficienteException extends Exception {
	public EstoqueInsuficienteException(){
		super("Estoque Insuficiente.");
	}
}
