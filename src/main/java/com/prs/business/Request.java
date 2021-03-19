package com.prs.business;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="Requests")
public class Request {

	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String description;
private String justification;
private String rejectionReason;
private String deliveryMode;
private String status;
private double total;
private LocalDate dateNeeded;
private LocalDate submittedDate;
@ManyToOne
@JoinColumn(name="UserId")
private User user;



public Request(int id, String description, String justification, String rejectionReason, String deliveryMode,
		String status, double total, LocalDate dateNeeded, LocalDate submittedDate, User user) {
	super();
	this.id = id;
	this.description = description;
	this.justification = justification;
	this.rejectionReason = rejectionReason;
	this.deliveryMode = deliveryMode;
	this.status = status;
	this.total = total;
	this.dateNeeded = dateNeeded;
	this.submittedDate = submittedDate;
	this.user = user;
}

public Request() {
	super();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getJustification() {
	return justification;
}

public void setJustification(String justification) {
	this.justification = justification;
}

public String getRejectionReason() {
	return rejectionReason;
}

public void setRejectionReason(String rejectionReason) {
	this.rejectionReason = rejectionReason;
}

public String getDeliveryMode() {
	return deliveryMode;
}

public void setDeliveryMode(String deliveryMode) {
	this.deliveryMode = deliveryMode;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public LocalDate getDateNeeded() {
	return dateNeeded;
}

public void setDateNeeded(LocalDate dateNeeded) {
	this.dateNeeded = dateNeeded;
}

public LocalDate getSubmittedDate() {
	return submittedDate;
}

public void setSubmittedDate(LocalDate submittedDate) {
	this.submittedDate = submittedDate;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "Request [id=" + id + ", description=" + description + ", justification=" + justification
			+ ", rejectionReason=" + rejectionReason + ", deliveryMode=" + deliveryMode + ", status=" + status
			+ ", total=" + total + ", dateNeeded=" + dateNeeded + ", submittedDate=" + submittedDate + ", user=" + user
			+ "]";
}


}
