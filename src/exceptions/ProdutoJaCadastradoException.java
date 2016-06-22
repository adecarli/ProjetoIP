package exceptions;

import classesBasicas.Produto;

public class ProdutoJaCadastradoException extends Exception{
		public ProdutoJaCadastradoException(Produto produto){
		super("Produto ja cadastrado: "+produto.toString()+"\n");
		}
	}
