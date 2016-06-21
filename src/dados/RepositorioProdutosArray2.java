package dados;

import classesbasicas.Produto;
import exceptions.*;

public class RepositorioProdutosArray implements RepositorioProdutos {
	private Produto[] arrayDeProdutos;
	private int indice;
	private int tamanho;

	public RepositorioProdutosArray() {
		this.arrayDeProdutos = new Produto[1];
		tamanho = arrayDeProdutos.length;
		this.indice = 0;
	}

	@Override
	public void cadastrar(Produto produto) throws ProdutoJaCadastradoException {
		for (int i = 0; i <= tamanho; i++) {
			// quando a inserção vai estourar o tamanho do repositório, o
			// programa cria um auxiliar para salvar os produtos anteriores e
			// salvar em um array novo com tamanho maior
			if (i == tamanho) {
				Produto[] auxiliar = arrayDeProdutos;
				this.arrayDeProdutos = new Produto[tamanho + 1];
				for (int k = 0; k < tamanho; k++) {
					arrayDeProdutos[k] = auxiliar[k];
				}
				this.tamanho = arrayDeProdutos.length;
				this.arrayDeProdutos[tamanho - 1] = produto;
				indice++;
				// sair
				i = tamanho + 1;
			}
			// não alterar a ordem por favor
			else if (arrayDeProdutos[i] == null) {
				arrayDeProdutos[i] = produto;
				indice++;
				// sair
				i = tamanho + 1;
			}
			// se achar um produto com o nome igual
			else if (arrayDeProdutos[i].getNome() == produto.getNome()) {
				throw new ProdutoJaCadastradoException();
			}
			// se houver um espaço nulo no array
		}
	}

	@Override
	public void remover(String nome) throws ProdutoNaoCadastradoException {
		for (int i = 0; i <= tamanho; i++) {
			if (i == tamanho) {
				throw new ProdutoNaoCadastradoException();
			}
			// para remover ele salva o ultimo array
			else if (arrayDeProdutos[i].getNome() == nome) {
				this.arrayDeProdutos[i] = this.arrayDeProdutos[indice];
				this.arrayDeProdutos[indice] = null;
				this.indice--;
			}
		}
	}

	@Override
	public Produto procurar(String nome) throws ProdutoNaoCadastradoException {
		for (int i = 0; i <= tamanho; i++) {
			if (i == tamanho) {
				throw new ProdutoNaoCadastradoException();
			} else if (arrayDeProdutos[i].getNome() == nome) {
				return arrayDeProdutos[i];
			}
		}
		return null;
	}

	@Override
	public void atualizarPreco(String nome, double preco) throws ProdutoNaoCadastradoException {
		for (int i = 0; i <= tamanho; i++) {
			if (i == tamanho) {
				throw new ProdutoNaoCadastradoException();
			} else if (arrayDeProdutos[i].getNome() == nome) {
				arrayDeProdutos[i].setPreco(preco);
				;
			}
		}
	}

	@Override
	public void renovarEstoque(String nome, int quantidade) throws ProdutoNaoCadastradoException {
		for (int i = 0; i <= tamanho; i++) {
			if (i == tamanho) {
				throw new ProdutoNaoCadastradoException();
			} else if (arrayDeProdutos[i].getNome() == nome) {
				quantidade = quantidade + arrayDeProdutos[i].getEstoque();
				arrayDeProdutos[i].setEstoque(quantidade);
				;
			}
		}
	}
}
