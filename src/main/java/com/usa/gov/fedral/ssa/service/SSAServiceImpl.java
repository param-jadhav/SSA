package com.usa.gov.fedral.ssa.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.gov.fedral.ssa.entity.SsnMasterEntity;
import com.usa.gov.fedral.ssa.entity.StateMasterEntity;
import com.usa.gov.fedral.ssa.model.SsnMaster;
import com.usa.gov.fedral.ssa.repository.SsnMasterRepository;
import com.usa.gov.fedral.ssa.repository.StateMasterRepository;
import com.usa.gov.fedral.ssa.resource.model.SsnProfile;

@Service("ssaService")
public class SSAServiceImpl implements SSAService {

	private static Logger logger = LoggerFactory.getLogger(SSAServiceImpl.class);

	@Autowired(required = true)
	private SsnMasterRepository ssn_MasterRepository;
	
	@Autowired
	private StateMasterRepository stateMasterRepository;

	@Override
	public long enrollForSSN(SsnMaster ssnModel) {
		logger.debug("***SSAServiceImpl:: enrollForSSN() method called***");
		SsnMasterEntity entity = new SsnMasterEntity();
		try {
			BeanUtils.copyProperties(ssnModel, entity);
			entity.setPhoto(ssnModel.getPhoto().getBytes());
			entity = ssn_MasterRepository.save(entity);
			logger.debug("***SSAServiceImpl:: enrollForSSN() method ended***");
		} catch (IOException e) {
			logger.error("***SSAServiceImpl:: enrollForSSN() method error***", e);
		}
		logger.info("***SSAServiceImpl:: SSN generated***");
		return entity.getSSN();
	}

	@Override
	public SsnProfile retriveSSN(long ssn) {
		logger.debug("retriveSSN() method execution is started");
		SsnProfile profile = new SsnProfile();
		SsnMasterEntity entity = null;
		
		Optional<SsnMasterEntity> optEntity = ssn_MasterRepository.findById(ssn);
		if (optEntity.isPresent()) {
			entity = optEntity.get();
			if (entity != null) {
				BeanUtils.copyProperties(entity, profile);
				logger.debug("retriveSSN() method execution is ended");
				logger.info("SSN retrive is completed");
				return profile;
			}
		}
		logger.debug("retriveSSN() method execution is ended");
		logger.info("SSN retrive is faild");
		return null;
	}
	
	public List<StateMasterEntity> findAllStates() {
		logger.debug("findAllStates() method execution is started");
		List<StateMasterEntity> listEntity=null;
		listEntity=stateMasterRepository.findAll();
		//return entity object
		logger.debug("findAllStates() method execution is ended");
		logger.debug("All state retrive is completed");
		return listEntity;
	}//method
}//class
