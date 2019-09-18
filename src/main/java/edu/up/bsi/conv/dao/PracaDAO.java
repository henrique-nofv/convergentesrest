package edu.up.bsi.conv.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.up.bsi.conv.entidade.PracaAuxiliar;
import edu.up.bsi.conv.entidade.PracaPrincipal;

@Stateless
public class PracaDAO {


	@PersistenceContext
	private EntityManager entityManager;

	public PracaDAO(){
		super();
	}
	
	public PracaAuxiliar cadastrarPracaAuxiliar(PracaAuxiliar praca) {
		entityManager.persist(praca);
		return praca;
	}
	
	public PracaPrincipal cadastrarPracaPrincipal(PracaPrincipal praca) {
		entityManager.persist(praca);
		return praca;
	}
	
	public PracaPrincipal listarPorPrincipal(int idCategoria) {
		return entityManager.createNamedQuery("PracaPrincipal.Listar", PracaPrincipal.class)
				.setParameter("p1", idCategoria).getSingleResult();
	}
	
}
