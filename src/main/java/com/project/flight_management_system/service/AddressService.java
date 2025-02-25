package com.project.flight_management_system.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AddressDao;
import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.exception.AddressIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructureAll<Address> responseStructureAll;
	
	public ResponseStructureAll<Address> fetchAllAddress() {
		responseStructureAll.setMessage("successfully all address has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(addressDao.fetchAllAddress());
		return responseStructureAll;
	}
	public ResponseStructure<Address> fetchAddressById(int addressById) {
		Address address =addressDao.fetchAddressById(addressById);
		if(address!=null) {
			responseStructure.setMessage("success Address fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.fetchAddressById(addressById));
			return responseStructure;
		}else {
			throw new AddressIdNotFound();
		}
		
	}
	
	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setMessage("success Address is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
	}
	

	public ResponseStructure<Address> deleteAddressById(int addressById) {
		Address address =addressDao.fetchAddressById(addressById);
		if(address!=null) {
			responseStructure.setMessage("success address deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.deleteAddressById(addressById));
			return responseStructure;
		}
		else {
			throw new AddressIdNotFound();
		}
		
		
	}
	public ResponseStructure<Address> updateAddressById(int oldAddressId,Address newAddress) {
		Address address =addressDao.fetchAddressById(oldAddressId);
		if(address!=null) {
			responseStructure.setMessage("success address updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
			return responseStructure;
		}
		else {
			throw new AddressIdNotFound();
		}
		
	}
		
	
//	public Address saveAddress(Address address) {
//		return addressDao.saveAddress(address);
//	}
//	public Address fetchAddressById(int addressById) {
//		return addressDao.fetchAddressById(addressById);
//	}
//	public Address deleteAddressById(int addressById) {
//		return addressDao.deleteAddressById(addressById);
//	}
//	public Address updateAddressById(int oldAddressId,Address newAddress) {
//		return addressDao.updateAddressById(oldAddressId, newAddress);
//	}
//	public List<Address> fetchAllAddress() {
//		return addressDao.fetchAllAddress();
//	}
}
