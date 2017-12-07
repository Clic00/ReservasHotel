package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Past;

import validadores.CPFValido;
import validadores.Requeridos;

/**
 * Entity implementation class for Entity: PessoaFisica
 *
 */
@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String rg;
	private Date dataNascimento;
	private Sexo sexo;
	private Collection<Diaria> diarias;
	
	
	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", diarias=" + diarias + "]";
		
		
	}
	public PessoaFisica() {	
		super();
	}   
	
	@CPFValido(groups=Requeridos.class)
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}   
	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}   
	
	@Temporal(TemporalType.DATE)
	@Past(message="Data incoerente!")
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	@ManyToMany(mappedBy="hospedes")
	public Collection<Diaria> getDiarias() {
		return diarias;
	}
	public void setDiarias(Collection<Diaria> diarias) {
		this.diarias = diarias;
	}
   
	@Enumerated(EnumType.STRING)
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	

}
