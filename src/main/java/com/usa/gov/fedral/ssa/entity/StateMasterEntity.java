package com.usa.gov.fedral.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STATE_MASTER")
public class StateMasterEntity {
/*	@Id
	@Column(name="STATE_CODE")
	private String StateCode;
*/	@Id
	@Column(name="STATE_NAME",unique=true)
     private String stateName;
}
