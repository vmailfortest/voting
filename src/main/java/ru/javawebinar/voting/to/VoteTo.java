package ru.javawebinar.voting.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

public class VoteTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 2, max = 100)
    private LocalDateTime datetime;

    @Email
    @NotBlank
    @Size(max = 100)
    private int user;

    @NotBlank
    @Size(max = 32, message = "length must be between 5 and 32 characters")
    private int restaurantId;

    public VoteTo() {
    }

    public VoteTo(Integer id, LocalDateTime datetime, int user, int restaurantId) {
        super(id);
        this.datetime = datetime;
        this.user = user;
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "id=" + id +
                ", name=" + datetime +
                ", dateTime=" + datetime +
                ", restaurant=" + restaurantId +
                ", user=" + user +
                '}';
    }
}
