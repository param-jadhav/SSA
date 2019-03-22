package com.usa.gov.fedral.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import com.usa.gov.fedral.ssa.entity.StateMasterEntity;

public interface StateMasterRepository extends JpaRepository<StateMasterEntity,Serializable>{

}
