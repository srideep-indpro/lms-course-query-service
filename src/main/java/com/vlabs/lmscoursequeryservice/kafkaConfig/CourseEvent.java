package com.vlabs.lmscoursequeryservice.kafkaConfig;


import com.vlabs.lmscoursequeryservice.model.Course;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseEvent {
    private String message;
    private String status;
    private Course course;
}
