package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.model.Sponsor;


@Transactional
@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, String>{
	

	@Query("select s from Sponsor s where sponsorId=?1 and password=?2")
	Sponsor getSponsor(String sponsorId,String password);

}
