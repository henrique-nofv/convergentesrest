package edu.up.bsi.conv.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="PracaPrincipal")
@NamedQuery(name = "PracaPrincipal.Listar", query = "SELECT p FROM PracaPrincipal p WHERE p.idCategoria = :p1")
public class PracaPrincipal {
	@javax.persistence.Id
	@SequenceGenerator(name = "ID", sequenceName = "ID", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
	private Long Id;
	private int idCategoria;
	private String tipoVeiculo;
	private int nroEixos;
	private String Rodagem;
	private double MultTarifa;
	
	public PracaPrincipal() {
	}
	
	public PracaPrincipal(int idCategoria, String tipoVeiculo, int nroEixos, String rodagem, double multTarifa,
			double valoresPraticados) {
		super();
		this.idCategoria = idCategoria;
		this.tipoVeiculo = tipoVeiculo;
		this.nroEixos = nroEixos;
		Rodagem = rodagem;
		MultTarifa = multTarifa;
		ValoresPraticados = valoresPraticados;
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public int getNroEixos() {
		return nroEixos;
	}
	public void setNroEixos(int nroEixos) {
		this.nroEixos = nroEixos;
	}
	public String getRodagem() {
		return Rodagem;
	}
	public void setRodagem(String rodagem) {
		Rodagem = rodagem;
	}
	public double getMultTarifa() {
		return MultTarifa;
	}
	public void setMultTarifa(double multTarifa) {
		MultTarifa = multTarifa;
	}
	public double getValoresPraticados() {
		return ValoresPraticados;
	}
	public void setValoresPraticados(double valoresPraticados) {
		ValoresPraticados = valoresPraticados;
	}
	private double ValoresPraticados;
	
	

}
