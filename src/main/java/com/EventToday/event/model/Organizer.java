package com.EventToday.event.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name="organizer")
public class Organizer extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roid;
	
	@Column(name="orgNname", nullable=false)
	private String organizerName;
	
	@Column(name = "org_contact", nullable = false)
	private String orgTelephone;
	
	@Column(name = "org_altcontact", nullable = false)
	private String orgContact;
	
	@Column(name = "org_mail_address", nullable = false)
	private String mailAddress;
	
	@Column(name = "org_address", nullable = false)
	private String orgAddress;
	
	 @OneToMany(mappedBy = "organizer")
	  private Set<events> evts;
	  
	  


	public Set<events> getEvts() {
		return evts;
	}

	public void setEvts(Set<events> evts) {
		this.evts = evts;
	}

	public Organizer() {
	
	}

	public int getRoid() {
		return roid;
	}

	public void setRoid(int roid) {
		this.roid = roid;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getOrgContact() {
		return orgContact;
	}

	public void setOrgContact(String orgContact) {
		this.orgContact = orgContact;
	}


	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrgTelephone() {
		return orgTelephone;
	}

	public void setOrgTelephone(String orgTelephone) {
		this.orgTelephone = orgTelephone;
	}

     
	@Override
	public String toString() {
		return "Organizer [roid=" + roid + ", organizerName=" + organizerName + ", orgTelephone=" + orgTelephone
				+ ", orgContact=" + orgContact + ", mailAddress=" + mailAddress + ", orgAddress=" + orgAddress + "]";
	}



	
}
