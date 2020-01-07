package ru.javawebinar.voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Restaurant;

@Repository
public class RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository crudRepository;

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (!restaurant.isNew()) {
            return null;
        }

//        var user = crudUserRepository.getOne(restaurant);
//        restaurant.setUser(user);

        return crudRepository.save(restaurant);
    }

//    @Override
//    public boolean delete(int id, int userId) {
//        return crudRepository.delete(id, userId) != 0;
//    }
//
//    @Override
//    public Meal get(int id, int userId) {
//        return crudRepository.findById(id).filter(meal -> meal.getUser().getId().equals(userId)).orElse(null);
//    }
//
//    @Override
//    public List<Dish> getAll(int userId) {
//        return crudRepository.findAll(userId);
//    }
//
//    @Override
//    public List<Meal> getBetweenInclusive(LocalDate startDate, LocalDate endDate, int userId) {
//        return crudRepository.getBetween(getStartInclusive(startDate), getEndExclusive(endDate), userId);
//    }
}
