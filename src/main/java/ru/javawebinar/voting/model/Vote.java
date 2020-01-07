package ru.javawebinar.voting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {
    @Column(name = "datetime", nullable = false)
    private String datetime;

    @Column(name = "user_id", nullable = false)
    private int user_id;

    @Column(name = "rest_id", nullable = false)
    private int rest_id;

    public Vote(String datetime, int user_id, int rest_id) {
        this.datetime = datetime;
        this.user_id = user_id;
        this.rest_id = rest_id;
    }

    public String getDate() {
        return datetime;
    }

    public void setDate(String date) {
        this.datetime = datetime;
    }
}