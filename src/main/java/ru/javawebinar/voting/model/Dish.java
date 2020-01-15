package ru.javawebinar.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedQueries({
//        @NamedQuery(name = Dish.ALL_SORTED, query = "SELECT m FROM Meal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC"),
//        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId"),
//        @NamedQuery(name = Dish.GET_BETWEEN, query = "SELECT m FROM Meal m " +
//                "WHERE m.user.id=:userId AND m.dateTime >= :startDate AND m.dateTime < :endDate ORDER BY m.dateTime DESC"),
})
@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity{

    @Column(name = "datetime", nullable = false)
    private LocalDate datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
//    @Column(name = "restaurant_id", nullable = false)
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
}
