package com.usa.gov.fedral.ssa.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.gov.fedral.ssa.constant.AppConstants;
import com.usa.gov.fedral.ssa.entity.StateMasterEntity;
import com.usa.gov.fedral.ssa.model.SsnMaster;
import com.usa.gov.fedral.ssa.properties.AppProperties;
import com.usa.gov.fedral.ssa.service.SSAService;

@Controller
public class SSAController {
	
	private static Logger logger=LoggerFactory.getLogger(SSAController.class);
	
	@Autowired(required = true)
	private SSAService service;
	
	@Autowired(required=true)
	private AppProperties appProperties;
	

	/**
	 * This method is used for displaying enrollment form
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(path = "/enrollSSN", method = RequestMethod.GET)
	public String enrollForSSNForm(Model model) {
		logger.debug("***SSAController:: enrollForSSNForm() method called***");
		// creating Empty SSA_Master model class obj
		SsnMaster ssnModel = new SsnMaster();
		// adding ssaModel obj to model attribute for binding with form
		model.addAttribute(AppConstants.SSN_MODEL, ssnModel);

		initForm(model);
		logger.debug("***SSAController:: enrollForSSNForm() method ended***");
		logger.info("***SSAController:: Enrollment form generated***");
		return "enrollSSN";
	}
	/**
	 * This method is used for enrollment for ssn
	 * @param ssnModel
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/enrollSSN", method = RequestMethod.POST)
	public String enrollForSSN(@ModelAttribute(name = AppConstants.SSN_MODEL) SsnMaster ssnModel, Model model) {
		logger.debug("***SSAController:: enrollForSSN() method called***");
		//calling service enrollForSSN 
		long ssn = service.enrollForSSN(ssnModel);
		// setting ssn to model attrib
		if(ssn>0) {
			//format ssn
			String SSN=Long.toString(ssn);
			StringBuilder sb=new StringBuilder(SSN);
			sb.insert(3,"-");
			sb.insert(6,"-");
			SSN=sb.toString();
			model.addAttribute(AppConstants.SUCCESS, appProperties.getProperties().get(AppConstants.ENROLL_SUCCESS)+" "+SSN);
			logger.info("***SSAController:: Enrolled Success with SSN***");
		}
		else { 
			model.addAttribute(AppConstants.FAILURE, appProperties.getProperties().get(AppConstants.ENROLL_SUCCESS));
			logger.info("***SSAController:: Enrollment Failure***");
		}
		initForm(model);
		logger.debug("***SSAController:: enrollForSSN() method ended***");
		return "enrollSSN";
	}

	/**
	 * This method is used to load gender and states for application
	 * 
	 * @param model
	 */
	private void initForm(Model model) {
		List<StateMasterEntity> listEntity=null;
		List<String> statesList=new ArrayList<String>();
		//invoke the service class method
		listEntity=service.findAllStates();
		listEntity.forEach(entity->{
			statesList.add(entity.getStateName());
		});
		model.addAttribute("statesList", statesList);

		List<String> gendersList = new ArrayList<>();
		gendersList.add("Male");
		gendersList.add("Fe-Male");
		model.addAttribute("gendersList", gendersList);
	}
}
