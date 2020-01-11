package ru.javawebinar.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {
    @Column(name = "datetime", nullable = false)
    private String datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "rest_id", nullable = false)
    @NotNull
    private int rest_id;

    public Vote(Integer id, String datetime, int rest_id) {
        super(id);
        this.datetime = datetime;
        this.rest_id = rest_id;
    }

    public Vote(String datetime, int rest_id) {
        this.datetime = datetime;
        this.rest_id = rest_id;
    }

    public String getDate() {
        return datetime;
    }

    public void setDate(String date) {
        this.datetime = datetime;
    }
}