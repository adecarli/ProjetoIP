package dados;
import classesBasicas.Produto;
import exceptions.*;

public interface RepositorioProdutos {
	void cadastrar(Produto produto);

	Produto procurar(String nome);

	boolean remover(Produto produto);

	void atualizarPreco(Produto produto, double preco);

	void renovarEstoque(Produto produto, int quantidade);
	
	String visualizarEstoque(String retorno);
}
