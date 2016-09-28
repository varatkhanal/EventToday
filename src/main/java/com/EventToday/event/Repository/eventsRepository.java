package com.EventToday.event.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.EventToday.event.model.events;

@Repository
public interface eventsRepository{
	
	events findById(int id);

	void saveEvents(events event);
	
	void delete(int id);
	
	events findEventsBySsn(String ssn);
	
	List<events> findAll();
}
