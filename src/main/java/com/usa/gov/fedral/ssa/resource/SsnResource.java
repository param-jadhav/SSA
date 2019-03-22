package com.usa.gov.fedral.ssa.resource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usa.gov.fedral.ssa.exception.InvalidSSN;
import com.usa.gov.fedral.ssa.exception.SSNNotfoundException;
import com.usa.gov.fedral.ssa.resource.model.SsnProfile;
import com.usa.gov.fedral.ssa.service.SSAService;

@RestController
public class SsnResource {
	
	public SsnResource() {
		System.out.println("SSN_Resource.SSNResource()");
	}

	@Autowired(required=true)
	private SSAService service;
	
	private Logger logger=Logger.getLogger(SsnResource.class);
	
	/**
	 * This method is used to valid given SSN
	 * @param ssn
	 * @return
	 */
	@GetMapping(path="/validateSSN/{ssn}",produces= {"application/json","application/xml"})
	public ResponseEntity<Object> validateSSN(@PathVariable long ssn) {
		logger.debug("validateSSN() method execution is started");
		//call service class validateSSN() method
		SsnProfile profile=service.retriveSSN(ssn);
		if(null!=profile) {
			logger.debug("validateSSN() method execution is ended");
			logger.debug("SSN validation is Completed");
			return ResponseEntity.ok(profile);
		}

		logger.debug("validateSSN() method execution is ended");
		logger.debug("SSN validation is faild");
		throw new SSNNotfoundException("Invalid SSN");
	}
}
