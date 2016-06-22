package negocio;
import classesBasicas.*;
import dados.*;
import exceptions.*;
public class CadastroProdutos{
	private RepositorioProdutos produtos;
	public CadastroProdutos(RepositorioProdutos repositorio){
		this.produtos=repositorio;
	}
//verifica se há algum produto igual antes de adicionar um novo produto
public void cadastrarProduto (Produto produto) throws ProdutoJaCadastradoException, ProdutoNaoCadastradoException{

	//se o retorno não for nulo, quer dizer que há um produto com esse nome
	if(this.produtos.procurar(produto.getNome())!=null){
		throw new ProdutoJaCadastradoException();
	}
	//já se o retorno for nulo, o produto pode ser cadastrado com sucesso
	else{
		if(produtos.getIndice()<produtos.getTamanho()){
		this.produtos.cadastrar(produto);
		}
		else{
			RepositorioProdutosArray auxiliar= (RepositorioProdutosArray) produtos;
			produtos= new RepositorioProdutosArray(auxiliar.getTamanho()+10);
			for (int i=0; i<auxiliar.getTamanho(); i++){
				produtos.cadastrar(auxiliar.getProduto(i));
			}
			produtos.cadastrar(produto);
		}
	}
}
public Produto procurarProduto(String nome){
	//apenas chama o metodo procurar do Repositorio
	return produtos.procurar(nome);
}
public void removerProduto(String nome) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	//se o produto nao for nulo, quer dizer que o produto pode ser removido
	if(produto!=null){
	boolean removido=produtos.remover(produto);
	//uma outra camada de teste pra evitar
	if(!removido){
		throw new ProdutoNaoCadastradoException();
	}
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	//se o produto nao for nulo e o equals confirmar, irá ser feito a atualizacao
	if (produto!=null&&produto.getNome().equals(nome)){
		produtos.atualizarPreco(produto, preco);
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException{
	Produto produto=produtos.procurar(nome);
	//se o produto nao for nulo e o equals confirmar, irá ser feito a atualizacao
	if (produto!=null&&produto.getNome().equals(nome)){
		produtos.renovarEstoque(produto, quantidade);
	}
	else{
		throw new ProdutoNaoCadastradoException();
	}
}
public String informacoesProduto(Produto produto){
	//apenas chama o metodo toString
	return produto.toString();
}
public String visualizarEstoque(){
	//apenas chama o metodo visualizarEstoque
	return produtos.visualizarEstoque("");
}
}
