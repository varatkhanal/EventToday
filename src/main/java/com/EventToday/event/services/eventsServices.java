package com.EventToday.event.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.EventToday.event.model.events;

public interface eventsServices {
	
	Collection<events> findAll();
	
	events findById(int id);
	
	void create(events evnts);
	
	void update(events evnts);
	
	List<BigDecimal> sortTickets();
	
	void delete(int id);
}
