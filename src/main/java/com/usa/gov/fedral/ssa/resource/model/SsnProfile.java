package com.usa.gov.fedral.ssa.resource.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@XmlRootElement(name="SSNProfile")
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel(description="This is Response Model")
public class SsnProfile {
	
	@ApiModelProperty(notes="Provided SSN")
	private long SSN;
	
	@ApiModelProperty(notes="Date of Birth of SSN Holder")
	private Date dob;
	
	@ApiModelProperty(notes="Holder is Resident of this State")
	private String state;
	
}
