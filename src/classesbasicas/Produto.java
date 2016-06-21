package classesBasicas;

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

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public String toString(){
		return "Produto: "+this.nome+" Preco: R$"+this.preco+" Quantidade: "+this.estoque+"/n";
	}
	//-----Testes
			public static void main(String[] args) {
				Produto p = new Produto("Coca-Cola", 5.5, 100);
				System.out.println("Nome: "+ p.getNome());
				System.out.println("Preco: " + p.getPreco());
				System.out.println("Estoque: " + p.getEstoque());
			}
}