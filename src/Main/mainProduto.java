package Main;
import java.util.Scanner;
import java.io.*;
import exceptions.*;
import negocio.*;
import dados.*;
import classesBasicas.*;
public class mainProduto {

	public static void main(String[] args) {
		try{
		Hotel hotel;
		Scanner in = new Scanner (new File("teste.txt"));
		if (in.nextLine().equals("Array")){
			System.out.println("Metodo de Armazenamento: Array");
			hotel=new Hotel(new RepositorioQuartosArray(),new RepositorioProdutosArray (), new RepositorioClientesArray(), new RepositorioFuncionariosArray());
		}
		else{
			System.out.println("Metodo de Armazenamento: Lista");
			hotel=new Hotel(new RepositorioQuartosLista(),new RepositorioProdutosLista(), new RepositorioClientesLista(), new RepositorioFuncionariosLista());
		}
		//primeiro funcionario
		
		try{
			hotel.cadastrarFuncionario("Edivaldo", "1814514", "faxineiro", 900.00);
		}catch(FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		
		//tentando recadastrar o primeiro funcionario
		
		try{
			hotel.cadastrarFuncionario("Edivaldo", "1814514", "faxineiro", 900.00);
		}catch(FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		
		//segundo funcionario
		
		try{
			hotel.cadastrarFuncionario("Maria", "12345678900", "cozinheira", 900.00);
		}catch(FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		
		//terceiro funcionario
		
		try{
			hotel.cadastrarFuncionario("Vitor", "09876543211", "cozinheiro", 900.00);
		}catch(FuncionarioJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		
		//atualizando segundo funcionario
		
		try{
			hotel.atualizarFuncionario("Maria", "12345678900", "faxineira", 910.00);
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//atualizando funcionario nao existente
		
		try{
			hotel.atualizarFuncionario("Luan", "12345678908", "faxineiro", 910.00);
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//procurando funcionario existente
		
		try{
			Funcionario funcionario = hotel.procurarFuncionario("12345678900");
			System.out.println("Dados do funcionario: \n" + funcionario.toString());
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//procurando funcionario inexistente
		
		try{
			Funcionario funcionario = hotel.procurarFuncionario("123456789");
			System.out.println("Dados do funcionario: \n" + funcionario.toString());
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//removendo o terceiro funcionario
		
		try{
			hotel.removerFuncionario("09876543211");
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//tentando remover funcionario inexistente
		
		try{
			hotel.removerFuncionario("098765211");
		}catch(FuncionarioNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		
		//cadastrando com preco invalido o primeiro produto
		try{
			hotel.cadastrarProduto("Agua",0.00, 2);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//cadastrando com quantidade invalida o primeiro produto
		try{
			hotel.cadastrarProduto("Agua",1.00, -3);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//cadastrando o primeiro produto de forma correta
		try{
			hotel.cadastrarProduto("Agua",1.00, 2);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//tentando cadastrar o primeiro produto de novo
		try{
			hotel.cadastrarProduto("Agua",1.00, 2);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//removendo o primeiro e unico produto
		try{
			hotel.removerProduto("Agua");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//tentando remover um produto nao cadastrado
		try{
			hotel.removerProduto("Biscoito");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//Recadastrando o produto
		try{
			hotel.cadastrarProduto("Agua",1.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//Mais um produto
		try{
			hotel.cadastrarProduto("Sanduiche",7.00, 1);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//Cadastrando o primeiro quarto
		try{
			hotel.cadastrarQuarto("103", 500.50, "Luxo");
		}catch(QuartoJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//Cadastrando o primeiro cliente
		try{
			hotel.cadastrarCliente("Ines Brasil", "696694734");
		}catch(ClienteJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//Fazendo Check-in do quarto
		try{
			hotel.checkin("103", "696694734", 3);
		}catch(QuartoNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		//primeiro pedido
		try{
			hotel.fazerPedido("696694734", "Sanduiche", 2);
			System.out.println("pedido feito\n");
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}catch(EstoqueInsuficienteException e){
			System.out.println(e.getMessage());
		}
		//visualizacao do Estoque
			System.out.println(hotel.visualizarEstoque());

		//faltou comida, peca apenas um
				try{
					hotel.fazerPedido("696694734", "Sanduiche", 1);
					System.out.println("pedido feito\n");
				}catch(ClienteNaoEncontradoException e){
					System.out.println(e.getMessage());
				}catch(ProdutoNaoCadastradoException e){
					System.out.println(e.getMessage());
				}catch(EstoqueInsuficienteException e){
					System.out.println(e.getMessage());
				}
		//Cadastrando cliente
		try{
			hotel.cadastrarCliente("Andrea Mello", "8478");
		}catch(ClienteJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//chegou a colega de quarto de Ines
		try{
			hotel.checkin("103", "8478", 3);
		}catch(QuartoNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(QuartoOcupadoException e){
			System.out.println(e.getMessage());
		}
		//mas nao podem ficar no mesmo quarto
		try{
			hotel.cadastrarQuarto("201", 300, "Standard");
		}catch(QuartoJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		//ai que delicia, colegas de hotel
		try{
			hotel.checkin("201", "8478", 3);
		}catch(QuartoNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.fazerPedido("696694734", "Bolo de Morango (Fatia)", 1);
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}catch(EstoqueInsuficienteException e){
			System.out.println(e.getMessage());
		}
		//renovando estoque
		try{
			hotel.renovarEstoque("Sanduiche",20);
		}catch(ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//cadastrando mais produtos
		try{
			hotel.cadastrarProduto("Bolo de Morango (Fatia)",5.00, 12);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Bolo de Chocolate (Fatia)",6.00, 12);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Cerveja",5.00, 30);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Bolo de Morango (Fatia)",5.00, 12);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Coca-cola",3.00, -10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Coca-cola",3.00, 20);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//removendo coca-cola
		try{
			hotel.removerProduto("Coca-cola");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//cadastrando refrigerantes diversos
		try{
			hotel.cadastrarProduto("Refrigerante (diverso)",2.00, 60);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//atualizando o preco de um produto
		try{
			hotel.atualizarPreco("Refrigerante (diverso)", 3.00);
		}catch(ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.removerProduto("Refrigerante (diverso)");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Coca-cola",3.00, 20);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Fanta",3.00, 20);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Guarana",3.00, 20);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Sprite",3.00, 20);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Aquarius Fresh",4.00, 20);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Chicabom",5.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Frutare",4.00, 20);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Sorvete",3.00, 0);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Sorvete (1 bola)",3.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Misto",5.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("X-Burguer",8.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Batata-Frita (Pequena)",5.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Batata-Frita (Grande)",8.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Pirulito",0.25, 100);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Ice Kiss",0.10, 100);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Coco",6.00, 20);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarProduto("Café (pequeno)",1.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.removerProduto("Café (pequeno)");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.removerProduto("Ice Kiss");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		
		//visualizacao do Estoque
		System.out.println(hotel.visualizarEstoque());
		
		//Cadastrando cliente mais de uma vez repetido
		try{
			hotel.cadastrarCliente("Andrea Mello", "8478");
		}catch(ClienteJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.checkoutQuarto("201");
		}catch(QuartoNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch (QuartoVazioException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.checkoutCliente("8478");
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.cadastrarCliente("Jessikylaine", "1831");
		}catch(ClienteJaCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.checkin("201","1831", 2);
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(QuartoNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		//Jessikylaine é viciada em pirulitos
		try{
			hotel.fazerPedido("1831", "Pirulito", 100);
			System.out.println("pedido feito\n");
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}catch(ClienteNaoEncontradoException e){
			System.out.println(e.getMessage());
		}catch(ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			System.out.println(hotel.informacoesProduto("Pirulito"));;
		}catch(ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.renovarEstoque("Pirulito", 200);
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//visualizando estoque
		System.out.println(hotel.visualizarEstoque());
		//removendo mais alguns
		try{
			hotel.removerProduto("Bolo de Morango (Fatia)");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.removerProduto("Bolo de Morango (Fatia)");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//erro de digitacao
		try{
			hotel.removerProduto("Bolo de Chocolate(Fatia)");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//consertando o erro de digitacao
		try{
			hotel.removerProduto("Bolo de Chocolate (Fatia)");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		try{
			hotel.removerProduto("Agua");
		}catch (ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}
		//readicionando agua
		try{
			hotel.cadastrarProduto("Agua",1.00, 10);
		}catch(ProdutoJaCadastradoException e){
			System.out.println(e.getMessage());
		}catch(PrecoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//aumetando o estoque de agua
		try{
			hotel.renovarEstoque("Agua", 90);
		}catch(ProdutoNaoCadastradoException e){
			System.out.println(e.getMessage());
		}catch (QuantidadeInvalidaException e){
			System.out.println(e.getMessage());
		}
		//visualizando estoque
			System.out.println(hotel.visualizarEstoque());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
}
}
