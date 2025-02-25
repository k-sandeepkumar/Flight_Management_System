package com.project.flight_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PaymentDao;
import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.exception.PaymentIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	ResponseStructure<Payment> responseStructure;
	@Autowired
	ResponseStructureAll<Payment> responseStructureAll;
	
	
	public ResponseStructureAll<Payment> fetchAllPayment() {
		responseStructureAll.setMessage("successfully payment has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(paymentDao.fetchAllPayment());
		return responseStructureAll;
	}
	public ResponseStructure<Payment> fetchPaymentById(int paymentById) {
		Payment payment =paymentDao.fetchPaymentById(paymentById);
		if(payment!=null) {
			responseStructure.setMessage("success payment fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(paymentDao.fetchPaymentById(paymentById));
			return responseStructure;
		}
		else {
			throw new PaymentIdNotFound();
		}
		
	}
	public ResponseStructure<Payment> savePayment(Payment payment) {
		responseStructure.setMessage("success Payment is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(paymentDao.savePayment(payment));
		return responseStructure;
	}
	
	public ResponseStructure<Payment> deletePaymentById(int paymentById) {
		Payment payment =paymentDao.fetchPaymentById(paymentById);
		if(payment!=null) {
			responseStructure.setMessage("success payment deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(paymentDao.deletePaymentById(paymentById));
			return responseStructure;
		}
		else {
			throw new PaymentIdNotFound();
		}
		
	}
	public ResponseStructure<Payment> updatePaymentById(int oldPaymentId,Payment newPayment) {
		Payment payment =paymentDao.fetchPaymentById(oldPaymentId);
		if(payment!=null) {
			responseStructure.setMessage("success payment updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
			return responseStructure;
		}
		else {
			throw new PaymentIdNotFound();
		}
		
	}
	
	public Payment addExistingticketToExistingPayment(int ticketId,int paymentId) {
		return paymentDao.addExistingticketToExistingPayment(ticketId, paymentId);
	}
	
//	public Payment savePayment(Payment payment) {
//		return paymentDao.savePayment(payment);
//	}
//	public Payment fetchPaymentById(int paymentById) {
//		return paymentDao.fetchPaymentById(paymentById);
//	}
//	public Payment deletePaymentById(int paymentById) {
//		return paymentDao.deletePaymentById(paymentById);
//	}
//	public Payment updatePaymentById(int oldPaymentId,Payment newPayment) {
//		return paymentDao.updatePaymentById(oldPaymentId, newPayment);
//	}
//	public List<Payment> fetchAllPayment() {
//		return paymentDao.fetchAllPayment();
//	}

}
