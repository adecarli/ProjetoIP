package dados;
import classesbasicas.QuartoAbstrato;
import exceptions.*;

public interface RepositorioQuartos {
	void inserir(QuartoAbstrato quarto);
	void remover(String numero) throws QuartoNaoEncontradoException;
	QuartoAbstrato procurar(String numero) throws QuartoNaoEncontradoException;
	void atualizar(QuartoAbstrato quarto) throws QuartoNaoEncontradoException;
	boolean existe(String numero);

}
