package Relatorio;

public class ItemPedido {

	private Integer quantidade;
	private Double preco;
	private Produto product;
	
	public ItemPedido(Integer quantidade, Double preco, Produto product) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.product = product;
	}

	public double subTotal(){
		return quantidade * preco;
	}

	@Override
	public String toString() {
		
		return "\nProduto: " + product.getNome() + 
				"\nQuantidade: " + quantidade + 
				"\nSubtotal: "+ subTotal() + 
				"\nPreço: " + preco +"\n";
	}
	
	
}

