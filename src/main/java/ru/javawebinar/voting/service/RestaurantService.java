package ru.javawebinar.voting.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.repository.DishRepository;
import ru.javawebinar.voting.repository.RestaurantRepository;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant get(int id, int userId) {
        return repository.get(id, userId);
    }

    //    public void delete(int id, int userId) {
//        repository.delete(id, userId);
//    }
//
//
//
//    public List<Dish> getAll(int userId) {
//        return repository.getAll(userId);
//    }
//
//    public void update(Dish meal, int userId) {
//        Assert.notNull(meal, "meal must not be null");
//        checkNotFoundWithId(repository.save(meal, userId), meal.getId());
//    }
//
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }
}