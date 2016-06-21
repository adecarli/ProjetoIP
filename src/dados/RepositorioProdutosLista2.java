package dados;
import classesbasicas.Produto;
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
	public void cadastrar(Produto produto) throws ProdutoJaCadastradoException {
		if (this.proximo == null) {
			this.proximo = new RepositorioProdutosLista();
			this.proximo.produto = produto;
		} else if (this.produto.getNome() == produto.getNome()) {
			throw new ProdutoJaCadastradoException();
		} else {
			this.proximo.cadastrar(produto);
		}
	}

	@Override
	// aqui procura
	public Produto procurar(String nome) throws ProdutoNaoCadastradoException {
		if (this.produto != null && this.produto.getNome() == nome) {
			return this.produto;
		} else {
			if (this.proximo == null) {
				throw new ProdutoNaoCadastradoException();
			} else {
				return this.proximo.procurar(nome);
			}
		}
	}

	@Override
	// aqui remove
	public void remover(String nome) throws ProdutoNaoCadastradoException {
		if (this.proximo.produto.getNome() == nome) {
			if (this.proximo.proximo == null) {
				this.proximo = null;
			} else {
				this.proximo = this.proximo.proximo;
			}
		} else {
			if (this.proximo.proximo == null) {
				// aqui da exception se se não tiver produto cadastrado
				throw new ProdutoNaoCadastradoException();
			} else {
				this.proximo.remover(nome);
			}
		}
	}

	@Override
	public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException {
		Produto produto;
		produto = procurar(nome);
		produto.setPreco(preco);
	}

	@Override
	public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException {
		Produto produto;
		produto = procurar(nome);
		quantidade += produto.getEstoque();
		produto.setEstoque(quantidade);
	}
}
