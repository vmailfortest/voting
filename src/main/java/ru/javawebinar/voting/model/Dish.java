package ru.javawebinar.voting.model;

import javax.persistence.*;

@NamedQueries({
//        @NamedQuery(name = Dish.ALL_SORTED, query = "SELECT m FROM Meal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC"),
//        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId"),
//        @NamedQuery(name = Dish.GET_BETWEEN, query = "SELECT m FROM Meal m " +
//                "WHERE m.user.id=:userId AND m.dateTime >= :startDate AND m.dateTime < :endDate ORDER BY m.dateTime DESC"),
})
@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"datetime", "title", "rest_id"}, name = "dishes_unique_datetime_title_rest_idx")})
public class Dish extends AbstractBaseEntity{

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "datetime", nullable = false)
    private String datetime;

    @Column(name = "rest_id", nullable = false)
    private int rest_id;

    public Dish() {
    }

    public Dish(String title, String datetime, int rest_id){
        this.title = title;
        this.datetime = datetime;
        this.rest_id = rest_id;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return title;
    }
    public void setName(String title) {
        this.title = title;
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
