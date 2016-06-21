package negocio;
import classesbasicas.*;
import exceptions.*;
import dados.*;
public class Cardapio {
	RepositorioProdutos produtos;
public void cadastrarProduto(Produto produto){
	try{
		produtos.cadastrar(produto);
	}catch(ProdutoJaCadastradoException e){
		System.out.println(e.getMessage());
	}
}
public Produto procurarProduto(String nome){
	Produto produto=null;
	try{
		produto=produtos.procurar(nome);
	}catch(ProdutoNaoCadastradoException e){
		System.out.println(e.getMessage());
	}
	return produto;
}
public void removerProduto(String nome){
	try{
		produtos.remover(nome);
	}catch(ProdutoNaoCadastradoException e){
		System.out.println(e.getMessage());
	}
}
public void renovarEstoque(String nome, int quantidade){
	try{
		produtos.renovarEstoque(nome, quantidade);
	}catch(ProdutoNaoCadastradoException e){
		System.out.println(e.getMessage());
	}
}
public void atualizarPreco(String nome, double preco){
	try{
		produtos.atualizarPreco(nome,preco);
	}catch(ProdutoNaoCadastradoException e){
		System.out.println(e.getMessage());
	}
}
}
