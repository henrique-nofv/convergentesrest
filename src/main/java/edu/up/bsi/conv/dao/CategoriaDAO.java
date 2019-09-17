package edu.up.bsi.conv.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.up.bsi.conv.entidade.Categoria;

@Stateless
//@NamedQuery(name = "PracaPrincipal.Listar", query = "SELECT p FROM pracaprincipal WHERE p.idCategoria = :p1)
public class CategoriaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public CategoriaDAO() {
		super();
	}

	public Categoria cadastrarCategoria(Categoria categoria) {
		entityManager.persist(categoria);
		return categoria;
	}

	public List<Categoria> listarPorPrincipal(String categoria) {
		return entityManager.createNamedQuery("Categoria.ListarPrincipal", Categoria.class)
				.setParameter("c1", "1")
				.setParameter("c2", categoria)
				.getResultList();
	}

	public List<Categoria> listarPorAuxiliar(String categoria) {
		return entityManager.createNamedQuery("Categoria.ListarAuxiliar", Categoria.class)
				.setParameter("c1", "2")
				.setParameter("c2", categoria)
				.getResultList();
	}

	public List<Categoria> listarTodos() {
		return entityManager.createNamedQuery("Categoria.ListarTodos", Categoria.class).getResultList();
	}

//	public Double buscarPorPracaAuxiliar(String nomePraca, String categoria )
//	{
//
//		entityManager.createNamedQuery("Categoria.Listar", Categoria.class).setParameter("c1", categoria.getSingleResult());
//		return 10.0;
//	}
//
//	public Double buscarPorPracaPrincipal(String nomePraca, Integer catergoria )
//
//
//	return 10.0;
//	{
//
//	}
}
