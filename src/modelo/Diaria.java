package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Diaria
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public class Diaria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private Date data;
	private Collection<PessoaFisica> hospedes;
	private Quarto quarto;

	public Diaria() {
		super();
	} 
	
	@Id
	@GeneratedValue(generator="gendiaria")
	@SequenceGenerator(sequenceName	="diaria_codigo_seq",name="gendiaria")	
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}   
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@ManyToMany
	@JoinTable(name="hospedagem",
				joinColumns=@JoinColumn(name="cod_diaria"),
				inverseJoinColumns=@JoinColumn(name="cod_pessoa"))
	public Collection<PessoaFisica> getHospedes() {
		return hospedes;
	}

	public void setHospedes(Collection<PessoaFisica> hospedes) {
		this.hospedes = hospedes;
	}

	@ManyToOne 
	@JoinColumn(name="cod_quarto")
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}
