package com.EventToday.event.dao;

import java.util.Collection;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EventToday.event.model.Organizer;


public interface OrganizerRepository extends Repository<Organizer,Integer>{
	
	@Transactional(readOnly = true)
	Collection<Organizer> findAll();
		
	Organizer findByOrganizerName(String OrganizerName);
	
	Organizer findByMailAddress(String mailAddress);

	void save(Organizer org);
	
	void delete(int oid);
	
	

}
