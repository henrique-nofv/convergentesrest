package edu.up.bsi.conv.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Veiculo {
	@Id
	@SequenceGenerator(name = "NUM_VEICULO", sequenceName = "NUM_VEICULO", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NUM_VEICULO")
	Long Id;
	Integer numeroEixos;
	String tipo;
	Integer rodas;
	Integer categoriaId;

}
