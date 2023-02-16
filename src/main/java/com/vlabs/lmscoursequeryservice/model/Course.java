package com.vlabs.lmscoursequeryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("COURSES-QUERY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private String id;
//    @NotNull
//    @Size(min = 5)
    private String name;
//    @NotNull
    private int duration;
//    @NotNull
//    @Size(min = 10)
    private String description;
//    @NotNull
    private String technology;
//    @NotNull
    private String launchURL;

    public Course(String name, int duration, String description, String technology, String launchURL) {
        super();
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.technology = technology;
        this.launchURL = launchURL;
    }

}
