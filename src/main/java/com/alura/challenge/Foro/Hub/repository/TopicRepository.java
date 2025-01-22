package com.alura.challenge.Foro.Hub.repository;

import com.alura.challenge.Foro.Hub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
