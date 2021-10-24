package com.example.glow.entity.mongoDb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.annotation.Documented;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "interview")
public class InterviewResource {

    @Id
    private String id;

    private String answersOnQuestions;
    private String appId;
    private String interviewDatetime;

}
