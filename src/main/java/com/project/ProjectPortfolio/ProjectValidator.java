package com.project.ProjectPortfolio;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

//Validates Estimates
@Component
public class ProjectValidator implements ConstraintValidator<ProjectValidate, Integer> {

	private static boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt(x);
		return (s * s == x);
	}

	@Override
	public boolean isValid(Integer estimates, ConstraintValidatorContext arg1) {
		if (estimates < 1 || estimates > 21) {
			return false;
		}
		boolean result = isPerfectSquare(5 * estimates * estimates + 4)
				|| isPerfectSquare(5 * estimates * estimates - 4);
		return result;
	}

}
