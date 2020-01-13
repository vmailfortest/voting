package ru.javawebinar.voting.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class VoteTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 2, max = 100)
    private String datetime;

    @Email
    @NotBlank
    @Size(max = 100)
    private int user;

    @NotBlank
    @Size(max = 32, message = "length must be between 5 and 32 characters")
    private int restaurant;

    public VoteTo() {
    }

    public VoteTo(Integer id, String datetime, int user, int restaurant) {
        super(id);
        this.datetime = datetime;
        this.user = user;
        this.restaurant = restaurant;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Integer getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    @Override
    public String toString() {
        return "UserTo{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
                '}';
    }
}
