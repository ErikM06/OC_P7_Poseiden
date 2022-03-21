package com.nnk.springboot.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.*;
import org.passay.PasswordValidator;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPasswordConstraint, String> {
	public PasswordConstraintValidator(List<Rule> asList) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(ValidPasswordConstraint arg0) {

	}

	@Override
	public boolean isValid(String passwordField, ConstraintValidatorContext context) {
		PasswordValidator validator = new PasswordValidator(Arrays.asList(new LengthRule(8, 30),
				new UppercaseCharacterRule(1), new DigitCharacterRule(1), new SpecialCharacterRule(1),
				new NumericalSequenceRule(3, false), new AlphabeticalSequenceRule(3, false),
				new QwertySequenceRule(3, false), new WhitespaceRule()));

		RuleResult result = validator.validate(new PasswordData(passwordField));

		if (result.isValid()) {
			return true;
		}
		List<String> messages = validator.getMessages(result);
		String messageTemplate = messages.stream().collect(Collectors.joining(","));
		context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation()
				.disableDefaultConstraintViolation();
		return false;

	}

}
