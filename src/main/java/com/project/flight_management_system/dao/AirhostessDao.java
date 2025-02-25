package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.repo.AirhostessRepo;
@Repository
public class AirhostessDao {
	@Autowired
	AirhostessRepo airhostessRepo;
	
	public Airhostess saveAirhostess(Airhostess airhostess) {
		return airhostessRepo.save(airhostess);
	}
	public Airhostess fetchAirhostessById(int airhostessById) {
		Optional<Airhostess> airhostess=airhostessRepo.findById(airhostessById);
//		if(airhostess.isPresent()) {
//			return airhostess.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(airhostess.isEmpty()) {
			return null;
		}
		else {
			return airhostess.get();
		}
	}
	public Airhostess deleteAirhostessById(int airhostessById) {
//		Airhostess airhostess=airhostessRepo.findById(AirhostessById).get();
		Airhostess airhostess=fetchAirhostessById(airhostessById);
		airhostessRepo.delete(airhostess);
		return airhostess;
	}
	public Airhostess updateAirhostessById(int oldAirhostessId,Airhostess newAirhostess) {
		newAirhostess.setAirhostessId(oldAirhostessId);
//		return airhostessRepo.save(newAirhostess);
		return saveAirhostess(newAirhostess);
	}
	public List<Airhostess> fetchAllAirhostess() {
		return airhostessRepo.findAll();
	}
}
