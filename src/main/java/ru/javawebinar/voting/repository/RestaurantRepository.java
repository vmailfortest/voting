package ru.javawebinar.voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Restaurant;

import java.util.List;

@Repository
public class RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository crudRepository;

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (!restaurant.isNew() && get(restaurant.getId(), 0) == null) {
            return null;
        }

        return crudRepository.save(restaurant);
    }

    public Restaurant get(int id, int userId) {
        return crudRepository.findById(id).orElse(null);
    }

    public List<Restaurant> getAll(int userId) {
        return crudRepository.findAll();
    }

    public boolean delete(int id, int userId) {
        return crudRepository.delete(id) != 0;
    }
}
