package ru.javawebinar.voting.util;

import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.to.DishTo;
import ru.javawebinar.voting.to.RestaurantTo;
import ru.javawebinar.voting.to.VoteTo;

import java.util.ArrayList;
import java.util.List;

public class DishesUtil {

    public static DishTo createTo(Dish dish) {
        return new DishTo(dish.getId(), dish.getName(), dish.getDate(), dish.getRestaurant().getId());
    }

    public static List<DishTo> createTos(List<Dish> dishes) {
        List<DishTo> result = new ArrayList<>();
        dishes.forEach(x -> result.add(createTo(x)));
        return result;
    }

//    public static Dish createNewFromTo(DishTo dishTo) {
//        return new Dish(dishTo.getName(), dishTo.getDatetime(), new Restaurant("dishTo.getRestaurantId()"));
//    }
}
