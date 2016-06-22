package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dados.RepositorioClientesArray;
import dados.RepositorioClientesLista;
import dados.RepositorioFuncionariosArray;
import dados.RepositorioFuncionariosLista;
import dados.RepositorioProdutosArray;
import dados.RepositorioProdutosLista;
import dados.RepositorioQuartosArray;
import dados.RepositorioQuartosLista;
import exceptions.AdicionarCamaException;
import exceptions.CamaExtraAusenteException;
import exceptions.CamaExtraPresenteException;
import exceptions.ClienteJaCadastradoException;
import exceptions.ClienteNaoEncontradoException;
import exceptions.FuncionarioJaCadastradoException;
import exceptions.FuncionarioNaoEncontradoException;
import exceptions.GorjetaInvalidaException;
import exceptions.QuartoJaCadastradoException;
import exceptions.QuartoLimpoException;
import exceptions.QuartoNaoEncontradoException;
import exceptions.QuartoOcupadoException;
import exceptions.QuartoVazioException;
import exceptions.TipoQuartoInvalidoException;
import exceptions.TipoRepositorioInvalidoException;
import exceptions.ValorDiariaInvalidoException;
import negocio.Hotel;

public class ProgramaNaMoral {

	public static void main(String[] args) {
		try{
			Hotel hotel;
			Scanner input = new Scanner (new File("teste.txt"));
			
			String tiporep = input.nextLine();
			if (tiporep.equals("array")){
				System.out.println("Metodo de Armazenamento: Array");
				hotel=new Hotel(new RepositorioQuartosArray(),new RepositorioProdutosArray (), new RepositorioClientesArray(), new RepositorioFuncionariosArray());
			} else if(tiporep.equals("lista")){
				System.out.println("Metodo de Armazenamento: Lista");
				hotel=new Hotel(new RepositorioQuartosLista(),new RepositorioProdutosLista(), new RepositorioClientesLista(), new RepositorioFuncionariosLista());
			} else{
				input.close();
				throw new TipoRepositorioInvalidoException();
			}
			String numeroQuarto, tipo, cpfCliente, cpfFuncionario;
			double valor;
			int numero;
			boolean quit = false;
			Scanner in = new Scanner(System.in);
			while (!quit) {
				System.out.println("Menu principal");
				System.out.println("1. Quartos");
				System.out.println("2. Produtos");
				System.out.println("3. Clientes");
				System.out.println("4. Funcionarios");
				System.out.println("5. Sair");
				int op = Integer.parseInt(in.nextLine());
				switch (op) {
				case 1:
					boolean quit1 = false;
					while (!quit1) {
						System.out.println("Menu Quartos");
						System.out.println("1. Cadastrar Quarto");
						System.out.println("2. Remover Quarto");
						System.out.println("3. Atualizar Quarto");
						System.out.println("4. Adicionar Cama Extra");
						System.out.println("5. Remover Cama Extra");
						System.out.println("6. Fazer CheckIn");
						System.out.println("7. Fazer CheckOut");
						System.out.println("8. Solicitar Limpeza de Quarto");
						System.out.println("9. Listar Quartos");
						System.out.println("10. Voltar");
						int op1 = Integer.parseInt(in.nextLine());
						switch (op1) {
						case 1:
							System.out.print("Digite o numero do quarto: ");
							numeroQuarto = in.nextLine();
							System.out.print("Digite o valor da diaria: ");
							valor = Double.parseDouble(in.nextLine());
							System.out.print("Digite o tipo de quarto (Standard ou Luxo): ");
							tipo = in.nextLine();
							try {
								hotel.cadastrarQuarto(numeroQuarto, valor, tipo);
								System.out.println("Quarto cadastrado com sucesso");
							} catch (ValorDiariaInvalidoException e) {
								System.out.println(e.getMessage());
							} catch (QuartoJaCadastradoException e) {
								System.out.println(e.getMessage());
							} catch (TipoQuartoInvalidoException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 2:
							System.out.print("Digite o numero do quarto: ");
							numeroQuarto = in.nextLine();
							try {
								hotel.removerQuarto(numeroQuarto);
							} catch (QuartoNaoEncontradoException e) {
								System.out.println(e.getMessage());
							} catch (QuartoOcupadoException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 3:
							System.out.print("Digite o numero do quarto: ");
							numeroQuarto = in.nextLine();
							System.out.print("Digite o valor da diaria: ");
							valor = Double.parseDouble(in.nextLine());
							System.out.print("Digite o tipo de quarto (Standard ou Luxo): ");
							tipo = in.nextLine();
							try {
								hotel.atualizarQuarto(numeroQuarto, valor, tipo);
							} catch (QuartoNaoEncontradoException e) {
								System.out.println(e.getMessage());
							} catch (TipoQuartoInvalidoException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 4:
							System.out.print("Digite o numero do quarto: ");
							numeroQuarto = in.nextLine();
							try {
								hotel.adicionarCama(numeroQuarto);
							} catch (QuartoNaoEncontradoException e) {
								System.out.println(e.getMessage());
							} catch (QuartoOcupadoException e) {
								System.out.println(e.getMessage());
							} catch (AdicionarCamaException e) {
								System.out.println(e.getMessage());
							} catch (CamaExtraPresenteException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 5:
							System.out.print("Digite o numero do quarto: ");
							numeroQuarto = in.nextLine();
							try {
								hotel.removerCama(numeroQuarto);
							} catch (QuartoNaoEncontradoException e) {
								System.out.println(e.getMessage());
							} catch (CamaExtraAusenteException e) {
								System.out.println(e.getMessage());
							} catch (QuartoOcupadoException e) {
								System.out.println(e.getMessage());
							} catch (AdicionarCamaException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 6:
							System.out.print("Digite o numero do quarto: ");
							numeroQuarto = in.nextLine();
							System.out.print("Digite o numero do cpf do cliente: ");
							cpfCliente = in.nextLine();
							System.out.print("Digite o numero de dias de estadia: ");
							numero = Integer.parseInt(in.nextLine());
							try {
								hotel.checkin(numeroQuarto, cpfCliente, numero);
							} catch (QuartoNaoEncontradoException e) {
								System.out.println(e.getMessage());
							} catch (ClienteNaoEncontradoException e) {
								System.out.println(e.getMessage());
							} catch (QuartoOcupadoException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 7:
							System.out.print("Digite o numero do quarto: ");
							numeroQuarto = in.nextLine();
							try {
								hotel.checkoutQuarto(numeroQuarto);
							} catch (QuartoNaoEncontradoException e) {
								System.out.println(e.getMessage());
							} catch (QuartoVazioException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 8:
							System.out.print("Digite o numero do quarto: ");
							numeroQuarto = in.nextLine();
							System.out.print("Digite o numero do cpf do funcionario: ");
							cpfFuncionario = in.nextLine();
							System.out.print("Digite o valor da gorjeta recebida pelo funcionario");
							valor = Double.parseDouble(in.nextLine());
							try {
								hotel.limparQuarto(numeroQuarto, cpfFuncionario, valor);
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
							break;
						case 9:
							System.out.println(hotel.listarQuartos());
							break;
						case 20:
						default:
							quit1 = true;
							break;
						}
					}
					break;
				case 2:
					boolean quit2 = false;
					while (!quit2) {
						System.out.println("Menu Produtos");
						System.out.println("1. Cadastrar Produto");
						System.out.println("2. Remover Produto");
						System.out.println("3. Atualizar Preco de Produto");
						System.out.println("4. Listar Produtos");
						System.out.println("5. Voltar");
						System.out.println("4. Remover Cama Extra");
						System.out.println("5. Fazer CheckIn");
						System.out.println("6. Fazer CheckOut");
						System.out.println("7. Solicitar Limpeza de Quarto");
						System.out.println("8. Listar Quartos");
						System.out.println("9. Voltar");
						int op2 = Integer.parseInt(in.nextLine());
						switch (op2) {
						
						}
					}
					break;
				case 5:
				default:
					quit = true;
					break;
				}
			}
			input.close();
			in.close();
		}catch(TipoRepositorioInvalidoException e){
			System.out.println(e.getMessage());
		} catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}

	}

}
