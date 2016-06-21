package dados;
import classesbasicas.Produto;
import exceptions.*;

public interface RepositorioProdutos {
	void cadastrar(Produto produto) throws ProdutoJaCadastradoException;

	Produto procurar(String nome) throws ProdutoNaoCadastradoException;

	void remover(String nome) throws ProdutoNaoCadastradoException;

	void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException;

	void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException;
}
