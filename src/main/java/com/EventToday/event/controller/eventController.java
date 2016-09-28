package com.EventToday.event.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.EventToday.event.model.events;
import com.EventToday.event.services.eventsServices;

@Controller
@RequestMapping("/")

public class eventController {
	 
	@Autowired
	private eventsServices eventsservices;
	
	@Autowired
	MessageSource messageSource;
	
	
	@RequestMapping(value={"/","/events"},
			method=RequestMethod.GET)
	public ModelAndView getEvents(ModelMap model){
		Collection<events> evnts = eventsservices.findAll();
		model.addAttribute("evnts", evnts);
		return new ModelAndView("allevents", model);
		
	}
	
	@RequestMapping(value="/events/{id}",
			method=RequestMethod.GET
			)	
	public ResponseEntity<events> getEvent(@PathVariable("id") int id){
		events evnts = eventsservices.findById(id);
		if(evnts==null){
			return new ResponseEntity<events>(evnts, HttpStatus.NOT_FOUND);
		}
		 
		return new ResponseEntity<events>(evnts,HttpStatus.OK);
		
	}
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public ModelAndView newEvents(ModelMap model) {
		events events= new events();
		model.addAttribute("events", events);
		model.addAttribute("edit", false);
		return new ModelAndView("registration",model);
	}
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public ModelAndView saveEvents(@Valid events evnts, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			//model.addAttribute("events", "not registered");
			return new ModelAndView("registration",model);	
		}
		
		eventsservices.create(evnts);

		model.addAttribute("success", "Events " + evnts.getEventname() + " registered successfully");
		return new ModelAndView("success",model);	
	}
	
	@RequestMapping(value = { "/edit-{id}-event" }, method = RequestMethod.GET)
	public ModelAndView editEvents(@PathVariable int id, ModelMap model) {
		events evnts = eventsservices.findById(id);
		model.addAttribute("events", evnts);
		model.addAttribute("edit", true);
		return new ModelAndView("registration",model);
	}
	
	
	@RequestMapping(value = { "/edit-{id}-event" }, method = RequestMethod.POST)
	public ModelAndView updateEvents(@Valid events evnts, BindingResult result,
			ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return new ModelAndView("registration",model);
		}

		eventsservices.update(evnts);
		model.addAttribute("success", "Events " + evnts.getEventname()	+ " updated successfully");
		return new ModelAndView("success",model);
	}

	@RequestMapping(value = { "/delete-{id}-event" }, method = RequestMethod.GET)
	public String deleteEvents(@PathVariable("id") int id,ModelMap model) {
		eventsservices.delete(id);
		return "redirect:/events";
	   // return new ModelAndView("allevents",model);
		
	}
	@RequestMapping(value = { "/cheap-ticket" }, method = RequestMethod.GET)
	public ModelAndView sortTickets(ModelMap model) {
		List<BigDecimal> list = new ArrayList<>();
		list = eventsservices.sortTickets();
		model.addAttribute("lists", list);
		//return "redirect:/events";
	   return new ModelAndView("tickets",model);
		
	}
	
}
