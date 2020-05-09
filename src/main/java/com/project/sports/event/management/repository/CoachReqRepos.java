package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.CoachRegis;
import com.project.sports.event.management.model.SponsorRegis;


@Transactional
@Repository
public interface CoachReqRepos extends JpaRepository<CoachRegis, String> {
	
	@Query("select s from CoachRegis s where eventId=?1 and coachId=?2")
	CoachRegis getCoachRequest(String eventId, String coachId);

}

