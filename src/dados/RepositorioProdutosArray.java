package dados;

import classesBasicas.Produto;
import exceptions.*;

public class RepositorioProdutosArray implements RepositorioProdutos {
	private Produto[] arrayProdutos;
	private int indice;
	public RepositorioProdutosArray() {
		this.arrayProdutos = new Produto[100];
		this.indice = 0;
	}
	@Override
	public void cadastrar(Produto produto){
		this.arrayProdutos[indice]=produto;
		indice++;
	}
	@Override
	public Produto procurar(String nome){
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
		produto.setPreco(preco);
	}
	@Override
	public void renovarEstoque(Produto produto, int quantidade){
		quantidade+=produto.getEstoque();
		produto.setEstoque(quantidade);
	}
}
