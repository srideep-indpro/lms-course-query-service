package com.vlabs.lmscoursequeryservice.repository;

import com.vlabs.lmscoursequeryservice.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    public Course findByName(String name);

    @Query("{ technology : { $regex : ?0 ,$options: 'i'} }")
    public List<Course> getCoursesByTechnologyRegEx(String technology);

    public List<Course> findByDurationBetween(int dur1, int dur2);
}
