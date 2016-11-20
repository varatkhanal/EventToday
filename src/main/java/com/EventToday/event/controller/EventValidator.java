package com.EventToday.event.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.EventToday.event.model.events;



public class EventValidator implements Validator {
	
	private static final String REQUIRED = "required";

	@Override
	public boolean supports(Class<?> clazz) {
		return events.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		events evt = (events) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventname", "","Eventname is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "", "date is empty");
		ValidationUtils.rejectIfEmpty(errors, "location", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "Address", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "contact_no", "", "address is empty");
		ValidationUtils.rejectIfEmpty(errors, "alternate_contact", "", "address is empty");
		
		/*if (!user.getEmail().contains("@")) {
			errors.rejectValue("email","", "Email is not valid.");
		}*/
		/* String name = evt.getEventname();
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name", REQUIRED, REQUIRED);
        }

        String Address = evt.getAddress();
        if (!StringUtils.hasLength(Address)) {
            errors.rejectValue("Address", REQUIRED, REQUIRED);
        }

        // birth date validation
        if (evt.getDate() == null) {
            errors.rejectValue("Date", REQUIRED, REQUIRED);
        }*/
		
	}	
}
