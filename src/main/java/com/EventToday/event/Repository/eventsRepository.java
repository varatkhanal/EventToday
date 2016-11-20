package com.EventToday.event.Repository;

import java.math.BigDecimal;
import java.util.List;

import com.EventToday.event.model.events;

public interface eventsRepository{
	
	events findById(int id);

	void saveEvents(events event);
	
	void delete(int id);
	
	events findEventsBySsn(String ssn);
	
	List<BigDecimal> sortTicket();
	
	List<events> findAll();
}
