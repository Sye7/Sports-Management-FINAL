package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.Event;
import com.project.sports.event.management.model.Sports;

@Transactional
@Repository
public interface EventRepository extends JpaRepository<Event, String> {

	@Modifying
	@Query("update Event u set u.date = ?2, u.time = ?3, u.venue = ?4, u.noOfSlots=?5  where u.id = ?1")
	void updateEvent(String eventId, String eventDate, String time, String venue, String noOfSlots);
	
	@Modifying
	@Query("delete from Event e where e.eventId=?1")
	void deleteEvent(String eventId);

	@Query("select s from Event s where eventId=?1 and eventName=?2 and sportName=?3")
	Event report(String eventId, String eventName, String sportName);


	@Query("select s from Event s where eventId=?1")
	Event getEvent(String eventId);
	

}
