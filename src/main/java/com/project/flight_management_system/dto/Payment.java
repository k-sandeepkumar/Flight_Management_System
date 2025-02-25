package com.project.flight_management_system.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String paymentType;
	private String paymentStatus;
	private String paymentInvoice;
	private String paymentTranscationId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ticket ticket;
	
	
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentInvoice() {
		return paymentInvoice;
	}
	public void setPaymentInvoice(String paymentInvoice) {
		this.paymentInvoice = paymentInvoice;
	}
	public String getPaymentTranscationId() {
		return paymentTranscationId;
	}
	public void setPaymentTranscationId(String paymentTranscationId) {
		this.paymentTranscationId = paymentTranscationId;
	}
	
	
}
