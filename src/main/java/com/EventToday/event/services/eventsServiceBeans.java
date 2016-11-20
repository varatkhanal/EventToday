package com.EventToday.event.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.EventToday.event.Repository.eventsRepository;
import com.EventToday.event.model.events;

@Service("eventsService")
@Transactional
public class eventsServiceBeans implements eventsServices {
	
	@Autowired
	private eventsRepository eventsrepository;
	
	
	
	@Override
	@Cacheable(value="events")
	public Collection<events> findAll() {
		return eventsrepository.findAll();
	}

	@Override
	public events findById(int id) {
		return eventsrepository.findById(id);
	}
	
	@Override
	public void create(events evnts) {
		eventsrepository.saveEvents(evnts);	 
	}

	@Override
	public void update(events evnts) {
		events evntee = eventsrepository.findById(evnts.getId());
		if(evntee!=null){
			evntee.setEventname(evnts.getEventname());
			evntee.setDate(evnts.getDate());
			evntee.setPrice(evnts.getPrice());
		}
	}

	@Override
	public void delete(int id) {
		eventsrepository.delete(id);		
	}
	
	@Override
	public List<BigDecimal> sortTickets(){	
		List<BigDecimal> list =eventsrepository.sortTicket();
		Collections.sort(list);
		return list;
	}

	

}
