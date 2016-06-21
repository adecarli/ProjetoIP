package dados;
import classesBasicas.QuartoAbstrato;

public interface RepositorioQuartos {
	void inserir(QuartoAbstrato quarto);
	void remover(String numero);
	QuartoAbstrato procurar(String numero);
	void atualizar(QuartoAbstrato quarto);
	boolean existe(String numero);
	double getGastosCliente(String cpfCliente);

}
