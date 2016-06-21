package negocio;
import classesBasicas.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.*;

public class CadastroFuncionarios {
	private RepositorioFuncionarios repositorio;
	
	public CadastroFuncionarios(RepositorioFuncionarios repositorio){
		this.repositorio = repositorio;
	}
	
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if (!repositorio.existe(funcionario.getCPF())) {
			repositorio.inserir(funcionario);
		} else {
			throw new FuncionarioJaCadastradoException();
		}
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		if (repositorio.existe(funcionario.getCPF())) {
			repositorio.atualizar(funcionario);
		} else {
			throw new FuncionarioNaoEncontradoException();
		}
	}
	
	public void remover(String CPF) throws FuncionarioNaoEncontradoException{
		if (repositorio.existe(CPF)) {
			repositorio.remover(CPF);
		} else {
			throw new FuncionarioNaoEncontradoException();
		}
	}
	
	public Funcionario procurar(String CPF) throws FuncionarioNaoEncontradoException{
		if (repositorio.existe(CPF)) {
			return repositorio.procurar(CPF);
		} else {
			throw new FuncionarioNaoEncontradoException();
		}
		
	}

}
