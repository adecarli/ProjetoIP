package exceptions;

public class ProdutoNaoCadastradoException extends Exception{
		public ProdutoNaoCadastradoException(String nome){
		super("Produto nao cadastrado: "+nome+"\n");
		}
	}
