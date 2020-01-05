package ru.javawebinar.voting.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.repository.DishRepository;

@Service
public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Dish get(int id, int userId) {
        return null;
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
    public Dish create(Dish meal) {
        Assert.notNull(meal, "meal must not be null");
        return repository.save(meal);
    }
}