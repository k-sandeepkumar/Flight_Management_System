package com.project.flight_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.TicketDao;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class TicketService {
	@Autowired
	TicketDao ticketDao;
	@Autowired
	ResponseStructure<Ticket> responseStructure;
	@Autowired
	ResponseStructureAll<Ticket> responseStructureAll;
	
	
	public ResponseStructureAll<Ticket> fetchAllTicket() {
		responseStructureAll.setMessage("successfully Ticket has been Fetched ");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(ticketDao.fetchAllTicket());
		return responseStructureAll;
	}
	public ResponseStructure<Ticket> fetchTicketById(int ticketById) {
		Ticket ticket= ticketDao.fetchTicketById(ticketById);
		if(ticket!=null) {
			responseStructure.setMessage("success Ticket fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ticketDao.fetchTicketById(ticketById));
		}
		return responseStructure;
	}
	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setMessage("success Seat is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return responseStructure;
	
	}
	
	public ResponseStructure<Ticket> deleteTicketById(int ticketById) {
		Ticket ticket= ticketDao.fetchTicketById(ticketById);
		if(ticket!=null) {
			responseStructure.setMessage("success Ticket deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ticketDao.deleteTicketById(ticketById));
		}
		return responseStructure;
	}
	public ResponseStructure<Ticket> updateTicketById(int oldTicketId,Ticket newTicket) {
		Ticket ticket= ticketDao.fetchTicketById(oldTicketId);
		if(ticket!=null) {
			responseStructure.setMessage("success Ticket updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
		}
		return responseStructure;
	}
	
//	public Ticket saveTicket(Ticket ticket) {
//		return ticketDao.saveTicket(ticket);
//	}
//	public Ticket fetchTicketById(int ticketById) {
//		return ticketDao.fetchTicketById(ticketById);
//	}
//	public Ticket deleteTicketById(int ticketById) {
//		return ticketDao.deleteTicketById(ticketById);
//	}
//	public Ticket updateTicketById(int oldTicketId,Ticket newTicket) {
//		return ticketDao.updateTicketById(oldTicketId, newTicket);
//	}
//	public List<Ticket> fetchAllTicket() {
//		return ticketDao.fetchAllTicket();
//	}
}
