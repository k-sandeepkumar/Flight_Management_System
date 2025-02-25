package com.project.flight_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PassportDao;
import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.exception.PassportIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class PassportService {
	@Autowired
	PassportDao passportDao;
	@Autowired
	ResponseStructure<Passport> responseStructure;
	@Autowired
	ResponseStructureAll<Passport> responseStructureAll;
	
	public ResponseStructureAll<Passport> fetchAllPassport() {
		responseStructureAll.setMessage("successfully passport has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(passportDao.fetchAllPassport());
		return responseStructureAll;
	}
	public ResponseStructure<Passport> fetchPassportById(int passportById) {
		Passport passport=passportDao.fetchPassportById(passportById);
		if(passport!=null) {
			responseStructure.setMessage("success passport fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(passportDao.fetchPassportById(passportById));
			return responseStructure;
		}
		else {
			throw new PassportIdNotFound();
		}
		
	}
	public ResponseStructure<Passport> savePassport(Passport passport) {
		responseStructure.setMessage("success Passport is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(passportDao.savePassport(passport));
		return responseStructure;
	}
	
	public ResponseStructure<Passport> deletePassportById(int passportById) {
		Passport passport=passportDao.fetchPassportById(passportById);
		if(passport!=null) {
			responseStructure.setMessage("success passport deletd from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(passportDao.deletePassportById(passportById));
			return responseStructure;
		}
		else {
			throw new PassportIdNotFound();
		}
		
	}
	public ResponseStructure<Passport> updatePassportById(int oldPassportId,Passport newPassport) {
		Passport passport=passportDao.fetchPassportById(oldPassportId);
		if(passport!=null) {
			responseStructure.setMessage("success passport updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(passportDao.updatePassportById(oldPassportId, newPassport));
			return responseStructure;
		}
		else {
			throw new PassportIdNotFound();
		}
	}
	
	
//	public Passport savePassport(Passport passport) {
//		return passportDao.savePassport(passport);
//	}
//	public Passport fetchPassportById(int passportById) {
//		return passportDao.fetchPassportById(passportById);
//	}
//	public Passport deletePassportById(int passportById) {
//		return passportDao.deletePassportById(passportById);
//	}
//	public Passport updatePassportById(int oldPassportId,Passport newPassport) {
//		return passportDao.updatePassportById(oldPassportId, newPassport);
//	}
//	public List<Passport> fetchAllPassport() {
//		return passportDao.fetchAllPassport();
//	}
}
