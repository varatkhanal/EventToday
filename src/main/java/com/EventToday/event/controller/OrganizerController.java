package com.EventToday.event.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.EventToday.event.model.Organizer;
import com.EventToday.event.services.OrganizerServices;

@Controller

public class OrganizerController {
	
	@Autowired
	private OrganizerServices orgServices;
	
	
	@RequestMapping(value = { "/registerAc" }, method = RequestMethod.GET)
	public ModelAndView newAccount(ModelMap model) {
		Organizer org= new Organizer();
		model.addAttribute("org", org);
		model.addAttribute("edit", false);
		return new ModelAndView("registerAc",model);
	}
	
	@RequestMapping(value = { "/registerAc" }, method = RequestMethod.POST)
	public ModelAndView saveOrganizer(@Valid Organizer org, BindingResult result,ModelMap model) {
		/*if (result.hasErrors()) {
			//model.addAttribute("events", "not registered");
			return new ModelAndView("registerAC",model);	
		}*/
		if (StringUtils.hasLength(org.getOrganizerName()) && org.isNew() && org.getOrgAddress().isEmpty() && org.getMailAddress().isEmpty() && org.getOrgTelephone() != null){
            result.rejectValue("organizerName", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.addAttribute("org", org);
            return new ModelAndView("registerAc",model);
        } else {
            //owner.addPet(pet);
            this.orgServices.saveOrganizer(org);
            model.addAttribute("organizerid",org.getRoid());
            return new ModelAndView("registerAc",model);
        }	
	}

}
