package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.NotificationSponsor;

@Repository
@Transactional
public interface NotificationSponsorRepos extends JpaRepository<NotificationSponsor, String> {

}
