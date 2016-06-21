package dados;
import classesBasicas.QuartoAbstrato;

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
	public void remover(String numero) {
		int i = getIndice(numero);
		indice = indice - 1;
		quartos[i] = quartos[indice];
		quartos[indice] = null;
	}

	@Override
	public QuartoAbstrato procurar(String numero){
		int i = getIndice(numero);
		return quartos[i];
	}

	@Override
	public void atualizar(QuartoAbstrato quarto) {
		String numero = quarto.getNumero();
		int i = getIndice(numero);
		quartos[i] = quarto;
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
	@Override
	public double getGastosCliente(String cpfCliente) {
		double total = 0;
		for (int i = 0; i < this.indice; i++) {
			if (quartos[i].getHospede() != null) {
				if (quartos[i].getHospede().getCPF().equals(cpfCliente)) {
					total += quartos[i].getTotal();
				}				
			}
		}
		return total;
	}

}
