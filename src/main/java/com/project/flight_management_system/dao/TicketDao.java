package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.repo.TicketRepo;
@Repository
public class TicketDao {
	@Autowired
	TicketRepo ticketRepo;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	public Ticket fetchTicketById(int ticketById) {
		Optional<Ticket> ticket=ticketRepo.findById(ticketById);
//		if(ticket.isPresent()) {
//			return ticket.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(ticket.isEmpty()) {
			return null;
		}
		else {
			return ticket.get();
		}
	}
	public Ticket deleteTicketById(int ticketById) {
//		Ticket ticket=ticketRepo.findById(ticketById).get();
		Ticket ticket=fetchTicketById(ticketById);
		ticketRepo.delete(ticket);
		return ticket;
	}
	public Ticket updateTicketById(int oldTicketId,Ticket newTicket) {
		newTicket.setTicketId(oldTicketId);
//		return ticketRepo.save(newTicket);
		return saveTicket(newTicket);
	}
	public List<Ticket> fetchAllTicket() {
		return ticketRepo.findAll();
	}
}
