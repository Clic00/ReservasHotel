package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class GeralBean {
	private Locale locale;
	private List<Locale> localesDisponiveis = new ArrayList<>();
	private 		FacesContext contexto = FacesContext.getCurrentInstance();
	
	public GeralBean() {

		Iterator<Locale> it = contexto.getApplication().getSupportedLocales();

		while (it.hasNext()) {
			localesDisponiveis.add(it.next());
		}

		// Atribuindo o Locale sugerido pelo browser:
		locale = contexto.getExternalContext().getRequestLocale();

		// Atribuindo o Locale default do faces-config:
		locale = contexto.getApplication().getDefaultLocale();

		// Atribuindo o Locale calculado pelo UIViewRoot:
		locale = contexto.getViewRoot().getLocale();

	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public List<Locale> getLocalesDisponiveis() {
		return localesDisponiveis;
	}

	public void setLocalesDisponiveis(List<Locale> localesDisponiveis) {
		this.localesDisponiveis = localesDisponiveis;
	}

}
