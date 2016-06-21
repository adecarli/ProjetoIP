package exceptions;

public class ClienteJaCadastradoException extends Exception{
	
	public ClienteJaCadastradoException(){
		super("Hospede ja cadastrado");
	}
}
