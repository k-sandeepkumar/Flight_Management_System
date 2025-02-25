package com.project.flight_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.SeatDao;
import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.exception.SeatIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class SeatService {
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ResponseStructure<Seat> responseStructure;
	@Autowired
	ResponseStructureAll<Seat> responseStructureAll;
	public ResponseStructureAll<Seat> fetchAllSeat() {
		responseStructureAll.setMessage("successfully Seat has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(seatDao.fetchAllSeat());
		return responseStructureAll;
	}
	public ResponseStructure<Seat > fetchSeatById(int seatById) {
		Seat seat=seatDao.fetchSeatById(seatById);
		if(seat!=null) {
			responseStructure.setMessage("success seat fetched from the DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(seatDao.fetchSeatById(seatById));
			return responseStructure;
		}
		else {
			throw new SeatIdNotFound();
		}
		
	}
	public ResponseStructure<Seat> saveSeat(Seat seat) {
		responseStructure.setMessage("success Seat is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(seatDao.saveSeat(seat));
		return responseStructure;
	}
	
	public ResponseStructure<Seat> deleteSeatById(int seatById) {
		Seat seat=seatDao.fetchSeatById(seatById);
		if(seat!=null) {
			responseStructure.setMessage("success seat deleted from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(seatDao.deleteSeatById(seatById));
			return responseStructure;
		}
		else {
			throw new SeatIdNotFound();
		}
	}
	public ResponseStructure<Seat> updateSeatById(int oldSeatId,Seat newSeat) {
		Seat seat=seatDao.fetchSeatById(oldSeatId);
		if(seat!=null) {
			responseStructure.setMessage("success seat updated from the DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(seatDao.updateSeatById(oldSeatId, newSeat));
			return responseStructure;
		}
		else {
			throw new SeatIdNotFound();
		}

	}
	
//	public Seat saveSeat(Seat seat) {
//		return seatDao.saveSeat(seat);
//	}
//	public Seat fetchSeatById(int seatById) {
//		return seatDao.fetchSeatById(seatById);
//	}
//	public Seat deleteSeatById(int seatById) {
//		return seatDao.deleteSeatById(seatById);
//	}
//	public Seat updateSeatById(int oldSeatId,Seat newSeat) {
//		return seatDao.updateSeatById(oldSeatId, newSeat);
//	}
//	public List<Seat> fetchAllSeat() {
//		return seatDao.fetchAllSeat();
//	}
}

