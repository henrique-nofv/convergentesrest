package edu.up.bsi.conv.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	public double getCategoriaValorPorPrincipal(int idCategoria) {
		TypedQuery<PracaPrincipal> consulta = entityManager.createQuery("SELECT p FROM PracaPrincipal p WHERE p.idCategoria = :idCategoria", PracaPrincipal.class)
				.setParameter("idCategoria", idCategoria);
		try {
			PracaPrincipal praca = consulta.getSingleResult();
			return praca.getValoresPraticados();
		} catch (Exception e) {
			return -1.0;
		}
	}
	
	public double getCategoriaValorPorAuxiliar(int idCategoria) {
		TypedQuery<PracaAuxiliar> consulta = entityManager.createQuery("SELECT p FROM PracaAuxiliar p WHERE p.idCategoria = :idCategoria", PracaAuxiliar.class)
				.setParameter("idCategoria", idCategoria);
		try {
			PracaAuxiliar praca = consulta.getSingleResult();
			return praca.getValoresPraticados();
		} catch (Exception e) {
			return -1.0;
		}
	}
	
}
