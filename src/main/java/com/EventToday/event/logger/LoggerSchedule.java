package com.EventToday.event.logger;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.EventToday.event.model.events;
import com.EventToday.event.services.eventsServices;

@Component
public class LoggerSchedule {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	eventsServices eventsserv;
	
	//@Scheduled(cron="0,30 * * * * *")
	void cronJob() {
		/*logger.info(">eventsSheduling");
		
		//add scheduler method
		Collection<events> list = eventsserv.findAll();
		logger.info("there are {} no of events listed", list.size());
		
		logger.info(">eventsSheduling");*/
	}
	@Scheduled(initialDelay=5000,
			fixedRate=15000
			)
	public void fixedRateWithDelay(){
		/*logger.info(">eventsSheduling with initial delay");
		
		long pause=5000;
		long start=System.currentTimeMillis();
		do{
			if(start+pause<System.currentTimeMillis())
				break;
		}while(true);	
		logger.info("processing time was {} second", pause/100);
		
		logger.info("<eventsSheduling with initial delay");*/
	}
}
	

