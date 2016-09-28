package com.EventToday.event.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.EventToday.event.model.events;

@Repository("eventsrepository")
public class eventsRepositoryIMPL extends abstractRepository<Integer, events> implements eventsRepository{

	@Override
	public events findById(int id) {
		return (events) getByKey(id);
	}

	@Override
	public void saveEvents(events event) {
		persist(event);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<events> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<events>) criteria.list();
	}
	
	public events findEventsBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (events) criteria.uniqueResult();
	}
    
	public void delete(int id){
		Query query = getSession().createSQLQuery("delete from event where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}
}
