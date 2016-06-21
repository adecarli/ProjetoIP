package dados;

import classesBasicas.QuartoAbstrato;

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
	public void remover(String numero){
		if (this.quarto.getNumero().equals(numero)) {
			this.quarto = this.proximo.quarto;
			this.proximo = this.proximo.proximo;
		} else {
			this.proximo.remover(numero);
		}
	}

	@Override
	public QuartoAbstrato procurar(String numero) {
		QuartoAbstrato retorno;
		if (this.quarto.getNumero().equals(numero)) {
			retorno = this.quarto;
		} else {
			retorno = this.proximo.procurar(numero);
		}
		return retorno;
	}

	@Override
	public void atualizar(QuartoAbstrato quarto) {
		String numero = quarto.getNumero();
		if (this.quarto.getNumero().equals(numero)) {
			this.quarto = quarto;
		} else {
			this.proximo.atualizar(quarto);
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
	@Override
	public double getGastosCliente(String cpfCliente) {
		double total = 0;
		if (this.proximo != null) {
			if (this.quarto.getHospede() != null) {
				if (this.quarto.getHospede().getCPF().equals(cpfCliente)) {
					total += this.quarto.getTotal();
				}
			}
			this.proximo.getGastosCliente(cpfCliente);
			
		}
		return total;
	}
	public String toString() {
		String s = "";
		if (this.proximo != null) {
			s += this.quarto.toString();
			s += this.proximo.toString();
		}
		return s;
	}
}
