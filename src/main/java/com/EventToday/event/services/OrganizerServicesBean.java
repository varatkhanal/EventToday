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
	private OrganizerRepository orgDao;
	
	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	@Override
	public Collection<Organizer> findAll() {
		return null;
	}

	@Override
	public Organizer findById(int id) {
		return null;
	}

	
	@Override
	public void update(Organizer evnts) {
		
	}

	@Override
	public void delete(int id) {
		
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
		orgDao.saveOrganizer(organizer);
		
	}

    @Override
    public Organizer findByOrganizerName(String username) {
        return orgDao.findByOrganizerName(username);
    }

}
