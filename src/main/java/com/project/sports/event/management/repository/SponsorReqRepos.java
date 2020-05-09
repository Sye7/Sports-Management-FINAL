package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.SponsorRegis;

@Transactional
@Repository
public interface SponsorReqRepos  extends JpaRepository<SponsorRegis, String>{
	
	@Query("select s from SponsorRegis s where eventId=?1 and sponsorId=?2")
	SponsorRegis getSponsorRequest(String eventId, String sponsorId);
}
