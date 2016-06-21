package dados;
import classesbasicas.QuartoAbstrato;
import exceptions.*;

public class RepositorioQuartosLista implements RepositorioQuartos {
	private QuartoAbstrato quarto;
	private RepositorioQuartosLista proximo;
	
	public RepositorioQuartosLista() {
		this.quarto = null;
		this.proximo = null;
	}
	public QuartoAbstrato getQuarto() {
		return quarto;
	}
	public void setQuarto(QuartoAbstrato quarto) {
		this.quarto = quarto;
	}
	public RepositorioQuartosLista getProximo() {
		return proximo;
	}
	public void setProximo(RepositorioQuartosLista proximo) {
		this.proximo = proximo;
	}

	@Override
	public void inserir(QuartoAbstrato quarto) {
		if (this.proximo == null) {
			this.quarto = quarto;
			this.proximo = new RepositorioQuartosLista();
		} else {
			this.proximo.inserir(quarto);
		}

	}
	@Override
	public void remover(String numero) throws QuartoNaoEncontradoException {
		if (this.quarto != null) {
			if (this.quarto.getNumero().equals(numero)) {
				this.quarto = this.proximo.quarto;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(numero);
			}
		} else {
			throw new QuartoNaoEncontradoException();
		}

	}

	@Override
	public QuartoAbstrato procurar(String numero) throws QuartoNaoEncontradoException {
		if (this.quarto != null) {
			QuartoAbstrato retorno;
			if (this.quarto.getNumero().equals(numero)) {
				retorno = this.quarto;
			} else {
				retorno = this.proximo.procurar(numero);
			}
			return retorno;
		} else {
			throw new QuartoNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(QuartoAbstrato quarto) throws QuartoNaoEncontradoException {
		String numero = quarto.getNumero();
		if (this.quarto != null) {
			if (this.quarto.getNumero().equals(numero)) {
				this.quarto = quarto;
			} else {
				this.proximo.atualizar(quarto);
			}
		} else {
			throw new QuartoNaoEncontradoException();
		}

	}

	@Override
	public boolean existe(String numero) {
		boolean retorno;
		if (this.quarto != null) {
			if (this.quarto.getNumero().equals(numero)) {
				retorno = true;
			} else {
				retorno = this.proximo.existe(numero);
			}
		} else {
			retorno = false;			
		}
		return retorno;
	}

}
