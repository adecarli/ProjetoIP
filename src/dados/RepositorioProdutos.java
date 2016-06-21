package dados;
import classesBasicas.Produto;
import exceptions.*;

public interface RepositorioProdutos {
	void cadastrar(Produto produto) throws ProdutoJaCadastradoException;

	Produto procurar(String nome) throws ProdutoNaoCadastradoException;

	boolean remover(Produto produto) throws ProdutoNaoCadastradoException;

	void atualizarPreco(Produto produto, double preco) throws ProdutoNaoCadastradoException;

	void renovarEstoque(Produto produto, int quantidade) throws ProdutoNaoCadastradoException;
}
