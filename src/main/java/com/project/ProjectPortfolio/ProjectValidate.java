package com.project.ProjectPortfolio;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = ProjectValidator.class)
@Documented
public @interface ProjectValidate {
	String message() default "Enter a valid estimates which is in fibonacci series between 1 and 21";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 5;
}
