package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	private Endereco endereco;
	private Collection<Reserva> reservas;
	


	public Pessoa() {
		super();
	}   
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(generator="genpessoa")
	@SequenceGenerator(sequenceName	="pessoa_codigo_seq",name="genpessoa")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}   
	@Column(nullable=false,unique=true)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@OneToMany(mappedBy="cliente")
	public Collection<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(Collection<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
}
