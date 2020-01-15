package ru.javawebinar.voting.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.repository.RestaurantRepository;

import java.util.List;

import static ru.javawebinar.voting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    public Restaurant get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public List<Restaurant> getAll(int userId) {
        return repository.getAll(userId);
    }

    public void update(Restaurant restaurant, int id) {
        Assert.notNull(restaurant, "restaurant must not be null");
        restaurant.setId(id);
        repository.save(restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id, 0), id);
    }
}