package Fachada;

import classesBasicas.Produto;
import exceptions.*;
import negocio.*;

public class FachadaProduto {
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
	
	public void fazerPedido(String cpf, String produto, int qtde) throws EstoqueInsuficienteException,ProdutoNaoCadastradoException, ClienteNaoEncontradoException, PrecoInvalidoException{
		Produto pedido = cadProdutos.procurarProduto(produto);
		if (pedido==null){
			throw new ProdutoNaoCadastrado();
		}
		else{
		double valor = pedido.getPreco()*qtde;
		if ((pedido.getQuantidade()-qtde)<0){
			throw new EstoqueInsuficenteException(pedido.getQuantidade());
		}
		else{
		cadClientes.adicionarGastosCliente(cpf, valor);
		pedido.setQuantidade(pedido.getQuantidade()-qtde);
		}
		}
	}
	public String informacoesProduto(String nome) throws ProdutoNaoCadastradoException{
		Produto produto=produtos.procurar(nome);
		if (produto!=null){
		return cadProdutos.informacoesProduto(produto);
		}
		else{
			throw new ProdutoNaoCadastrado();
		}
	}
	public String visualizarEstoque(){
		if(cadProdutos!=null){
		return cadProdutos.visualizarEstoque();
		}
	}
}
