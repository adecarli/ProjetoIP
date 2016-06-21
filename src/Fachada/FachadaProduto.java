package Fachada;

import classesBasicas.Produto;
import exceptions.*;
import negocio.*;

public class FachadaProduto {
	CadastroProdutos cadProdutos= new CadastroProdutos();
	public void cadastrarProduto (String nome, double preco, int quantidade) throws PrecoInvalidoException, ProdutoJaCadastradoException, ProdutoNaoCadastradoException{
		if(preco<=0){
			throw new PrecoInvalidoException();
		}
		if(quantidade<=0){
			throw new PrecoInvalidoException();
		}
		Produto produto= new Produto (nome, preco, quantidade);
		cadProdutos.cadastrarProduto(produto);
	}
	public void removerProduto(String nome) throws ProdutoNaoCadastradoException{
		cadProdutos.removerProduto(nome);
	}
	public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException, PrecoInvalidoException{
		if (preco<=0){
			throw new PrecoInvalidoException();
		}
		else
		cadProdutos.atualizarPreco(nome, preco);
	}
	public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException, QuantidadeInvalidaException{
		if (quantidade<=0){
			throw new QuantidadeInvalidaException();
		}
		else
		cadProdutos.renovarEstoque(nome, quantidade);
	}
}
