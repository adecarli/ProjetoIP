package negocio;
import classesBasicas.*;
import dados.*;
import exceptions.*;
public class NegociosProdutos{
	RepositorioProdutos produtos= new RepositorioProdutosArray();
	RepositorioClientes clientes= new RepositorioClientesArray();
public void cadastrarProduto (String nome, double preco, int quantidade) throws ProdutoJaCadastradoException, ProdutoNaoCadastradoException{
	Produto produto= new Produto (nome, preco, quantidade);
	Produto compara=produtos.procurar(nome);
	if(compara!=null){
		throw new ProdutoJaCadastradoException();
	}
	else{
		produtos.cadastrar(produto);
	}
}
public void removerProduto(String nome) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	if (produto.getNome().equals(nome)){
		produtos.remover(produto);
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	if (produto.getNome().equals(nome)){
		produtos.atualizarPreco(produto, preco);
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	if (produto.getNome().equals(nome)){
		produtos.renovarEstoque(produto, quantidade);
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
public void pedido(String nome, String produto) throws ClienteNaoEncontradoException{
	Cliente cliente=clientes.procurar(nome);
	
}
}
