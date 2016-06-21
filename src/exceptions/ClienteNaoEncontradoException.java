package exceptions;

public class ClienteNaoEncontradoException extends Exception{
	public ClienteNaoEncontradoException(){
		super("Hospede nao encontrado");
	}
}
