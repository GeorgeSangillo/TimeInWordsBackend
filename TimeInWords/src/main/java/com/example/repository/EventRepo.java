package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Event;

@Repository("eventRepo")
@Transactional
public interface EventRepo extends CrudRepository<Event, Integer> {
	List<Event> findAll();
}
