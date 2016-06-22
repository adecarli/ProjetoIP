package dados;
import classesBasicas.Produto;

public class RepositorioProdutosLista implements RepositorioProdutos {
	private Produto produto;
	private RepositorioProdutosLista proximo;
	private int tamanho=1;
	private int indice=0;
	public RepositorioProdutosLista() {
		this.produto = null;
		this.proximo = null;
	}
	public int getIndice() {
		return indice;
	}
	public int getTamanho() {
		return tamanho;
	}
	@Override
	// aqui cadastra
	public void cadastrar(Produto produto){
		if (this.proximo == null) {
			this.produto = produto;
			this.proximo = new RepositorioProdutosLista();
		} else {
			this.proximo.cadastrar(produto);
		}
	}

	@Override
	// aqui procura
	public Produto procurar(String nome){
		if (this.produto != null && this.produto.getNome().equals(nome)) {
			return this.produto;
		} else if (this.proximo!=null){
				return this.proximo.procurar(nome);
			}
		else{
			return null;
		}
	}

	@Override
	// aqui remove
	public boolean remover(Produto produto){
		boolean achou=false;
		if (this.produto.getNome().equals(produto.getNome())) {
			if (this.proximo== null) {
				this.produto = null;
			} else {
				this.produto= this.proximo.produto;
				this.proximo=this.proximo.proximo;
			}
			achou=true;
		} else {
				return this.proximo.remover(produto);
		}
		return achou;
	}

	@Override
	public void atualizarPreco(Produto produto, double preco){
		produto.setPreco(preco);
	}

	@Override
	public void renovarEstoque(Produto produto, int quantidade){
		//recebe um valor que ir� ser inserido no estoque atual
		quantidade += produto.getEstoque();
		produto.setEstoque(quantidade);
	}
	
	public String visualizarEstoque(String retorno){
		if(this.produto!=null){
			retorno=retorno+this.produto.toString();
		}
		if (this.proximo != null) {
			return this.proximo.visualizarEstoque(retorno);
		}
		else{
		return retorno;
		}
	}
}
