package com.usa.gov.fedral.ssa.service;

import java.util.List;

import com.usa.gov.fedral.ssa.entity.StateMasterEntity;
import com.usa.gov.fedral.ssa.model.SsnMaster;
import com.usa.gov.fedral.ssa.resource.model.SsnProfile;

public interface SSAService {
	public long enrollForSSN(SsnMaster ssnModel);
	
	public SsnProfile retriveSSN(long ssn);
	
	public List<StateMasterEntity> findAllStates();
}
