package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import modelo.Sexo;

@ManagedBean
@SessionScoped
public class CadastroPessoasBean {
	private Pessoa pessoaSelecionada;
	private List<Pessoa> lista = new ArrayList<>();
	private String tipoNovaPessoa;
	private ResourceBundle resource;
	private String mensagem = "";

	public CadastroPessoasBean() {
		lista = new ArrayList<Pessoa>();
		tipoNovaPessoa = "";
		// resource = ResourceBundle.getBundle("bundles.mensagens",
		// FacesContext.getCurrentInstance().getExternalContext().getRequestLocale());
		resource = ResourceBundle.getBundle("bundles.mensagens",
				FacesContext.getCurrentInstance().getViewRoot().getLocale());
	}

	public void Listar() {

		Pessoa p = null;
		lista.clear();

		if (tipoNovaPessoa.equals("PF")) {
			for (int x = 0; x < 10; x++) {
				p = new PessoaFisica();
				p.setNome(String.format("Hospede %02d", x));
				p.setEmail(String.format("cliente%02d@teste.com", x));
				p.setTelefone(String.format("(091)890238%02d", x));
				lista.add(p);
			}

		} else if (tipoNovaPessoa.equals("PJ")) {
			for (int x = 0; x < 6; x++) {
				p = new PessoaJuridica();
				p.setNome(String.format("Empresa %02d", x));
				p.setEmail(String.format("empresa%02d@teste.com", x));
				p.setTelefone(String.format("(091)890238%02d", x));
				lista.add(p);
			}
		}
	}

	public void criar() {
		mensagem = resource.getString("seleciona");
		if (tipoNovaPessoa == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, ""));
			return;
		}

		if (tipoNovaPessoa.equals("PF")) {
			pessoaSelecionada = new PessoaFisica();

		} else if (tipoNovaPessoa.equals("PJ")) {
			pessoaSelecionada = new PessoaJuridica();
		}

		Listar();
	}

	public void salvar() {
		if (!lista.contains(pessoaSelecionada)) {
			lista.add(pessoaSelecionada);
		}
		mensagem = resource.getString("salva");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}

	public String cancelar() {
		pessoaSelecionada = null;
		tipoNovaPessoa = null;
		lista.clear();
		return "inicio";
//		return "cadastropessoas.jsf";

	}

	public void limpar() {

	}

	public String voltar() {
		pessoaSelecionada = null;
		tipoNovaPessoa = null;
		return "cadastro";
	}

	public void excluir() {
		lista.remove(pessoaSelecionada);
		pessoaSelecionada = null;
		resource = ResourceBundle.getBundle("bundles.mensagens",
				FacesContext.getCurrentInstance().getViewRoot().getLocale());
		
		mensagem = resource.getString("excluida");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));

	}
	
	public void ouvinteAjax(AjaxBehaviorEvent event) {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("AJAX " + 	event.getPhaseId());
	}
	
	public void ouvinteAjax(ValueChangeEvent event) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("AJAX value change ");
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
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
		return pessoaSelecionada instanceof PessoaFisica;
	}

	public boolean isPessoaJuridicaSeleciona() {
		return pessoaSelecionada instanceof PessoaJuridica;
	}

	@Override
	public String toString() {
		return "CadastroPessoasBean [pessoaSelecionada=" + pessoaSelecionada + ", lista=" + lista + ", tipoNovaPessoa="
				+ tipoNovaPessoa + ", resource=" + resource + ", mensagem=" + mensagem + "]";
	}

}
