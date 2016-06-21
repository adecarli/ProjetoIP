package dados;

import classesBasicas.Cliente;
import exceptions.*;

public interface RepositorioClientes {

	public void inserirCliente(Cliente cliente);
	public void removerCliente(String CPF);
	public void atualizarCliente(Cliente cliente);
	public Cliente procurarCliente(String CPF);
	public boolean existeCliente(String CPF);
	public void zerarGastosCliente(String CPF);
	public void adicionarGastosCliente(String CPF, double gasto);
	
}