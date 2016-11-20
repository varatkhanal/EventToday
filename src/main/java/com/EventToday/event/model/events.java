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
public class events extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "roid")
    private Organizer organizer;

	public events() {
		
	}
	
	@Column(name = "event_name", nullable = false)
	private String eventname;
	
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
	private String Address;
	
	@Column(name="contact_no", nullable=false)
	private String contact_no;
	
	@Column(name="alt_contact_no", nullable=false)
	private String alternate_contact;
	
	@Column(name="mail_address")
	private String mail_address;
	
	
	
	
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getAlternate_contact() {
		return alternate_contact;
	}
	public void setAlternate_contact(String alternate_contact) {
		this.alternate_contact = alternate_contact;
	}
	
	
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEventname() {
		return eventname;
		
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
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
		if (!(obj instanceof events))
			return false;
		events other = (events) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "events [id=" + id + ", eventname=" + eventname + ", date=" + date + ", price=" + price + ", location="
				+ location + ", Address=" + Address + ", contact_no=" + contact_no + ", alternate_contact="
				+ alternate_contact + ", mail_address=" + mail_address + "]";
	}
	
	
}
