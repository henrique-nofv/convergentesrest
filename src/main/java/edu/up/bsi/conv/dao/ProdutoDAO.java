////package edu.up.bsi.conv.dao;
//
//import java.util.List;
//
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//
//import edu.up.bsi.conv.entidade.Produto;
//
///**
// * Classe para gerenciar as operações de persistência relacionadas com a
// * entidade {@link Produto}
// * 
// * @author Andre Pimenta
// *
// */
//@Stateless
//public class ProdutoDAO {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	public ProdutoDAO() {
//		// Construção padrão
//	}
//
//	public Produto cadastrarProduto(Produto produto) {
//		entityManager.persist(produto);
//		return produto;
//	}
//
//	public Produto buscarProdutoPorCodigo(Long codigo) {
//		return entityManager.find(Produto.class, codigo);
//	}
//
//	public Produto buscarProdutoPorNome(String nome) {
//		try {
//			return entityManager.createNamedQuery("Produto.ListarPorNome", Produto.class)
//					.setParameter("p1", nome.trim()).getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
//
//	public void removerProdutoPorCodigo(Long codigo) {
//		Produto produto = buscarProdutoPorCodigo(codigo);
//		if (produto != null) {
//			entityManager.remove(produto);
//		}
//	}
//
//	public Produto atualizarProduto(Produto produto) {
//		return entityManager.merge(produto);
//	}
//
//	public List<Produto> listarTodos() {
//		return entityManager.createNamedQuery("Produto.ListarTodos", Produto.class).getResultList();
//	}
//
//}
