package Relatorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Relatorio.enums.StatusPedido;

public class Principal {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Entre com os dados do cliente: ");
		System.out.print("Name: ");
		String nome = ler.nextLine();
		System.out.print("Email:");
		String email = ler.next();
		System.out.print("Data de aniversário (DD/MM/YYYY): ");
		Date dataNiver = sdf.parse(ler.next());

		Cliente cliente = new Cliente(nome, email, dataNiver);
		
		System.out.println();
		System.out.println("Entre com os dados do pedido: ");
		System.out.print("Status: ");
		ler.nextLine();
		String status = ler.nextLine();
		String s = status.toUpperCase();
		
		//Converte a String para o valor correspondido do status no enum
		//(A palavra deve ser digitada do jeito que está no enum)
		StatusPedido sp = StatusPedido.valueOf(s);
		System.out.print("Quantos itens tem o pedido? ");
		int n = ler.nextInt();
		
		System.out.println();
		
		Pedido pedido = new Pedido(new Date(), sp, cliente);
		
		for(int i = 1; i<= n; i++) {
			System.out.println("Entre com os dados do "+ i +"° pedido!");
			System.out.print("Nome do produto: ");
			ler.nextLine();
			String nomeProduto = ler.nextLine();
			System.out.print("Preço do produto: ");
			double precoProduto = ler.nextDouble();
			System.out.print("Quantidade: ");
			int qtd = ler.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			ItemPedido itemPedido = new ItemPedido(qtd, precoProduto, produto);
			
			pedido.addPedido(itemPedido);
			System.out.println();
		}
		
		System.out.println();
		System.out.println(pedido);
		
	}

}
