package com.example.glow.entity.mongoDb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "interview")
public class InterviewResource {

    @Id
    @Column(name = "_id")
    private Double id;

    @Column(name = "answers_on_questions")
    private String answersOnQuestions;

    @Column(name = "app_id")
    private Double appId;

    @Column(name = "interview_datetime")
    private String interviewDatatime;

}
