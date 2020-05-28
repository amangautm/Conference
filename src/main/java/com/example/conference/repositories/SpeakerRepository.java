package com.example.conference.repositories;

import com.example.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SpeakerRepository extends CrudRepository<Speaker,Long> {
}
