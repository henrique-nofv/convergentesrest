package br.edu.up.conv.cancela.tarifa.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.edu.up.conv.cancela.tarifa.Tarifa;

public class TarifaLocal implements Tarifa {
	private static Client client;
	private static String URI_PEDAGIO = "http://localhost:8080/jwt/rest/categorias/";
	
	@Override
	
	public Double buscarTarifa(String tipoPraca, String categoria) {
		// TODO Auto-generated method stub
		System.out.println("antes tipoPraca: " + tipoPraca.trim().toLowerCase());
		System.out.println("antes categoria: " + categoria);
		int tipoPracaParaEnviar = 0;
		int categoriaParaEnviar = Integer.parseInt(categoria.split("C")[1]);
		if(tipoPraca.trim().toLowerCase().equals("principal")) {
			tipoPracaParaEnviar = 1;
		}
		else {
			tipoPracaParaEnviar = 2;
		}
		System.out.println("tipoPraca: " + tipoPracaParaEnviar);
		System.out.println("categoria: " + categoriaParaEnviar);
		client = ClientBuilder.newClient();
		Response response = client.target(URI_PEDAGIO + "buscarpreco")
				.queryParam("idPraca", tipoPracaParaEnviar)
				.queryParam("idCategoria", categoriaParaEnviar)
				.request(MediaType.APPLICATION_JSON).get();
		Double valor = 0.0;
		System.out.println(response);
		if (Status.OK.getStatusCode() == response.getStatus()) {
			System.out.println("Valor encontrado!");
			valor = response.readEntity(Double.class);
			System.out.println(valor);
		} else {
			throw new RuntimeException("Erro - Categoria não cadastrada");
		}
		return valor;
	}

}
