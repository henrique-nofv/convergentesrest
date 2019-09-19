package edu.up.bsi.conv.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import edu.up.bsi.conv.dao.PracaDAO;
import edu.up.bsi.conv.entidade.PracaAuxiliar;
import edu.up.bsi.conv.entidade.PracaPrincipal;

@Path(value = "categorias")
public class CategoriaREST {

	@Inject
	private PracaDAO dao;

	@Context
	private UriInfo uriInfo;

	@POST
	@Path(value = "cadastrar")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response gravarTarifa(@QueryParam(value = "veiculo") String tipoVeiculo,
			@QueryParam(value = "eixos") int nroEixos, @QueryParam(value = "rodagem") String rodagem,
			@QueryParam(value = "tarifa") double MultTarifa, @QueryParam(value = "praca") int tipoPraca,
			@QueryParam(value = "valores") double ValoresPraticados, @QueryParam(value = "idCategoria") int idCategoria)
					throws Exception {

		if (tipoVeiculo == null || nroEixos == 0 || rodagem == null || MultTarifa == 0.0 || tipoPraca == 0
				|| idCategoria == 0) {
			return Response.status(400).entity("Parametros inválidos!").build();
		}

		// Se a praça for 1 então é a principal se for 2 então é a praça auxiliar

		// PRACA PRINCIPAL
		if (tipoPraca == 1) {
			PracaPrincipal praca = new PracaPrincipal();
			praca.setTipoVeiculo(tipoVeiculo);
			praca.setNroEixos(nroEixos);
			praca.setRodagem(rodagem);
			praca.setMultTarifa(MultTarifa);
			praca.setIdCategoria(idCategoria);
			praca.setValoresPraticados(ValoresPraticados);
			dao.cadastrarPracaPrincipal(praca);
			return Response.accepted(201).entity(praca).build();
		} else if (tipoPraca == 2) {
			PracaAuxiliar praca = new PracaAuxiliar();
			praca.setTipoVeiculo(tipoVeiculo);
			praca.setNroEixos(nroEixos);
			praca.setRodagem(rodagem);
			praca.setMultTarifa(MultTarifa);
			praca.setIdCategoria(idCategoria);
			praca.setValoresPraticados(ValoresPraticados);
			dao.cadastrarPracaAuxiliar(praca);
			return Response.accepted(201).entity(praca).build();
		} else {
			return Response.status(400).entity("Praça inválida!").build();
		}
	}

	@POST
	@Path(value = "buscarid")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCategoriaPorId(@QueryParam(value = "idCategoria") int idCategoria, @QueryParam(value = "idPraca") int idPraca) throws Exception {
		if (idPraca == 0 || idCategoria == 0) {
			return Response.status(400).entity("Parametros inválidos!").build();
		} else if (idPraca == 1) {
			// PRACA PRINCIPAL
			PracaPrincipal praca = dao.listarPorPrincipal(idCategoria);
			return Response.status(200).entity(praca).build();
		} else if (idPraca == 2) {
			// PRACA SECUNDARIA
		} else {
			return Response.status(400).entity("Não localizado!").build();
		}

		dao.listarPorPrincipal(idCategoria);
		return Response.accepted().entity(15.0).build();
	}

	@GET
	@Path(value = "buscarpreco")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPrecoPorCategoria(@QueryParam(value = "idCategoria") int idCategoria, @QueryParam(value = "idPraca") int idPraca) throws Exception {
		if (idPraca == 0 || idCategoria == 0 || (idPraca != 1 && idPraca != 2)) {
			return Response.status(400).entity("Parametros inválidos!").build();
		}
		Double preco;
		if (idPraca == 1) {
			// PRACA PRINCIPAL
			preco = dao.getCategoriaValorPorPrincipal(idCategoria);
		} else {
			// PRACA SECUNDARIA
			preco = dao.getCategoriaValorPorAuxiliar(idCategoria);	
		}
		if(preco == -1.0) {
			return Response.status(404).entity("Não localizado!").build();
		}
		return Response.status(200).entity(preco).build();
	}
}
