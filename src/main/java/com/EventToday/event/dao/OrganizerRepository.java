package com.EventToday.event.dao;

import java.util.List;

import com.EventToday.event.model.Organizer;


public interface OrganizerRepository {
	
	Organizer findById(int id);
	
	Organizer findByOrganizerName(String OrganizerName);
	
	Organizer findByMailAddress(String mailAddress);

	void saveOrganizer(Organizer org);
	
	void delete(int id);
	
	List<Organizer> findAll();

}
