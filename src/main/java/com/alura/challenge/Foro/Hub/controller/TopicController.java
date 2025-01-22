package com.alura.challenge.Foro.Hub.controller;

import com.alura.challenge.Foro.Hub.model.Topic;
import com.alura.challenge.Foro.Hub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<Topic> createTopic(@Valid @RequestBody Topic topic) {
        Topic createdTopic = topicService.createTopic(topic);
        return ResponseEntity.status(201).body(createdTopic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Optional<Topic> topic = topicService.getTopicById(id);
        return topic.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @Valid @RequestBody Topic topic) {
        Optional<Topic> existingTopic = topicService.getTopicById(id);
        if (existingTopic.isPresent()) {
            Topic updatedTopic = existingTopic.get();
            updatedTopic.setTitle(topic.getTitle());
            updatedTopic.setMessage(topic.getMessage());
            updatedTopic.setStatus(topic.getStatus());
            updatedTopic.setAuthor(topic.getAuthor());
            updatedTopic.setCourse(topic.getCourse());

            topicService.createTopic(updatedTopic); // Guardar el tópico actualizado
            return ResponseEntity.ok(updatedTopic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        Optional<Topic> existingTopic = topicService.getTopicById(id);
        if (existingTopic.isPresent()) {
            topicService.deleteTopic(id);
            return ResponseEntity.noContent().build();  // Respuesta 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // Respuesta 404 Not Found
        }
    }
}
