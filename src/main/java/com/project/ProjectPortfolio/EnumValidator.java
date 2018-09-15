package com.project.ProjectPortfolio;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.project.ProjectPortfolio.model.ProjectType;

//Validates Project Type
@Component
public class EnumValidator implements ConstraintValidator<EnumValidate, String> {

	@Override
	public boolean isValid(String type, ConstraintValidatorContext arg1) {
		if (!(type.equals(ProjectType.DOCSMANAGE.toString())) && !(type.equals(ProjectType.SECURITIES.toString())))
			return false;
		return true;
	}

}
