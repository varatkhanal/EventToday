package com.EventToday.event.dao;

import java.util.Collection;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EventToday.event.model.Events;

public interface EventsRepository extends Repository<Events, Integer>{
	
	
    @Transactional(readOnly = true)
    Collection<Events> findAll();
	

}
