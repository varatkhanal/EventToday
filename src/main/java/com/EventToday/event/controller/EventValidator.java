package com.EventToday.event.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.EventToday.event.model.Events;



public class EventValidator implements Validator {
	
	private static final String REQUIRED = "required";

	@Override
	public boolean supports(Class<?> clazz) {
		return Events.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Events evt = (Events) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventname", "","Eventname is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "", "date is empty");
		ValidationUtils.rejectIfEmpty(errors, "location", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "Address", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "contact_no", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "alternate_contact", "", "address is empty");
		
		
	}	
}
