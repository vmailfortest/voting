package ru.javawebinar.voting.util;

import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.to.RestaurantTo;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsUtil {

    public static RestaurantTo createTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName());
    }

    public static List<RestaurantTo> createTos(List<Restaurant> restaurants) {
        List<RestaurantTo> result = new ArrayList<>();
        restaurants.forEach(x -> result.add(createTo(x)));
        return result;
    }
}
