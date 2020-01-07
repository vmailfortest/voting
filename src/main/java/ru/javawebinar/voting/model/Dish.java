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

    @Column(name = "rest_id", nullable = false)
    private int rest_id;

    public Dish() {
    }

    public Dish(String name, String datetime, int rest_id){
        super(null, name);
        this.datetime = datetime;
        this.rest_id = rest_id;
    }

    public String getDate() {
        return datetime;
    }

    public void setDate(String date) {
        this.datetime = datetime;
    }

    public int getRestaurantId() {
        return rest_id;
    }

    public void setRestaurantId(int rest_id) {
        this.rest_id = rest_id;
    }
}
