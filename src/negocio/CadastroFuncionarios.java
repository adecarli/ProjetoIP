package negocio;
import classesBasicas.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.*;

public class CadastroFuncionarios {
	private RepositorioFuncionarios repositorio;
	
	public CadastroFuncionarios(RepositorioFuncionarios repositorio){
		this.repositorio = repositorio;
	}
	
	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if (!repositorio.existe(funcionario.getCPF())) {
			repositorio.inserir(funcionario);
		} else {
			throw new FuncionarioJaCadastradoException();
		}
	}
	
	public void atualizarFuncionario(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		if (repositorio.existe(funcionario.getCPF())) {
			repositorio.atualizar(funcionario);
		} else {
			throw new FuncionarioNaoEncontradoException();
		}
	}
	
	public void removerFuncionario(String CPF) throws FuncionarioNaoEncontradoException{
		if (repositorio.existe(CPF)) {
			repositorio.remover(CPF);
		} else {
			throw new FuncionarioNaoEncontradoException();
		}
	}
	
	public Funcionario procurarFuncionario(String CPF) throws FuncionarioNaoEncontradoException{
		Funcionario retorno;
		if (repositorio.existe(CPF)) {
			retorno = repositorio.procurar(CPF);
		} else {
			throw new FuncionarioNaoEncontradoException();
		}
		return retorno;
	}

}
