package com.usa.gov.fedral.ssa.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SsnMaster {

	private long SSN;
	
	private String firstName;
	
	private String lastName;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dob;
	
	private String gender;
	
	private String phNo;
	
	private String state;
	
	private MultipartFile photo;
	
}
