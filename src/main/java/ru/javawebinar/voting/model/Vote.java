package ru.javawebinar.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {

    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Vote() {
    }

    public Vote(Integer id, LocalDateTime datetime, Restaurant restaurant) {
        super(id);
        this.datetime = datetime;
        this.restaurant = restaurant;
    }

    public Vote(LocalDateTime datetime, Restaurant restaurant) {
        this.datetime = datetime;
        this.restaurant = restaurant;
    }

    public LocalDateTime getDate() {
        return datetime;
    }

    public void setDate(LocalDateTime date) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}