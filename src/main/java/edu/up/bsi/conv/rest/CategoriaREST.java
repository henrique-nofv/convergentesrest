package edu.up.bsi.conv.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
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
	public Response buscarCategoriaPorId(@QueryParam(value = "idCategoria") int idCategoria,
			@QueryParam(value = "idPraca") int idPraca) throws Exception {

		if (idPraca == 0 || idCategoria == 0) {
			return Response.status(400).entity("Parametros inválidos!").build();
		} else if (idPraca == 1) {
			// PRACA PRINCIPAL
			PracaPrincipal praca = new PracaPrincipal();
			praca = dao.listarPorPrincipal(idCategoria);

			return Response.status(200).entity(praca).build();
		} else if (idPraca == 2) {
			// PRACA SECUNDARIA
		} else {
			return Response.status(400).entity("Não localizado!").build();
		}

		dao.listarPorPrincipal(idCategoria);
		return Response.accepted().entity(15.0).build();
	}

	// @POST
	// @Path(value = "buscar")
	// @Produces(MediaType.APPLICATION_XML)
	// @Consumes(MediaType.WILDCARD)
	// public Response buscarCategoriaPreco(@QueryParam(value = "praca") String
	// praca, @QueryParam(value = "categoria") String categoriaId) throws Exception
	// {
	// System.out.println("praca:" + praca);
	// System.out.println("categoriaId:" + categoriaId);
	// List<Categoria> categorias;
	// Double valor = 15d;
	// return Response.accepted().entity("15.0").build();
	// if(praca == "principal")
	// {
	// categorias = dao.listarPorPrincipal(categoriaId);
	// valor = categorias.get(0).getValor();
	// }
	// else {
	// categorias = dao.listarPorAuxiliar(categoriaId);
	// valor = categorias.get(0).getValor();
	// }
	// return Response.accepted().entity(valor).build();
	// }
	//
	// @POST
	// @Path(value = "buscaCategoria")
	// @Produces(MediaType.APPLICATION_XML)
	// @Consumes(MediaType.WILDCARD)
	// public Response buscarCategoria(@QueryParam(value = "praca") String praca,
	// @QueryParam(value = "categoria") String categoriaId) throws Exception {
	// System.out.println("praca:" + praca);
	// System.out.println("categoriaId:" + categoriaId);
	// List<Categoria> categorias;
	// if(praca == "principal")
	// {
	//// categorias = dao.listarPorPrincipal(categoriaId);
	// }
	// else {
	//// categorias = dao.listarPorAuxiliar(categoriaId);
	// }
	// return Response.accepted().entity(15.0).build();
	// }
	//
	//
	// @DELETE
	// @Path(value = "{id}")
	// @RolesAllowed(value = { "ADMIN" })
	// public Response removerCategoria(@PathParam(value = "id") Long codigo) {
	// try {
	// dao.removerCategoriaPorCodigo(codigo);
	// Mensagem mensagem = new Mensagem();
	// mensagem.setStatus(Status.ACCEPTED.toString());
	// mensagem.setDescricao("O produto com código " + codigo + " foi removido com
	// sucesso!");
	// return Response.accepted().entity(mensagem).build();
	// } catch (Exception e) {
	// Mensagem mensagem = new Mensagem();
	// mensagem.setStatus(Status.CONFLICT.toString());
	// mensagem.setDescricao("O produto com código " + codigo + " não pôde ser
	// removido!");
	// return Response.status(Status.CONFLICT).entity(mensagem).build();
	// }
	// }
	//
	// @PUT
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed(value = { "ADMIN", "USER" })
	// public Response atualizarCategoria(Categoria produto) {
	// try {
	// Categoria atualizado = dao.atualizarCategoria(produto);
	// UriBuilder baseUriBuilder = uriInfo.getBaseUriBuilder();
	// URI produtoAtualizado =
	// baseUriBuilder.path(CategoriaREST.class).path(atualizado.toPath()).build();
	// return Response.accepted(produtoAtualizado).entity(atualizado).build();
	// } catch (Exception e) {
	// Mensagem mensagem = new Mensagem();
	// mensagem.setStatus(Status.CONFLICT.toString());
	// mensagem.setDescricao("O produto " + produto.getNome() + " já está
	// cadastrado!");
	// return Response.status(Status.CONFLICT).entity(mensagem).build();
	// }
	// }

	// @GET
	// @Path(value = "{codigo}")
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed(value = { "ADMIN", "USER", "GUEST" })
	// public Response buscarCategoriaPorId(@PathParam(value = "codigo") Long
	// codigo) {
	// Categoria pesquisado = dao.buscarCategoriaPorCodigo(codigo);
	// if (pesquisado != null) {
	// UriBuilder baseUriBuilder = uriInfo.getBaseUriBuilder();
	// URI produtoPesquisado =
	// baseUriBuilder.path(CategoriaREST.class).path(pesquisado.toPath()).build();
	// return Response.created(produtoPesquisado).entity(pesquisado).build();
	// } else {
	// Mensagem mensagem = new Mensagem(Status.NOT_FOUND.toString(),
	// "O produto com código " + codigo + " não foi cadastrado!");
	// return Response.status(Status.NOT_FOUND).entity(mensagem).build();
	// }
	// }

	// @GET
	// @Path(value = "search")
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed(value = { "ADMIN", "USER", "GUEST" })
	// public Response buscarCategoriaPorNome(@QueryParam(value = "nome") String
	// nome) {
	// Categoria produto = dao.buscarCategoriaPorNome(nome);
	// if (produto != null) {
	// return Response.ok().entity(produto).build();
	// } else {
	// Mensagem mensagem = new Mensagem(Status.NOT_FOUND.toString(),
	// "O produto com o nome " + nome + " não foi cadastrado!");
	// return Response.status(Status.NOT_FOUND).entity(mensagem).build();
	// }
	// }

	// @GET
	// @Consumes(MediaType.WILDCARD)
	// @Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed(value = { "ADMIN", "USER", "GUEST" })
	// public Response listarTodos() {
	// try {
	//// Categorias produtos = new Categoria(dao.listarTodos());
	//// return Response.ok().entity(produtos).build();
	// } catch (Exception e) {
	// Mensagem mensagem = new Mensagem(Status.INTERNAL_SERVER_ERROR.toString(),
	// "Problemas técnicos no sistema!");
	// return
	// Response.status(Status.INTERNAL_SERVER_ERROR).entity(mensagem).build();
	// }
	// }

}
