package beans;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import modelo.Sexo;

@ManagedBean
@SessionScoped
public class CadastroPessoasBean {
	private Pessoa pessoaSelecionada;
	private Collection<Pessoa> lista;
	private String tipoNovaPessoa;
		
	public CadastroPessoasBean() {
//		lista = new ArrayList<Pessoa>();
//		//pessoaSelecionada = new PessoaFisica();
//		
//		lista.clear();
//		for(int x=0; x<10;x++) {
//			Pessoa p = (x%2==0) ?  new PessoaFisica() : new PessoaJuridica();
//			p.setNome(String.format("Hospede %02d", x));
//			p.setEmail(String.format("cliente%02d@teste.com",x));
//			p.setTelefone(String .format("(091)890238%02d",x));
//			lista.add(p);
//		}
	}

	public void Listar() {
		lista = new ArrayList<Pessoa>();
		//pessoaSelecionada = new PessoaFisica();
		
		lista.clear();
		
		if(tipoNovaPessoa.equals("PF")) {
			for(int x=0; x<10;x++) {
				Pessoa p =  new PessoaFisica() ;
				p.setNome(String.format("Hospede %02d", x));
				p.setEmail(String.format("cliente%02d@teste.com",x));
				p.setTelefone(String .format("(091)890238%02d",x));
				lista.add(p);
			}
			
			
		} else if(tipoNovaPessoa.equals("PJ")){
			for(int x=0; x<6;x++) {
				Pessoa p =  new PessoaFisica() ;
				p.setNome(String.format("Empresa %02d", x));
				p.setEmail(String.format("empresa%02d@teste.com",x));
				p.setTelefone(String .format("(091)890238%02d",x));
				lista.add(p);
			}
		}
	
	}
	public void criar() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		if(tipoNovaPessoa==null) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Você deve especficar o tipo de Pessoa!",""));
			return;
		}
		if(tipoNovaPessoa.equals("PF")) {
			pessoaSelecionada = new PessoaFisica();
			
		} else if(tipoNovaPessoa.equals("PJ")){
			pessoaSelecionada = new PessoaJuridica();
			
		}
		contexto.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Pessoa criada com sucesso!",""));
	}
	
	public void salvar() {
		if(!lista.contains(pessoaSelecionada)) { 
			lista.add(pessoaSelecionada);
		}
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO
				,"Pessoa incluída com sucesso!"
				,""));

	}
	
	public String cancelar(){
		pessoaSelecionada = null;
		tipoNovaPessoa = null;
		lista.clear();
		return "Primeiro.jsf";
		
	}
	
	public String voltar() {
		pessoaSelecionada = null;
		tipoNovaPessoa = null;
		return "cadastropessoas.jsf";
	}
	
	public void excluir() {
		lista.remove(pessoaSelecionada);
		pessoaSelecionada = null;
		FacesContext.getCurrentInstance().addMessage(
													null, new FacesMessage(
																			FacesMessage.SEVERITY_INFO
																			, "Pessoa excluída com sucesso!"
																			,""));
		
	}
	
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}
	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	public Collection<Pessoa> getLista() {
		return lista;
	}
	public void setLista(Collection<Pessoa> lista) {
		this.lista = lista;
	}
	
	public String getTipoNovaPessoa() {
		return tipoNovaPessoa;
	}

	public void setTipoNovaPessoa(String tipoNovaPessoa) {
		this.tipoNovaPessoa = tipoNovaPessoa;
	}
	
	// Métodos getters de atributos inexistentes
	public Sexo[] getSexos() {
		return Sexo.values();
	}

	public boolean isPessoaFisicaSelecionada() {
		return 	pessoaSelecionada instanceof PessoaFisica;
	}
	
	public boolean isPessoaJuridicaSeleciona() {
		return pessoaSelecionada instanceof PessoaJuridica;
	}

	

}
