package com.fan.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.mvcdemo.models.Donation;

@Repository
public interface DonationRepo extends CrudRepository<Donation, Long> {
	 List<Donation> findAll();
}
