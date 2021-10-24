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

@Data
@Document(collection = "interview")
public class InterviewResource {

    @Id
    @Field(value = "_id")
    private Long id;

    @Field(value = "answers_on_questions")
    private Map<String, String> answersOnQuestions;


    @Field(value = "app_id")
    private Long appId;

    @Field(value = "interview_datetime")
    private String interviewDatetime;

    public InterviewResource() {
    }

    public InterviewResource(Long id, Map<String, String> answersOnQuestions, Long appId, String interviewDatetime) {
        this.id = id;
        this.answersOnQuestions = answersOnQuestions;
        this.appId = appId;
        this.interviewDatetime = interviewDatetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getAnswersOnQuestions() {
        return answersOnQuestions;
    }

    public void setAnswersOnQuestions(Map<String, String> answersOnQuestions) {
        this.answersOnQuestions = answersOnQuestions;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getInterviewDatetime() {
        return interviewDatetime;
    }

    public void setInterviewDatetime(String interviewDatetime) {
        this.interviewDatetime = interviewDatetime;
    }
}
