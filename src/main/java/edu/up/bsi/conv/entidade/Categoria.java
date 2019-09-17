package edu.up.bsi.conv.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="Categoria")
//@NamedQuery(name = "ListarPrincipal", query = "SELECT p FROM Categoria WHERE p.praca = :c1 AND p.nome = :c2")
//@NamedQuery(name = "ListarAuxiliar", query = "SELECT p FROM Categoria WHERE p.praca = :c1 AND p.nome = :c2")
public class Categoria {
	@Id
	@SequenceGenerator(name = "NUM_SEQ_CATEGORIA", sequenceName = "NUM_SEQ_CATEGORIA", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NUM_SEQ_CATEGORIA")
	private Long idCategoria;
	private Double valor;
	private String nome;
	private String praca;
	public Categoria() {
		super();
	}
	
	
	public Categoria(Double valor, String nome, String praca) {
		super();
		this.valor = valor;
		this.nome = nome;
		this.praca = praca;
	}


	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", valor=" + valor + ", nome=" + nome + "]";
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPraca() {
		return praca;
	}
	public void setPraca(String praca) {
		this.praca = praca;
	}

}
