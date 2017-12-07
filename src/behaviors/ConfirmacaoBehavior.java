package behaviors;

import javax.faces.application.ResourceDependency;
import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;

@FacesBehavior("clic00.behaviors.Confirmacao")
@ResourceDependency(name="confirmacao.js", library="js", target="head")
public class ConfirmacaoBehavior extends ClientBehaviorBase {

	@Override
	public String getScript(ClientBehaviorContext behaviorContext) {
//		return "return window.confirm('Deseja realmente excluir?')";
		String componente = behaviorContext.getComponent().getAttributes().get("codigo") + "";
		return "return confirmar('Deseja realmente excluir o registro " + componente + "?')";
	}

}
