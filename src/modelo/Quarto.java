package modelo;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Quarto
 *
 */
@Entity
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int codigo;
	private String numero;
	private TipoDeQuarto tipo;
	private Collection<Diaria> diarias;
	
	
	@Override
	public String toString() {
		return "Quarto [numero=" + numero + ", tipo=" + tipo + "]";
	}
	
	public Quarto() {
		super();
	}   
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(generator="genquarto")
	@SequenceGenerator(name="genquarto",sequenceName="quarto_cod_seq")
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Enumerated(EnumType.STRING)
	public TipoDeQuarto getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeQuarto tipo) {
		this.tipo = tipo;
	}

	@OneToMany(mappedBy="quarto")
	public Collection<Diaria> getDiarias() {
		return diarias;
	}

	public void setDiarias(Collection<Diaria> diarias) {
		this.diarias = diarias;
	}
 
	
}
