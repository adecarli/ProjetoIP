package ui;
import java.util.Scanner;
import java.io.*;
import exceptions.*;
import negocio.*;
import dados.*;
public class Programa {

	public static void main(String[] args) {
		try{
			Hotel hotel;
			Scanner in = new Scanner (new File("teste.txt"));
			String tiporep = in.nextLine();
			if (tiporep.equals("array")){
				System.out.println("Metodo de Armazenamento: Array");
				hotel=new Hotel(new RepositorioQuartosArray(),new RepositorioProdutosArray (), new RepositorioClientesArray(), new RepositorioFuncionariosArray());
			} else if(tiporep.equals("lista")){
				System.out.println("Metodo de Armazenamento: Lista");
				hotel=new Hotel(new RepositorioQuartosLista(),new RepositorioProdutosLista(), new RepositorioClientesLista(), new RepositorioFuncionariosLista());
			} else{
				in.close();
				throw new TipoRepositorioInvalidoException();
			}
			
			//Cadastrando 2 quartos standard e 3 de luxo
			try {
				hotel.cadastrarQuarto("1A", 15, "Standard");
				System.out.println(">Quarto cadastrado");
				hotel.cadastrarQuarto("1E", 25, "Standard");
				System.out.println(">Quarto cadastrado");
				hotel.cadastrarQuarto("2e", 40, "Luxo");
				System.out.println(">Quarto cadastrado");
				hotel.cadastrarQuarto("2B", 40, "Luxo");
				System.out.println(">Quarto cadastrado");
				hotel.cadastrarQuarto("2A", 80, "Luxo");
				System.out.println(">Quarto cadastrado");
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch(ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Criando dois clientes
			try {
				hotel.cadastrarCliente("Andre", "086");
				System.out.println(">Cliente cadastrado");
				hotel.cadastrarCliente("Luisa", "083");
				System.out.println(">Cliente cadastrado");
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			//Listando os quartos cadastrados
			System.out.println(hotel.listarQuartos());
			//Listando os clientes cadastrados
			System.out.println(hotel.listarClientes());
			//Atualizando preco de um quarto
			try {
				hotel.atualizarQuarto("2e", 100, "Luxo");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Listar Quartos
			System.out.println(hotel.listarQuartos());
			//Atualizando tipo de um quarto
			try {
				hotel.atualizarQuarto("2e", 100, "Standard");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Listando Quartos
			System.out.println(hotel.listarQuartos());
			//EXCECOES DE cadastrarQuarto -----
			//Tentando cadastrar um quarto já existente
			try {
				hotel.cadastrarQuarto("1A", 50.0, "Luxo");
				System.out.println(">Quarto cadastrado");
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
				System.out.println("Quarto: " + e.getNumero() + " já existe");
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Tentando cadastrar um quarto com o valor da diaria invalido
			try {
				hotel.cadastrarQuarto("3A", -3, "Luxo");
				System.out.println(">Quarto cadastrado");
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			}
			//Tentando cadastrar um quarto com o tipo invalido
			try {
				hotel.cadastrarQuarto("3A", 50, "Top");
				System.out.println(">Quarto cadastrado");
			} catch (ValorDiariaInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (TipoQuartoInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
			//Removendo um quarto
			try {
				hotel.removerQuarto("2e");
				System.out.println(">Quarto removido");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Listando os quartos
			System.out.println(hotel.listarQuartos());
			//EXCECOES DE removerQuarto ----
			//Tentando remover um quarto inexistente
			try {
				hotel.removerQuarto("2E");
				System.out.println(">Quarto removido");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			
			//Adicionando uma cama extra num quarto
			try {
				hotel.adicionarCama("2A");
				System.out.println(">Cama adicionada");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}
			//Listando os quartos
			System.out.println(hotel.listarQuartos());
			//EXCECOES DE adicionarCama
			//Adicionando uma cama extra num quarto inexistente
			try {
				hotel.adicionarCama("1z");
				System.out.println(">Cama cadastrado");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}
			//Adicionando uma cama extra num quarto invalido
			try {
				hotel.adicionarCama("1A");
				System.out.println(">Cama cadastrado");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}
			//Adicionando mais de uma cama extra
			try {
				hotel.adicionarCama("2A");
				System.out.println(">Cama adicionada");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}

			
			//Removendo uma cama extra
			try {
				hotel.removerCama("2A");
				System.out.println(">Cama removida");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			//Listando Quartos
			System.out.println(hotel.listarQuartos());
			//EXCECOES DE removerCama
			//Removendo uma cama extra inexistente
			try {
				hotel.removerCama("2B");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			//Removendo uma cama extra de quarto inexistente
			try {
				hotel.removerCama("1z");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			//Removendo uma cama extra de quarto invalido
			try {
				hotel.removerCama("1A");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			
			//Cliente fazendo checkin
			try {
				hotel.checkin("1A", "086", 5);
				hotel.checkin("2A", "086", 3);
				System.out.println(">Checkin feito com sucesso");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Listando quartos
			System.out.println(hotel.listarQuartos());
			//Tentando remover quarto ocupado
			try {
				hotel.removerQuarto("1A");
				System.out.println(">Quarto removido");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Tentando adicionar cama em quarto ocupado
			try {
				hotel.adicionarCama("2A");
				System.out.println(">Cama adicionada");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			}
			//Adicionando cama e fazendo checkin
			try {
				hotel.adicionarCama("2B");
				hotel.checkin("2B", "083", 2);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraPresenteException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}
			//Listando Quartos
			System.out.println(hotel.listarQuartos());
			//Removendo cama de quarto ocupado
			try {
				hotel.removerCama("2B");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (CamaExtraAusenteException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			} catch (AdicionarCamaException e) {
				System.out.println(e.getMessage());
			}
			//Fazendo checkout
			try {
				hotel.checkoutQuarto("2B");
				System.out.println(">Checkout feito com sucesso");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			}
			//Listando Clientes
			System.out.println(hotel.listarClientes());
			//Fazendo checkout de quarto vazio
			try {
				hotel.checkoutQuarto("2B");
				System.out.println(">Checkout feito com sucesso");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			}
			//Fazendo checkout de quarto invalido
			try {
				hotel.checkoutQuarto("5b");
				System.out.println(">Checkout feito com sucesso");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			}
			//Listando quartos
			System.out.println(hotel.listarQuartos());
			//Fazendo checkin em quarto ocupado
			try {
				hotel.checkin("1A", "083", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Cliente invalido fazendo checkin
			try {
				hotel.checkin("1E", "12345", 3);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());;
			} catch (QuartoOcupadoException e) {
				System.out.println(e.getMessage());
			}
			//Cadastrando Funcionario
			try {
				hotel.cadastrarFuncionario("Laricia", "666", "camareira", 1000);
			} catch (FuncionarioJaCadastradoException e) {
				System.out.println(e.getMessage());
			}
			//Listando funcionarios
			System.out.println(hotel.listarFuncionarios());
			//Requisitando limpeza de quarto
			try {
				hotel.limparQuarto("1A", "666", 5);
				System.out.println(">Limpeza Efetuada");
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Listando quartos
			System.out.println(hotel.listarQuartos());
			//Requisitando limpeza de quarto a funcionario invalido
			try {
				hotel.limparQuarto("2A", "669", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Requisitando limpeza de quarto limpo
			try {
				hotel.limparQuarto("1A", "666", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Requisitando limpeza de quarto vazio
			try {
				hotel.limparQuarto("1E", "666", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Requisitando limpeza de quarto invalido
			try {
				hotel.limparQuarto("1z", "666", 5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Requisitando limpeza com gorjeta negativa
			try {
				hotel.limparQuarto("2A", "666", -5);
			} catch (QuartoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuartoVazioException e) {
				System.out.println(e.getMessage());
			} catch (QuartoLimpoException e) {
				System.out.println(e.getMessage());
			} catch (GorjetaInvalidaException e) {
				System.out.println(e.getMessage());
			}
			//Listando funcionarios
			System.out.println(hotel.listarFuncionarios());
			//Listando quartos
			System.out.println(hotel.listarQuartos());
		
		
			in.close();
		}catch(TipoRepositorioInvalidoException e){
			System.out.println(e.getMessage());
		} catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}

