package dados;
import classesBasicas.Produto;
import exceptions.*;

public class RepositorioProdutosLista implements RepositorioProdutos {
	private Produto produto;
	private RepositorioProdutosLista proximo;

	RepositorioProdutosLista() {
		this.produto = null;
		this.proximo = null;
	}

	@Override
	// aqui cadastra
	public void cadastrar(Produto produto){
		if (this.proximo == null) {
			this.proximo = new RepositorioProdutosLista();
			this.proximo.produto = produto;
		} else {
			this.proximo.cadastrar(produto);
		}
	}

	@Override
	// aqui procura
	public Produto procurar(String nome){
		if (this.produto != null && this.produto.getNome() == nome) {
			return this.produto;
		} else {
				return this.proximo.procurar(nome);
			}
	}

	@Override
	// aqui remove
	public boolean remover(Produto produto){
		boolean achou=false;
		if (this.proximo.produto.getNome() == produto.getNome()) {
			if (this.proximo.proximo == null) {
				this.proximo = null;
			} else {
				this.proximo = this.proximo.proximo;
			}
			achou=true;
		} else {
				this.proximo.remover(produto);
		}
		return achou;
	}

	@Override
	public void atualizarPreco(Produto produto, double preco){
		produto.setPreco(preco);
	}

	@Override
	public void renovarEstoque(Produto produto, int quantidade){
		quantidade += produto.getEstoque();
		produto.setEstoque(quantidade);
	}
}
