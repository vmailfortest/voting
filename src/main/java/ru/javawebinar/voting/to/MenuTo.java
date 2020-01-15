package ru.javawebinar.voting.to;

import ru.javawebinar.voting.model.AbstractBaseEntity;

import java.util.List;

public class MenuTo extends AbstractBaseEntity {

    private RestaurantTo restaurant;

    private List<DishTo> dishes;

    private Long votesCount;

    public MenuTo(RestaurantTo restaurant, List<DishTo> dishes, Long votesCount) {
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.votesCount = votesCount;
    }

    public RestaurantTo getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantTo restaurant) {
        this.restaurant = restaurant;
    }

    public List<DishTo> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishTo> dishes) {
        this.dishes = dishes;
    }

    public Long getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Long votesCount) {
        this.votesCount = votesCount;
    }
}
