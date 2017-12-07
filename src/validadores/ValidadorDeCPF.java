package validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@FacesValidator(value = "validadorDeCPF")
public class ValidadorDeCPF implements Validator, ConstraintValidator<CPFValido, String> {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (!validar(value + "")) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", ""));
		}

	}

	private boolean validar(String value) {
		String cpf = value.toString().replaceAll("[^0-9]", "");

		if (cpf.length() == 11) {

			if (cpf.matches("^(\\d)\\1{10}$")) {
				return false;	
			}

			int div1 = Integer.parseInt(cpf.charAt(9) + "");
			int div2 = Integer.parseInt(cpf.charAt(10) + "");

			// Validando o div1
			int contador = 10;
			int soma = 0;

			for (int x = 0; x < 9; x++) {
				soma += contador * (Integer.parseInt(cpf.charAt(x) + ""));
				contador--;
			}

			int verificador = soma % 11;
			if (verificador < 2)
				verificador = 0;
			else
				verificador = 11 - verificador;

			if (div1 != verificador) {
				return false;

			}

			// Validando o dv2
			contador = 11;
			soma = 0;

			for (int x = 0; x < 10; x++) {
				soma += contador * (Integer.parseInt(cpf.charAt(x) + ""));
				contador--;
			}
			verificador = soma % 11;
			if (verificador < 2)
				verificador = 0;
			else
				verificador = 11 - verificador;

			if (div2 != verificador) {
				return false;
			}

			return true;
		}
		return false;
	}

	@Override
	public void initialize(CPFValido constraintAnnotation) {
		constraintAnnotation.umAtributoQualquer();

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return validar(value);
	}

}
