package dados;

import classesBasicas.QuartoAbstrato;

public class RepositorioQuartosArray implements RepositorioQuartos {
	private QuartoAbstrato[] quartos;
	private int indice;
	private static final int size = 10;
	
	public RepositorioQuartosArray() {
		quartos = new QuartoAbstrato[size];
		indice = 0;
	}
	@Override
	//Método para inserir um quarto no repositório.
	//Se o array original já estiver cheio, crie um novo com o tamanho do original + constante
	//Após copiar todas as entradas do array antigo para o array novo, redirecione a variavel original para o array novo.
	//Em seguida, insira normalmente.
	public void inserir(QuartoAbstrato quarto)  {
		if (indice >= quartos.length) {
			QuartoAbstrato[] q = new QuartoAbstrato[quartos.length + size];
			for (int i = 0; i < indice; i++) {
				q[i] = quartos[i];
			}
			quartos = q;
		}
		quartos[indice] = quarto;
		indice++;
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
			if (quartos[i].getNumero().equals(numero)) {
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
	public double checkoutCliente(String cpfCliente) {
		double total = 0;
		for (int i = 0; i < this.indice; i++) {
			if (quartos[i].getHospede() != null) {
				if (quartos[i].getHospede().getCPF().equals(cpfCliente)) {
					total += quartos[i].checkout();
				}				
			}
		}
		return total;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < indice; i++) {
			s += quartos[i].toString();
		}
		return s;
	}
}
