package beans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;


@ManagedBean
@SessionScoped
public class PrimeFacesBean {
	private String nome;
	private String senha;
	private Date data;
	
	
	
	public void definirData(SelectEvent event) {
		setData((Date) event.getObject());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Alterada", "A data agora é: " + data));
		
	}

	public void salvar() {
		setNome(nome);
		setSenha(senha);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
