package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class GeralBean {
	private Locale locale;
	private List<Locale> localesDisponiveis = new ArrayList<>();

	public GeralBean() {

		Iterator<Locale> it = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();

		while (it.hasNext()) {
			localesDisponiveis.add(it.next());
		}

		// Atribuindo o Locale sugerido pelo browser:
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();

		// Atribuindo o Locale default do faces-config:
		locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();

		// Atribuindo o Locale calculado pelo UIViewRoot:
		setLocale(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		// locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	}

	public void atualizarLocale(ActionEvent e) throws Exception {
		Locale l = (Locale) e.getComponent().getAttributes().get("locale");

		if (l != null)
			setLocale(l);
		// locale = l;

		FacesContext.getCurrentInstance().getViewRoot().setLocale(getLocale());
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
