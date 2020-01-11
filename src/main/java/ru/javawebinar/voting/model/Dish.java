package ru.javawebinar.voting.model;

import javax.persistence.*;

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

    @Column(name = "restaurant_id", nullable = false)
    private int restaurant_id;

    public Dish() {
    }

    public Dish(Integer id, String name, String datetime, int restaurant_id){
        super(id, name);
        this.datetime = datetime;
        this.restaurant_id = restaurant_id;
    }

    public Dish(String name, String datetime, int restaurant_id){
        super(null, name);
        this.datetime = datetime;
        this.restaurant_id = restaurant_id;
    }

    public String getDate() {
        return datetime;
    }

    public void setDate(String date) {
        this.datetime = datetime;
    }

    public int getRestaurantId() {
        return restaurant_id;
    }

    public void setRestaurantId(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
