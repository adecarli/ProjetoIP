package negocio;
import classesbasicas.QuartoAbstrato;
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
			throw new QuartoJaCadastradoException();
		}
	}
	public void remover(String numero) throws QuartoNaoEncontradoException {
		rep.remover(numero);
	}
	public QuartoAbstrato procurar(String numero) throws QuartoNaoEncontradoException {
		return rep.procurar(numero);
	}
	public void atualizar(QuartoAbstrato quarto) throws QuartoNaoEncontradoException {
		rep.atualizar(quarto);
	}
}
