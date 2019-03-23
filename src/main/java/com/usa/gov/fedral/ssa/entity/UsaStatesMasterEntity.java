package com.usa.gov.fedral.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USA_STATES_MASTER")
public class UsaStatesMasterEntity {

	@Id
	@SequenceGenerator(sequenceName = "state_seq", name = "gen11", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen11", strategy = GenerationType.SEQUENCE)
	@Column(name="STATE_ID")
	private int stateId;
	
	@Column(name="STATE_CODE")
	private String stateCode;
	
	@Column(name="STATE_NAME")
	private String stateName;
}
