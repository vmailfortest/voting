package ru.javawebinar.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity{

    @Column(name = "datetime", nullable = false)
    @NotNull
    private LocalDate datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, String name, LocalDate datetime, Restaurant restaurant) {
        super(id, name);
        this.datetime = datetime;
        this.restaurant = restaurant;
    }

    public Dish(String name, LocalDate datetime, Restaurant restaurant) {
        super(null, name);
        this.datetime = datetime;
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return datetime;
    }

    public void setDate(LocalDate date) {
        this.datetime = datetime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name=" + name +
                ", dateTime=" + datetime +
                ", restaurant='" + restaurant.getId() + '\'' +
                '}';
    }
}
