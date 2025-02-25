package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.repo.PassportRepo;
@Repository
public class PassportDao {
	@Autowired
	PassportRepo passportRepo;
	
	public Passport savePassport(Passport passport) {
		return passportRepo.save(passport);
	}
	public Passport fetchPassportById(int passportById) {
		Optional<Passport> passport=passportRepo.findById(passportById);
//		if(passport.isPresent()) {
//			return passport.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(passport.isEmpty()) {
			return null;
		}
		else {
			return passport.get();
		}
		
	}
	public Passport deletePassportById(int passportById) {
//		Passport passport=passportRepo.findById(passportById).get();
		Passport passport=fetchPassportById(passportById);
		passportRepo.delete(passport);
		return passport;
	}
	public Passport updatePassportById(int oldPassportId,Passport newPassport) {
		newPassport.setPassportId(oldPassportId);
//		return passportRepo.save(newPassport);
		return savePassport(newPassport);
	}
	public List<Passport> fetchAllPassport() {
		return passportRepo.findAll();
	}

}
