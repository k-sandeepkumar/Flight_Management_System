package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.repo.PilotRepo;
@Repository
public class PilotDao {
	@Autowired
	PilotRepo pilotRepo;
	
	public Pilot savePilot(Pilot pilot) {
		return pilotRepo.save(pilot);
	}
	public Pilot fetchPilotById(int pilotById) {
		Optional<Pilot> pilot=pilotRepo.findById(pilotById);
//		if(pilot.isPresent()) {
//			return pilot.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(pilot.isEmpty()) {
			return null;
		}
		else {
			return pilot.get();
		}
	}
	public Pilot deletePilotById(int pilotById) {
//		Pilot pilot=pilotRepo.findById(pilotById).get();
		Pilot pilot=fetchPilotById(pilotById);
		pilotRepo.delete(pilot);
		return pilot;
	}
	public Pilot updatePilotById(int oldPilotId,Pilot newPilot) {
		newPilot.setPilotId(oldPilotId);
//		return pilotRepo.save(newPilot);
		return savePilot(newPilot);
	}
	public List<Pilot> fetchAllPilot() {
		return pilotRepo.findAll();
	}
}
