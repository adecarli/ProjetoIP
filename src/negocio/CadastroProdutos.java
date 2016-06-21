package negocio;
import classesBasicas.*;
import dados.*;
import exceptions.*;
public class CadastroProdutos{
	RepositorioProdutos produtos= new RepositorioProdutosArray();
	public CadastroProdutos(){
		produtos=null;
	}
public void cadastrarProduto (Produto produto) throws ProdutoJaCadastradoException, ProdutoNaoCadastradoException{
	Produto compara=produtos.procurar(produto.getNome());
	if(compara!=null){
		throw new ProdutoJaCadastradoException();
	}
	else{
		produtos.cadastrar(produto);
	}
}
public void removerProduto(String nome) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	if(produto!=null){
	boolean removido=produtos.remover(produto);
	if(!removido){
		throw new ProdutoNaoCadastradoException();
	}
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	if (produto!=null&&produto.getNome().equals(nome)){
		produtos.atualizarPreco(produto, preco);
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	if (produto!=null&&produto.getNome().equals(nome)){
		produtos.renovarEstoque(produto, quantidade);
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
}
