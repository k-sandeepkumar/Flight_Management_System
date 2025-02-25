package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.repo.SeatRepo;
@Repository
public class SeatDao {
	@Autowired
	SeatRepo seatRepo;
	
	public Seat saveSeat(Seat seat) {
		return seatRepo.save(seat);
	}
	public Seat fetchSeatById(int seatById) {
		Optional<Seat> seat=seatRepo.findById(seatById);
//		if(seat.isPresent()) {
//			return seat.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(seat.isEmpty()) {
			return null;
		}
		else {
			return seat.get();
		}
	}
	public Seat deleteSeatById(int seatById) {
//		Seat seat=SeatRepo.findById(seatById).get();
		Seat seat=fetchSeatById(seatById);
		seatRepo.delete(seat);
		return seat;
	}
	public Seat updateSeatById(int oldSeatId,Seat newSeat) {
		newSeat.setSeatId(oldSeatId);
//		return seatRepo.save(newSeat);
		return saveSeat(newSeat);
	}
	public List<Seat> fetchAllSeat() {
		return seatRepo.findAll();
	}
}
