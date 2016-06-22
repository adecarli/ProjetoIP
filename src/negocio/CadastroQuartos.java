package negocio;
import classesBasicas.*;
import dados.RepositorioQuartos;
import exceptions.*;

public class CadastroQuartos {
	private RepositorioQuartos rep;
	
	public CadastroQuartos(RepositorioQuartos rep) {
		this.rep = rep;
	}
	public void cadastrar(QuartoAbstrato quarto) throws QuartoJaCadastradoException {
		if (!rep.existe(quarto.getNumero())) {
			rep.inserir(quarto);
		} else {
			throw new QuartoJaCadastradoException(quarto.getNumero());
		}
	}
	public void remover(String numero) throws QuartoNaoEncontradoException {
		if (rep.existe(numero)) {
			rep.remover(numero);			
		} else {
			throw new QuartoNaoEncontradoException();
		}
	}
	public QuartoAbstrato procurar(String numero) throws QuartoNaoEncontradoException {
		if (rep.existe(numero)) {
			return rep.procurar(numero);
		} else {
			throw new QuartoNaoEncontradoException();
		}
	}
	public void atualizar(QuartoAbstrato quarto) throws QuartoNaoEncontradoException {
		if (rep.existe(quarto.getNumero())) {
			rep.atualizar(quarto);			
		} else {
			throw new QuartoNaoEncontradoException();
		}
	}
	public double gastosCliente(String cpf) {
		return rep.getGastosCliente(cpf);
	}
	public double checkoutCliente(String cpf) {
		return rep.checkoutCliente(cpf);
	}
	public String toString() {
		return rep.toString();
	}
}
