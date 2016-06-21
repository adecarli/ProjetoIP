package dados;
import classesbasicas.QuartoAbstrato;
import exceptions.*;

public class RepositorioQuartosArray implements RepositorioQuartos {
	private QuartoAbstrato[] quartos;
	private int indice;
	
	public RepositorioQuartosArray(int maximo) {
		quartos = new QuartoAbstrato[maximo];
		indice = 0;
	}
	@Override
	public void inserir(QuartoAbstrato quarto)  {
		if (indice < quartos.length) {
			quartos[indice] = quarto;
			indice++;
		} else {
			;
		}
	}
	@Override
	public void remover(String numero) throws QuartoNaoEncontradoException {
		int i = getIndice(numero);
		if (i != indice) {
			indice = indice - 1;
			quartos[i] = quartos[indice];
			quartos[indice] = null;
		} else {
			throw new QuartoNaoEncontradoException();
		}
	}

	@Override
	public QuartoAbstrato procurar(String numero) throws QuartoNaoEncontradoException {
		int i = getIndice(numero);
		if (i != indice) {
			return quartos[i];
		} else {
			throw new QuartoNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(QuartoAbstrato quarto) throws QuartoNaoEncontradoException {
		String numero = quarto.getNumero();
		int i = getIndice(numero);
		if (i != indice) {
			quartos[i] = quarto;
		} else {
			throw new QuartoNaoEncontradoException();
		}

	}

	@Override
	public boolean existe(String numero) {
		int i = getIndice(numero);
		return (i != indice);
	}
	private int getIndice(String numero) {
		int i = 0;
		boolean achou = false;
		while (!achou && i < indice) {
			if (quartos[indice].getNumero().equals(numero)) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

}
