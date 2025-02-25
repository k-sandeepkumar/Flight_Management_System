package com.project.flight_management_system.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AirhostessDao;
import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.exception.AirhostessIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class AirhostessService {
	@Autowired
	AirhostessDao airhostessDao;
	@Autowired
	ResponseStructure<Airhostess> responseStructure;
	@Autowired
	ResponseStructureAll<Airhostess> responseStructureAll;
	
	public ResponseStructureAll<Airhostess> fetchAllAirhostess() {
		responseStructureAll.setMessage("successfully all airhostess has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(airhostessDao.fetchAllAirhostess());
		return responseStructureAll;
	}
	public ResponseStructure<Airhostess> fetchAirhostessById(int airhostessById) {
		Airhostess airhostess=airhostessDao.fetchAirhostessById(airhostessById);
		if(airhostess!=null) {
			responseStructure.setMessage("sucess airhostess fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(airhostessDao.fetchAirhostessById(airhostessById));
			
			return responseStructure;
		}
		else {
			throw new AirhostessIdNotFound();
		}
		
	}
	
	public ResponseStructure<Airhostess> saveAirhostess(Airhostess airhostess) {
		responseStructure.setMessage("success Airhostess is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(airhostessDao.saveAirhostess(airhostess));
		return responseStructure;
	}
	
	public ResponseStructure<Airhostess> deleteAirhostessById(int airhostessById) {
		Airhostess airhostess=airhostessDao.fetchAirhostessById(airhostessById);
		if(airhostess!=null) {
			responseStructure.setMessage("sucess airhostess deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airhostessDao.deleteAirhostessById(airhostessById));
			
			return responseStructure;
		}
		else {
			throw new AirhostessIdNotFound();
		}
		
	}
	public ResponseStructure<Airhostess> updateAirhostessById(int oldAirhostessId,Airhostess newAirhostess) {
		Airhostess airhostess=airhostessDao.fetchAirhostessById(oldAirhostessId);
		if(airhostess!=null) {
			responseStructure.setMessage("sucess airhostess updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airhostessDao.updateAirhostessById(oldAirhostessId, newAirhostess));
			
			return responseStructure;
		}
		else {
			throw new AirhostessIdNotFound();
		}
	}
	
//	public Airhostess saveAirhostess(Airhostess airhostess) {
//		return airhostessDao.saveAirhostess(airhostess);
//	}
//	public Airhostess fetchAirhostessById(int airhostessById) {
//		return airhostessDao.fetchAirhostessById(airhostessById);
//	}
//	public Airhostess deleteAirhostessById(int airhostessById) {
//		return airhostessDao.deleteAirhostessById(airhostessById);
//	}
//	public Airhostess updateAirhostessById(int oldAirhostessId,Airhostess newAirhostess) {
//		return airhostessDao.updateAirhostessById(oldAirhostessId, newAirhostess);
//	}
//	public List<Airhostess> fetchAllAirhostess() {
//		return airhostessDao.fetchAllAirhostess();
//	}
}
