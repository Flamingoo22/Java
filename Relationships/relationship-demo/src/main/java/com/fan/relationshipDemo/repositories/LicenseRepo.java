package com.fan.relationshipDemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.relationshipDemo.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long>{

}
