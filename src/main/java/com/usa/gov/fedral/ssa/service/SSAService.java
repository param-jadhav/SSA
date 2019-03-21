package com.usa.gov.fedral.ssa.service;

import com.usa.gov.fedral.ssa.model.SsnMaster;
import com.usa.gov.fedral.ssa.resource.model.SsnProfile;

public interface SSAService {
	public long enrollForSSN(SsnMaster ssnModel);
	
	public SsnProfile validateSSN(long ssn);
}
