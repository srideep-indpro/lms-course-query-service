package com.vlabs.lmscoursequeryservice.controller;

import com.vlabs.lmscoursequeryservice.model.Course;
import com.vlabs.lmscoursequeryservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${lms.rest.base-url}")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("getAllCourses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("getCoursesByTechnology")
    public List<Course> getCoursesByTechnology(@RequestParam String technology) {
        return courseRepository.getCoursesByTechnologyRegEx(technology);
    }

    @GetMapping("getCoursesByDuration")
    public List<Course> getCoursesByDuration(@RequestParam int fromDuration, @RequestParam int toDuration) {
        return courseRepository.findByDurationBetween(fromDuration, toDuration);
    }
}
