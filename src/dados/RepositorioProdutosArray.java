package dados;

import classesBasicas.Produto;
import exceptions.*;

public class RepositorioProdutosArray implements RepositorioProdutos {
	private Produto[] arrayProdutos;
	private int indice;
	private int tamanho;
	public RepositorioProdutosArray() {
		this.arrayProdutos = new Produto[20];
		this.indice = 0;
		this.tamanho=20;
	}
	public RepositorioProdutosArray(int tamanho) {
		this.arrayProdutos = new Produto[tamanho];
		this.indice = 0;
		this.tamanho=tamanho;
	}
	public int getIndice() {
		return indice;
	}
	public int getTamanho() {
		return tamanho;
	}
	public Produto getProduto(int indice){
		return arrayProdutos[indice];
	}
	@Override
	public void cadastrar(Produto produto){
		//cadastra o produto no indice atual
		this.arrayProdutos[this.indice]=produto;
		this.arrayProdutos[this.indice].setIndice(this.indice);
		this.indice++;
	}
	@Override
	public Produto procurar(String nome){
		//retorna o produto procurado ou null se não achar nenhum
		Produto retorno=null;
		boolean achou=false;
		for (int i=0; i<=indice&&i<tamanho&&achou==false; i++){
			if(arrayProdutos[i]!=null&&arrayProdutos[i].getNome().equals(nome)){
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
		if(produto.getIndice()==1){
			arrayProdutos[produto.getIndice()]=null;
		}
		else if(produto.getIndice()==tamanho){
			arrayProdutos[produto.getIndice()]=null;
		}
		else{
		arrayProdutos[produto.getIndice()]=arrayProdutos[indice-1];
		arrayProdutos[produto.getIndice()].setIndice(produto.getIndice());
		arrayProdutos[indice-1]=null;
		}
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
	public String visualizarEstoque(String retorno){
		for (int i= 0; i<this.indice;i++){
			if(arrayProdutos[i]!=null){
			retorno=retorno+arrayProdutos[i].toString();
			}
		}
		return retorno;
	}
}
