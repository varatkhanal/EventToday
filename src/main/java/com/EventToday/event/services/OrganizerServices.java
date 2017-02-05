package com.EventToday.event.services;

import java.util.Collection;

import com.EventToday.event.model.Organizer;

public interface OrganizerServices {
	
	Collection<Organizer> findAll();
	
	
	Organizer findById(int id);
	
	Organizer findByOrganizerName(String OrganizerName);	
	
	void saveOrganizer(Organizer org);
	
	void update(Organizer org);
	
	
	void delete(int id);
}