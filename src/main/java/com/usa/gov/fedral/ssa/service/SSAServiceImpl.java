package com.usa.gov.fedral.ssa.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.gov.fedral.ssa.entity.SsnMasterEntity;
import com.usa.gov.fedral.ssa.entity.UsaStatesMasterEntity;
import com.usa.gov.fedral.ssa.model.SsnMaster;
import com.usa.gov.fedral.ssa.repository.SsnMasterRepository;
import com.usa.gov.fedral.ssa.repository.UsaStatesMasterRepository;
import com.usa.gov.fedral.ssa.resource.model.SsnProfile;

@Service("ssaService")
public class SSAServiceImpl implements SSAService {

	private static Logger logger = LoggerFactory.getLogger(SSAServiceImpl.class);

	@Autowired(required = true)
	private SsnMasterRepository ssn_MasterRepository;
	
	@Autowired
	private UsaStatesMasterRepository usaStatesMasterRepository;

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
	public SsnProfile validateSSN(long ssn) {
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

	@Override
	public Map<String, String> getAllStates() {
		logger.debug("getAllStates() method execution is started");
		// getting all states
		List<UsaStatesMasterEntity> entityList = usaStatesMasterRepository.findAll();
		Map<String, String> stateMap=new HashMap<String, String>();
		entityList.forEach(entity->{
			stateMap.put(entity.getStateCode(), entity.getStateName());
		});
		logger.debug("getAllStates() method execution is ended");
		logger.debug("All state retrive is completed");
		return stateMap;
	}

}
