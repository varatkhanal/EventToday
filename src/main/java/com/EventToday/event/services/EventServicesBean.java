package com.EventToday.event.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EventToday.event.dao.EventsRepository;
import com.EventToday.event.model.Events;

@Service("eventsService")
@Transactional
public class EventServicesBean implements EventsServices{
	
	
	
	@Autowired
	private EventsRepository eventsRepository;
	
	public EventServicesBean(EventsRepository eventService){
		this.eventsRepository = eventService;
	}
	
	
	@Override
	//@Cacheable(value="events")
	public Collection<Events> findAll() {
		return this.eventsRepository.findAll();
	}

	@Override
	public Events findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Events evnts) {
		//eventsRepository.saveEvents(evnts);
	}

	@Override
	public void update(Events evnts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BigDecimal> sortTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
