package Relatorio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Relatorio.enums.StatusPedido;

public class Pedido {
	

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Integer id;
	private Date moment;
	private StatusPedido estado;
	private Cliente cliente;
	
	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	
	public Pedido() {
		
	}

	public Pedido(Date moment, StatusPedido estado, Cliente cliente) {
		this.moment = moment;
		this.estado = estado;
		this.cliente = cliente;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public StatusPedido getEstado() {
		return estado;
	}

	public void setEstado(StatusPedido estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addPedido(ItemPedido ip) {
		itensPedido.add(ip);
	}
	
	public void removePedido(ItemPedido ip) {
		itensPedido.remove(ip);
	}
	
	public void apresenta() {
		for(ItemPedido itensP: itensPedido ) {
			System.out.println(itensP);
		}
	}

	public double valorTotal() {
		
		double soma = 0;
		for(ItemPedido itemP: itensPedido) {
			soma += itemP.subTotal();
		}
		
		return soma;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(moment)+ "\n");
		sb.append("Estado do pedido: ");
		sb.append(estado +"\n");
		sb.append("Cliente: ");
		sb.append(cliente +"\n");
		sb.append("\nItens do pedido:\n");
		for(ItemPedido itensPedido : itensPedido) {
			sb.append(itensPedido + "\n" );	
		}
		sb.append("Valor total: ");
		sb.append(String.format("%.2f", valorTotal()));
		return sb.toString();	
	}
	
}


