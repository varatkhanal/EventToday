package com.EventToday.event.Repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.EventToday.event.model.Organizer;

@Repository("Orgrepository")
public class OrganizerDAOIMPL extends AbstractOrganizerDAO<Integer, Organizer> implements OrganizerDAO {
	
	@Override
	public Organizer findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrganizer(Organizer org) {
            persist(org);
	}

	@Override
	public void delete(int id) {
		Query query = getSession().createSQLQuery("delete from organizer where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}


	@Override
	public List<Organizer> findAll() {
		//Criteria criteria = createEntityCriteria();
		//return (List<Organizer>) criteria.list();
		return null;
	}

}
