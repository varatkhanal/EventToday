package com.EventToday.event.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.EventToday.event.model.Organizer;

public class OrganizerValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Organizer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Organizer org = (Organizer) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orgName", "","Organizer name is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "", "date is empty");
		ValidationUtils.rejectIfEmpty(errors, "location", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "Address", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "contact_no", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "alternate_contact", "", "address is empty");
		
	}

	

}
