package exceptions;

public class FuncionarioNaoEncontradoException extends Exception {
	public FuncionarioNaoEncontradoException(){
		super("Funcionario nao encontrado.\n");
	}
}
