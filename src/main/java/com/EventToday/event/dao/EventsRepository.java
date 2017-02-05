package com.EventToday.event.dao;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EventToday.event.model.Events;



@Transactional
public interface EventsRepository extends Repository<Events, Long>{
	Events findByeventName(String eventName);		
//	void saveEvents(Events event);	
	List<Events> findAll();	
	//void delete(int id);
}
