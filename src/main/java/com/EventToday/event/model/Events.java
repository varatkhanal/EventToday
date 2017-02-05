package com.EventToday.event.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="event")
public class Events{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "roid")
    private Organizer organizer;

	public Events() {
		
	}
	
	@Column(name = "event_name", nullable = false)
	private String eventName;
	
	@Column(name = "event_date", nullable = false)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate date;
	
	
	@NotNull
	@Digits(integer=8, fraction=2)
	@Column(name = "ticket_price", nullable = false)
	private BigDecimal price;
	
	@Column(name="event_location", nullable=false)
	private String location;
	
	@Column(name="happening_city", nullable=false)
	private String address;
	
	@Column(name="contact_no", nullable=false)
	private String contactNo;
	
	@Column(name="alt_contact_no", nullable=false)
	private String alternateContact;
	
	@Column(name="mail_address")
	private String mailAddress;
	
	
	
	
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	public String getContact_no() {
		return contactNo;
	}
	public void setContact_no(String contact_no) {
		this.contactNo = contact_no;
	}
	public String getAlternate_contact() {
		return alternateContact;
	}
	public void setAlternate_contact(String alternate_contact) {
		this.alternateContact = alternate_contact;
	}
	
	
	public String getMail_address() {
		return mailAddress;
	}
	public void setMail_address(String mail_address) {
		this.mailAddress = mail_address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEventname() {
		return eventName;
		
	}
	public void setEventname(String eventname) {
		this.eventName = eventname;
	}

	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Events))
			return false;
		Events other = (Events) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "events [id=" + id + ", eventname=" + eventName + ", date=" + date + ", price=" + price + ", location="
				+ location + ", Address=" + address + ", contact_no=" + contactNo + ", alternate_contact="
				+ alternateContact + ", mail_address=" + mailAddress + "]";
	}
	
	
}

