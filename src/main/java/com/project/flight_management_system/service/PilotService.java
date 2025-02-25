package com.project.flight_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PilotDao;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.exception.PilotIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class PilotService {
	@Autowired
	PilotDao pilotDao;
	
	@Autowired
	ResponseStructure<Pilot> responseStructure;
	@Autowired
	ResponseStructureAll<Pilot> responseStructureAll;
	
	public ResponseStructure<Pilot> fetchAllPilot() {
		responseStructureAll.setMessage("successfully Pilot has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(pilotDao.fetchAllPilot());
		return responseStructure;
	}
	public ResponseStructure<Pilot> fetchPilotById(int pilotById) {
		Pilot pilot=pilotDao.fetchPilotById(pilotById);
		if(pilot!=null) {
			responseStructure.setMessage("success Pilot fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData( pilotDao.fetchPilotById(pilotById));
			return responseStructure;
		}else {
			throw new PilotIdNotFound();
		}
		
	}
	public ResponseStructure<Pilot> savePilot(Pilot pilot) {
		responseStructure.setMessage("success Pilot is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(pilotDao.savePilot(pilot));
		return responseStructure;
	}
	
	public ResponseStructure<Pilot> deletePilotById(int pilotById) {
		Pilot pilot=pilotDao.fetchPilotById(pilotById);
		if(pilot!=null) {
			responseStructure.setMessage("success Pilot deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData( pilotDao.deletePilotById(pilotById));
			return responseStructure;
		}else {
			throw new PilotIdNotFound();
		}
	}
	public ResponseStructure<Pilot> updatePilotById(int oldPilotId,Pilot newPilot) {
		Pilot pilot=pilotDao.fetchPilotById(oldPilotId);
		if(pilot!=null) {
			responseStructure.setMessage("success Pilot updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData( pilotDao.updatePilotById(oldPilotId, newPilot));
			return responseStructure;
		}else {
			throw new PilotIdNotFound();
		}
		
	}
	
	
//	public Pilot savePilot(Pilot pilot) {
//		return pilotDao.savePilot(pilot);
//	}
//	public Pilot fetchPilotById(int pilotById) {
//		return pilotDao.fetchPilotById(pilotById);
//	}
//	public Pilot deletePilotById(int pilotById) {
//		return pilotDao.deletePilotById(pilotById);
//	}
//	public Pilot updatePilotById(int oldPilotId,Pilot newPilot) {
//		return pilotDao.updatePilotById(oldPilotId, newPilot);
//	}
//	public List<Pilot> fetchAllPilot() {
//		return pilotDao.fetchAllPilot();
//	}

}
