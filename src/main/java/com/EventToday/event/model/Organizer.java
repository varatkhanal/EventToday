package com.EventToday.event.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.EventToday.event.model.Events;
import com.EventToday.event.validation.ValidEmail;

@Entity
@Table(name="organizer")
public class Organizer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer oid;


	@Column(name="org_name", nullable=false)
	@NotEmpty(message = "Please enter orgnizer Name.")
	private String organizerName;
	
	
	@Column(name = "org_contact", nullable = false)
	@NotEmpty(message = "Please enter Telephone.")
	private String orgTelephone;
	
	@Column(name = "org_altcontact", nullable = false)
	private String orgContact;
	
	@ValidEmail
	@Column(name = "org_mail_address", nullable = false)
	//@NotEmpty(message = "Please enter orgnizer mail address")
	private String mailAddress;
	
	@Column(name = "org_address", nullable = false)
	@NotEmpty(message = "Please enter orgnizer Name.")
	private String orgAddress;
	
	@Column(name = "org_city", nullable = false)
	@NotEmpty(message = "Please enter orgnizer Address city.")
	private String orgCity;
	
	@Column(name = "org_password", nullable = false)
	@NotEmpty(message = "Please enter your password.")
    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
    private String password;
	
	@Transient
	@NotEmpty(message = "Please retype your password.")
    private String retypePassword;
	
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
	 public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrgCity() {
		return orgCity;
	}

	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}


	@OneToMany(mappedBy = "organizer")
	  private Set<Events> evts;
	  
	  


	public Set<Events> getEvts() {
		return evts;
	}

	public void setEvts(Set<Events> evts) {
		this.evts = evts;
	}

	public Organizer() {
	
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
		return "Organizer [oid=" + oid + ", organizerName=" + organizerName + ", orgTelephone=" + orgTelephone
				+ ", orgContact=" + orgContact + ", mailAddress=" + mailAddress + ", orgAddress=" + orgAddress + "]";
	}



	
}

