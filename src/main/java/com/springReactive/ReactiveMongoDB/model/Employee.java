package com.springReactive.ReactiveMongoDB.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @MongoId
    private String empID;

    private String empName;

    private String empCity;

    private double empExperience;
}
