package com.usa.gov.fedral.ssa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usa.gov.fedral.ssa.exception.InvalidSSN;
import com.usa.gov.fedral.ssa.resource.model.SsnProfile;
import com.usa.gov.fedral.ssa.service.SSAService;

@RestController
public class SsnResource {
	
	public SsnResource() {
		System.out.println("SSN_Resource.SSN_Resource()");
	}

	@Autowired(required=true)
	private SSAService service;
	
	/**
	 * This method is used to valid given SSN
	 * @param ssn
	 * @return
	 */
	@GetMapping(path="/validateSSN/{ssn}",produces= {"application/json","application/xml"})
	public ResponseEntity<Object> validateSSN(@PathVariable long ssn) {
		//call service class validateSSN() method
		SsnProfile profile=service.validateSSN(ssn);
		if(null!=profile) {
			return ResponseEntity.ok(profile);
		}
		InvalidSSN exception = new InvalidSSN();
		exception.setStatusCode(400);
		exception.setErrorDesc("Invalid SSN");
		return ResponseEntity.badRequest().body(exception);
	}
}
