//package edu.up.bsi.conv.soap;
//
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.jws.WebParam;
//import javax.jws.WebResult;
//import javax.jws.WebService;
//
//import edu.up.bsi.conv.dao.ProdutoDAO;
//import edu.up.bsi.conv.entidade.Produto;
// rest
//
///**
// * Exposição via SOAP das funções do {@link Produto}.
// * 
// * @author Andre Pimenta
// *
// */
//@WebService(name = "produtoSoap")
//public class ProdutoSOAP {
//
//	@Inject
//	private ProdutoDAO dao;
//
//	@WebResult(name = "produto")
//	public Produto cadastrarProduto(@WebParam(name = "nome") String nome,
//			@WebParam(name = "quantidade") Long quantidade) throws Exception {
//		Produto existente = dao.buscarProdutoPorNome(nome);
//		if (existente == null) {
//			return dao.cadastrarProduto(new Produto(nome, quantidade));
//		} else {
//			throw new Exception("Produto já cadastrado: " + nome + ".");
//		}
//	}
//
//	@WebResult(name = "produto")
//	public Produto buscarProdutoPorNome(@WebParam(name = "nome") String nome) {
//		return dao.buscarProdutoPorNome(nome);
//	}
//
//	@WebResult(name = "produto")
//	public List<Produto> listarTodos() {
//		return dao.listarTodos();
//	}
//
//	public void removerProduto(@WebParam(name = "codigo") Long codigo) {
//		dao.removerProdutoPorCodigo(codigo);
//	}
//
//	@WebResult(name = "produto")
//	public Produto atualizarProduto(Produto produto) {
//		return dao.atualizarProduto(produto);
//	}
//
//}
