package com.usa.gov.fedral.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.gov.fedral.ssa.entity.UsaStatesMasterEntity;

@Repository("usaStatesMasterRepository")
public interface UsaStatesMasterRepository extends JpaRepository<UsaStatesMasterEntity, Serializable> {

}
