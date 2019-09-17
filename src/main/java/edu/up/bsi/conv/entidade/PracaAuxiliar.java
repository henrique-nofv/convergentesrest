package edu.up.bsi.conv.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="PracaAuxiliar")
//@NamedQuery(name = "ListarAuxiliar", query = "SELECT p FROM Categoria WHERE p.praca = :c1 AND p.nome = :c2")
public class PracaAuxiliar {
	@SequenceGenerator(name = "ID", sequenceName = "ID", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
	@javax.persistence.Id
	private Long Id;
	private int idCategoria;
	private String tipoVeiculo;
	private int nroEixos;
	private String Rodagem;
	private double MultTarifa;
	
	public PracaAuxiliar() {
	}
	
	public PracaAuxiliar(int idCategoria, String tipoVeiculo, int nroEixos, String rodagem, double multTarifa,
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
