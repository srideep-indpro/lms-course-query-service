package com.vlabs.lmscoursequeryservice.kafkaConfig;

import com.vlabs.lmscoursequeryservice.model.Course;
import com.vlabs.lmscoursequeryservice.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private CourseRepository courseRepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(CourseEvent event){
        LOGGER.info(String.format("Course event received in course-query service => %s", event.toString()));
        System.out.println("event++++++++++++++++++");
        System.out.println(event.getCourse().getName());
        if(event.getStatus().contains("DELETE")){
            deleteCourseEntity(event);
        }else{
            saveCourseEntity(event);
        }

    }

    private void deleteCourseEntity(CourseEvent event) {
        Course courseFromEvent = event.getCourse();
        Course courseToBeDeleted = courseRepository.findByName(courseFromEvent.getName());
        if (courseToBeDeleted == null) {
            LOGGER.info("No course available with coursename to be deleted.");
        }
        courseRepository.delete(courseToBeDeleted);
    }

    private void saveCourseEntity(CourseEvent event) {
        LOGGER.info(String.format("Inside saveCourseEntity"));
        Course courseFromEvent = event.getCourse();

        Course courseByName = courseRepository.findByName(courseFromEvent.getName());
        Course savedOrUpdated = null;
        if (courseByName != null) {
            courseFromEvent.setId(courseByName.getId());
            savedOrUpdated = courseRepository.save(courseFromEvent);
            LOGGER.info(String.format("Course updated in query database. Course name => %s", courseFromEvent.getName()));
        }else{
            savedOrUpdated = courseRepository.save(courseFromEvent);
        }
    }
}