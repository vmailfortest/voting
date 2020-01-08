package ru.javawebinar.voting.web;

import ru.javawebinar.voting.model.Dish;

//@RestController
//@RequestMapping(value = MealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController extends AbstractDishController {
    static final String REST_URL = "/rest/profile/dishes";

    public Dish create(Dish dish) {
        return super.create(dish);
    }
}
