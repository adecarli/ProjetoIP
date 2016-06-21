package exceptions;

public class ProdutoJaCadastradoException extends Exception{
		public ProdutoJaCadastradoException(){
		super("Produto ja cadastrado.\n");
		}
	}
