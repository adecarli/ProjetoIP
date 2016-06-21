package classesbasicas;

public class Produto {

	private String nome;
	private double preco;
	private int estoque;
	private int indice;

	public Produto(String nome, double preco, int estoque) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return this.estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public int getIndice() {
		return this.indice;
	}

	public void setEstoque(int indice) {
		this.indice = indice;
	}
	
	public String toString(){
		return "Produto: "+this.nome+" Preco: R$"+this.preco+" Quantidade: "+this.estoque+"/n";
	}
}