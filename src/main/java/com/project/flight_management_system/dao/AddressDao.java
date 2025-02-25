package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.repo.AddressRepo;
@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	public Address fetchAddressById(int addressById) {
		Optional<Address> address=addressRepo.findById(addressById);
//		if(address.isPresent()) {
//			return address.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(address.isEmpty()) {
			return null;
		}
		else {
			return address.get();
		}
		
	}
	public Address deleteAddressById(int addressById) {
//		Address address=addressRepo.findById(addressById).get();
		Address address=fetchAddressById(addressById);
		addressRepo.delete(address);
		return address;
	}
	public Address updateAddressById(int oldAddressId,Address newAddress) {
		newAddress.setAddressId(oldAddressId);
//		return addressRepo.save(newAddress);
		return saveAddress(newAddress);
	}
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
}
