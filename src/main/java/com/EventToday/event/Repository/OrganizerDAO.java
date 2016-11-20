package com.EventToday.event.Repository;

import java.util.List;

import com.EventToday.event.model.Organizer;


public interface OrganizerDAO {
	
	Organizer findById(int id);

	void saveOrganizer(Organizer org);
	
	void delete(int id);
	
	List<Organizer> findAll();

}
