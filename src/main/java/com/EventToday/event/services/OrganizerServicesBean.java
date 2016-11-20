package com.EventToday.event.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EventToday.event.Repository.OrganizerDAO;
import com.EventToday.event.model.Organizer;

@Service("organizerservices")
@Transactional
public class OrganizerServicesBean implements OrganizerServices{
	
	@Autowired
	private OrganizerDAO orgDao;

	@Override
	public Collection<Organizer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organizer findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void saveOrganizer(Organizer org) {
		orgDao.saveOrganizer(org);
		
	}

	@Override
	public void update(Organizer evnts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
