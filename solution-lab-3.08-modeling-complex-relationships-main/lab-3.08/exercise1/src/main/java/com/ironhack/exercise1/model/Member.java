package com.ironhack.exercise1.model;

import com.ironhack.exercise1.enums.Status;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Date renewalDate;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    public Member(Chapter chapter, String name, Status status, Date renewalDate) {
        this.chapter = chapter;
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
    }

    public Member() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Chapter getChapter() {
        return this.chapter;
    }

    public void setChapter(Chapter chapterId) {
        this.chapter = chapterId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRenewalDate() {
        return this.renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

}
