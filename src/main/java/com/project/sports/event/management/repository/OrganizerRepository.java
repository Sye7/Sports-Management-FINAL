package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.Organizer;

@Transactional
@Repository
public interface OrganizerRepository extends CrudRepository<Organizer, String>{

	@Query("select s from Organizer s where organizerId=?1 and password=?2")
	Organizer getOrganizer(String organizerId,String password);
}
