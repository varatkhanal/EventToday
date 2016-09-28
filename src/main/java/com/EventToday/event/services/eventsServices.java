package com.EventToday.event.services;

import java.util.Collection;

import com.EventToday.event.model.events;

public interface eventsServices {
	
	Collection<events> findAll();
	
	events findById(int id);
	
	void create(events evnts);
	
	void update(events evnts);
	
	void delete(int id);
}
