/**
 * 
 */
package dados;
import classesBasicas.Funcionario;

/**
 * @author lmmc2
 *
 */
public interface RepositorioFuncionarios {
	
	public void inserir (Funcionario funcionario);
	public void atualizar (Funcionario funcionario);
	public void remover (String CPF);
	public Funcionario procurar (String CPF);
	public boolean existe (String CPF);
	
}
