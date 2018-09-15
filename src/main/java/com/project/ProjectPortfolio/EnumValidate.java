package com.project.ProjectPortfolio;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({METHOD,FIELD,PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
@Documented
public @interface EnumValidate {

	String message() default "Enter a valid Project Type,either DOCSMANAGE or SECURITIES ";
	 
	public abstract Class<?>[] groups() default {};
	  
    public abstract Class<? extends Payload>[] payload() default {};
     
    public abstract Class<? extends java.lang.Enum<?>> enumClass();
     
    public abstract boolean ignoreCase() default false;

}
