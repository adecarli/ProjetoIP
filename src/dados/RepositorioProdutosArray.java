package dados;

import classesbasicas.Produto;
import exceptions.*;

public class RepositorioProdutosArray implements RepositorioProdutos {
	private Produto[] arrayProdutos;
	private int indice;
	public RepositorioProdutosArray() {
		this.arrayProdutos = new Produto[100];
		this.indice = 0;
	}
	@Override
	public void cadastrar(Produto produto) throws ProdutoJaCadastradoException {
		this.arrayProdutos[indice]=produto;
		indice++;
	}
	@Override
	public Produto procurar(String nome) throws ProdutoNaoCadastradoException {
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
	public void remover(String nome) throws ProdutoNaoCadastradoException {
		int remover=procurar(nome).getIndice();
		arrayProdutos[remover]=arrayProdutos[indice-1];
		arrayProdutos[remover].setIndice(remover);
		indice--;
	}
	@Override
	public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException {
		int atualizar=procurar(nome).getIndice();
		arrayProdutos[atualizar].setPreco(preco);
	}
	@Override
	public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException {
		int atualizar=procurar(nome).getIndice();
		quantidade+=arrayProdutos[atualizar].getEstoque();
		arrayProdutos[atualizar].setEstoque(quantidade);
	}
}
