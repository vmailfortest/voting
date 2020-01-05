package ru.javawebinar.voting.repository;

import org.springframework.stereotype.Repository;
import ru.javawebinar.voting.model.Dish;

import java.util.Collection;

@Repository
public interface DishRepository {
    // null if not found, when updated
    Dish save(Dish dish);

//    // false if not found
//    boolean delete(int id);
//
//    // null if not found
//    Dish get(int id);
//
//    Collection<Dish> getAll();
}
