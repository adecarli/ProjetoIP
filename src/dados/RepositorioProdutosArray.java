package dados;

import classesBasicas.Produto;
import exceptions.*;

public class RepositorioProdutosArray implements RepositorioProdutos {
	private Produto[] arrayProdutos;
	private int indice;
	public RepositorioProdutosArray() {
		this.arrayProdutos = new Produto[20];
		this.indice = 0;
	}
	@Override
	public void cadastrar(Produto produto){
		//cadastra o produto no indice atual
		this.arrayProdutos[this.indice]=produto;
		this.arrayProdutos[this.indice].setIndice(this.indice);
		indice++;
	}
	@Override
	public Produto procurar(String nome){
		//retorna o produto procurado ou null se não achar nenhum
		Produto retorno=null;
		boolean achou=false;
		for (int i=0; i<=indice&&achou==false; i++){
			if(nome==arrayProdutos[i].getNome()){
				retorno= arrayProdutos[i];
				achou=true;
			}
		}
		return retorno;
	}
	@Override
	public boolean remover(Produto produto){
		//remove e informa se o mesmo foi removido ou não
		boolean removido=false;
		if (produto!=null){
		arrayProdutos[produto.getIndice()]=arrayProdutos[indice-1];
		arrayProdutos[produto.getIndice()].setIndice(produto.getIndice());
		indice--;
		removido=true;
		}
		return removido;
	}
	@Override
	public void atualizarPreco(Produto produto, double preco){
		//apenas atualiza o produto
		produto.setPreco(preco);
	}
	@Override
	public void renovarEstoque(Produto produto, int quantidade){
		//recebe um valor para ser inserido a quantidade inicial
		quantidade+=produto.getEstoque();
		produto.setEstoque(quantidade);
	}
}
