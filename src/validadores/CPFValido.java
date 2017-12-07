package validadores;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidadorDeCPF.class})
@Pattern(regexp = "\\d{3}(\\.\\d{3}){2}-\\d{2}", message="Formatação de máscara incorreta!")
@Size(min = 14, max = 14)
@ReportAsSingleViolation
public @interface CPFValido {
	String message() default "C.P.F. Inválido!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String umAtributoQualquer() default "Digite um texto a escolha...";
	
}
