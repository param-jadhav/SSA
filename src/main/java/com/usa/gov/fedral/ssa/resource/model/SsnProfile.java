package com.usa.gov.fedral.ssa.resource.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name="SSNProfile")
@XmlAccessorType(XmlAccessType.FIELD)
public class SsnProfile {
	
	private long SSN;
	private Date dob;
	private String state;
	
}
