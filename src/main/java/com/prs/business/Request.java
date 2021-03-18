package com.prs.business;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="Requests")
public class Request {

	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String description;
private String justification;
private String RejectionReason;
private String DeliveryMode;
private String Status;
private double total;
private LocalDateTime DateNeeded;
private LocalDateTime SubmittedDate;
@ManyToOne
@JoinColumn(name="UserId")
private User user;

public Request(int id, String description, String justification, String rejectionReason, String deliveryMode,
		String status, double total, LocalDateTime dateNeeded, LocalDateTime submittedDate, User user) {
	super();
	this.id = id;
	this.description = description;
	this.justification = justification;
	RejectionReason = rejectionReason;
	DeliveryMode = deliveryMode;
	Status = status;
	this.total = total;
	DateNeeded = dateNeeded;
	SubmittedDate = submittedDate;
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
	return RejectionReason;
}

public void setRejectionReason(String rejectionReason) {
	RejectionReason = rejectionReason;
}

public String getDeliveryMode() {
	return DeliveryMode;
}

public void setDeliveryMode(String deliveryMode) {
	DeliveryMode = deliveryMode;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public LocalDateTime getDateNeeded() {
	return DateNeeded;
}

public void setDateNeeded(LocalDateTime dateNeeded) {
	DateNeeded = dateNeeded;
}

public LocalDateTime getSubmittedDate() {
	return SubmittedDate;
}

public void setSubmittedDate(LocalDateTime submittedDate) {
	SubmittedDate = submittedDate;
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
			+ ", RejectionReason=" + RejectionReason + ", DeliveryMode=" + DeliveryMode + ", Status=" + Status
			+ ", total=" + total + ", DateNeeded=" + DateNeeded + ", SubmittedDate=" + SubmittedDate + ", user=" + user
			+ "]";
}


}
