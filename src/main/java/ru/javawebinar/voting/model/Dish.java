package ru.javawebinar.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
//    @Column(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, String name, String datetime, Restaurant restaurant){
        super(id, name);
        this.datetime = datetime;
        this.restaurant = restaurant;
    }

    public Dish(String name, String datetime, Restaurant restaurant){
        super(null, name);
        this.datetime = datetime;
        this.restaurant = restaurant;
    }

    public String getDate() {
        return datetime;
    }

    public void setDate(String date) {
        this.datetime = datetime;
    }

    public Restaurant getRestaurantId() {
        return restaurant;
    }

    public void setRestaurantId(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
