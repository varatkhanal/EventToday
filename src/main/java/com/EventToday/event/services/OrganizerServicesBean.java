package com.EventToday.event.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EventToday.event.dao.OrganizerRepository;
import com.EventToday.event.model.Organizer;

@Service("organizerservices")
@Transactional
public class OrganizerServicesBean implements OrganizerServices{ 
	
	@Autowired
	private OrganizerRepository organizerRepository;
	

	
	public OrganizerServicesBean(OrganizerRepository orgRepository) {
		this.organizerRepository = orgRepository;
	}

	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	@Override
	public Collection<Organizer> findAll() {
		return this.organizerRepository.findAll();
	}

	@Override
	public Organizer findById(int oid) {
		return null;
	}

	
	@Override
	public void update(Organizer evnts) {
		
	}

	@Override
	public void delete(int oid) {
		
	}
	
	/*@Transactional
	@Override
	public User registerNewUserAccount(Organizer org) throws EmailExistsException {
		if (emailExist(org.getMailAddress())){
			throw new EmailExistsException("There is an account with that email address:" + org.getMailAddress());}
		User user = new User();
		org.setOrganizerName(org.getOrganizerName());
		org.setOrgAddress(org.getOrgAddress());
		org.setPassword(org.getPassword());
		org.setMailAddress(org.getMailAddress());
		return orgDao.saveOrganizer(user);
		 
	}*/
	
	/*private boolean emailExist(String email) {
		Organizer org = orgDao.findByMailAddress(email);
		if (org != null) {
			return true;
		}
		return false;
	}*/

	
	@Override
	public void saveOrganizer(Organizer organizer) {
		//organizer.setPassword(bCryptPasswordEncoder.encode(organizer.getPassword()));
		organizerRepository.save(organizer);
		
	}

    @Override
    public Organizer findByOrganizerName(String username) {
        return organizerRepository.findByOrganizerName(username);
    }

}
