package com.usa.gov.fedral.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.gov.fedral.ssa.entity.SsnMasterEntity;

@Repository("ssnMasterRepository")
public interface SsnMasterRepository extends JpaRepository<SsnMasterEntity, Serializable> {

}
