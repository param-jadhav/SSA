package com.usa.gov.fedral.ssa.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SSN_MASTER")
public class SsnMasterEntity {

	@Id
	@SequenceGenerator(sequenceName = "ssn_seq", name = "gen1", initialValue = 912345678, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private long SSN;

	@Column(name = "First_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "PH_NO")
	private String phNo;

	@Column(name = "STATE")
	private String state;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "photo", nullable = false)
	private byte[] photo;

}
