package com.EventToday.event.dao;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.EventToday.event.model.Events;

@Repository("eventsRepository")
public class EventsRepositoryBean extends AbstractEventsRepository<Integer, Events> implements EventsRepository{

	
	@SuppressWarnings("unchecked")
	public List<Events> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Events>) criteria.list();
	}
	
	public Events findEventsBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Events) criteria.uniqueResult();
	}
    
	public void delete(int id){
		Query query = getSession().createSQLQuery("delete from event where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<BigDecimal> sortTicket(){
		Query query = getSession().createSQLQuery("select ticket_price from event");
		final List<BigDecimal> list = new LinkedList<>();
		for(final Object o : query.list()) {
		    list.add((BigDecimal)o);
		}
	    return list;
	}

	@Override
	public Events findByeventName(String eventName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 /*@SuppressWarnings("unchecked") 
      public List<events> sortTicket() {
	       Session s = acquireSession();
	       Query   q = s.createQuery("from foo where active");
	       return (List<Foo>) q.list();
	  }*/
}
