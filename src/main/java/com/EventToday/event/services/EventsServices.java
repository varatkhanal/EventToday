package com.EventToday.event.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.EventToday.event.model.Events;

public interface EventsServices {
	
	Collection<Events> findAll();
	
	Events findById(int id);
	
	void create(Events evnts);
	
	
	void update(Events evnts);
	
	List<BigDecimal> sortTickets();
	
	void delete(int id);
}
