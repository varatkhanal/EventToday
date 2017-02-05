package com.EventToday.event.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.EventToday.event.model.Events;
import com.EventToday.event.model.Organizer;
import com.EventToday.event.services.EventsServices;



@Controller
@RequestMapping("/")
public class EventController {
	
	@Autowired
	private EventsServices eventsServices;
	
/*	@Autowired
	private OrganizerServices orgServices;*/
	
	
	@Autowired
	MessageSource messageSource;
	
	@InitBinder("Organizer")
    public void initOwnerBinder(WebDataBinder dB) {
        //dB.setDisallowedFields("id");
        dB.setValidator(new OrganizerValidator());
    }

    @InitBinder("evt")
    public void initEventBinder(WebDataBinder dB) {
    	dB.setValidator(new EventValidator());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		dB.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, true));
    }
    
	@RequestMapping(value={"/","/events"},
			method=RequestMethod.GET)
	public ModelAndView getEvents(ModelMap model){
		Collection<Events> evnts = eventsServices.findAll();
		model.addAttribute("evnts", evnts);
		return new ModelAndView("allevents", model);
		
	}
	
	@RequestMapping(value="/events/{id}",
			method=RequestMethod.GET
			)	
	public ResponseEntity<Events> getEvent(@PathVariable("id") int id){
		Events evnts = eventsServices.findById(id);
		if(evnts==null){
			return new ResponseEntity<Events>(evnts, HttpStatus.NOT_FOUND);
		}
		 
		return new ResponseEntity<Events>(evnts,HttpStatus.OK);
		
	}
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public ModelAndView newEvents(ModelMap model) {
		Events evt =new Events();
		model.addAttribute("events", evt);
		model.addAttribute("edit", false);
		return new ModelAndView("registration",model);
	}
	
	
	@RequestMapping(value = { "/edit-{id}-event" }, method = RequestMethod.GET)
	public ModelAndView editEvents(@PathVariable int id, ModelMap model) {
		Events evnts = eventsServices.findById(id);
		model.addAttribute("events", evnts);
		model.addAttribute("edit", true);
		return new ModelAndView("registration",model);
	}
	
	
	@RequestMapping(value = { "/edit-{id}-event" }, method = RequestMethod.POST)
	public ModelAndView updateEvents(@Valid Events evnts, BindingResult result,
			ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return new ModelAndView("registration",model);
		}

		eventsServices.update(evnts);
		model.addAttribute("success", "Events " + evnts.getEventname()	+ " updated successfully");
		return new ModelAndView("success",model);
	}

	@RequestMapping(value = { "/delete-{id}-event" }, method = RequestMethod.GET)
	public String deleteEvents(@PathVariable("id") int id,ModelMap model) {
		eventsServices.delete(id);
		return "redirect:/events";
		
	}
	/*@RequestMapping(value = { "/tickets" }, method = RequestMethod.GET)
	public ModelAndView sortTickets(ModelMap model) {
		List<BigDecimal> list = new ArrayList<>();
		list = eventsServices.sortTickets();
		model.addAttribute("list", list);
	   return new ModelAndView("tickets",model);*/
		

	
	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public ModelAndView saveEvents(@Valid Organizer org, @Valid Events evt, BindingResult result,ModelMap model) {
		
		/*if (StringUtils.hasLength(org.getOrganizerName()) && evt.isNew() && org.getOrgAddress().isEmpty() && org.getMailAddress().isEmpty() && org.getOrgTelephone() != null){
            result.rejectValue("name", "duplicate", "already exists");
        }*/
        if (result.hasErrors()) {
            model.addAttribute("evt", evt);
            return new ModelAndView("registration",model);
        } else {
           // org.addEvents(evt);
            this.eventsServices.create(evt);
            model.addAttribute("evt", evt);
            return new ModelAndView("registration",model);
            //return "redirect:/owners/{ownerId}";
        }
        
	}
	
	//organizer
	@RequestMapping(value = { "/registerAc" }, method = RequestMethod.GET)
	public ModelAndView newAccount(ModelMap model) {
		Organizer org= new Organizer();
		model.addAttribute("Organizer", org);
		model.addAttribute("edit", false);
		return new ModelAndView("/registerAc",model);
	}
	
/*	@RequestMapping(value = { "/registerAc" }, method = RequestMethod.POST)
	public ModelAndView saveOrganizer(@Valid @ModelAttribute("Organizer") Organizer org, BindingResult result,ModelMap model) {
		
		if (StringUtils.hasLength(org.getOrganizerName()) && org.getOrgAddress().isEmpty() && org.getMailAddress().isEmpty() && org.getOrgTelephone() != null){
            result.rejectValue("organizerName", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.addAttribute("Organizer", org);
            return new ModelAndView("registerAc",model);
        } else {
            //owner.addPet(pet);
        	//org.setPassword(PasswordEncripter.md5(org.getPassword()));
            this.orgServices.saveOrganizer(org);
            Events evt = new Events();
            model.addAttribute("organizerid",org.getRoid());
            model.addAttribute("events",evt);
            return new ModelAndView("registration",model);
        }	
	}*/
	
	//login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	
	@RequestMapping(value = { "/registerAc" }, method = RequestMethod.POST)
	public String saveOrganizer(@Valid @ModelAttribute("Organizer") Organizer org, BindingResult result,ModelMap model) {
		/*//User registered = new User(org.getMailAddress(), org.getPassword(), null);
		if (!result.hasErrors()) {
			createUserAccount(org, result);
		}*/
	    if (result.hasErrors()) {
	        return "registerAc";
	    } 
	    else {
	    	//orgServices.saveOrganizer(org);
	    	//securityService.autologin(org.getMailAddress(), org.getPassword());
	        return "registration";
	    }
	}
	/*private User createUserAccount(Organizer org, BindingResult result) {
		User registered = null;
		try {
			registered = orgServices.registerNewUserAccount(org);
		} catch(EmailExistsException e) {
			return null;
		}
		return registered;
	}*/
	
	/** Login form with error. */
    @RequestMapping("/login-error.html")
    public String loginError(ModelMap model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
	
