package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.repo.PaymentRepo;
@Repository
public class PaymentDao {
	@Autowired
	PaymentRepo paymentRepo;
	@Autowired
	TicketDao ticketDao;
	
	public Payment addExistingticketToExistingPayment(int ticketId,int paymentId) {
		Payment payment=fetchPaymentById(paymentId);
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		payment.setTicket(ticket);
		return savePayment(payment);
	}
	
	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}
	public Payment fetchPaymentById(int paymentById) {
		Optional<Payment> payment=paymentRepo.findById(paymentById);
//		if(payment.isPresent()) {
//			return payment.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(payment.isEmpty()) {
			return null;
		}
		else {
			return payment.get();
		}
	}
	public Payment deletePaymentById(int paymentById) {
//		Payment payment=paymentRepo.findById(paymentById).get();
		Payment payment=fetchPaymentById(paymentById);
		paymentRepo.delete(payment);
		return payment;
	}
	public Payment updatePaymentById(int oldPaymentId,Payment newPayment) {
		newPayment.setPaymentId(oldPaymentId);
//		return paymentRepo.save(newPayment);
		return savePayment(newPayment);
	}
	public List<Payment> fetchAllPayment() {
		return paymentRepo.findAll();
	}

}
