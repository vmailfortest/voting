package ru.javawebinar.voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Dish;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DishRepository {

    @Autowired
    private CrudDishRepository crudRepository;

    @Transactional
    public Dish save(Dish dish) {
        if (!dish.isNew() && get(dish.getId()) == null) {
            return null;
        }

        return crudRepository.save(dish);
    }

    public Dish get(int id) {
        return crudRepository.get(id);
    }

    public List<Dish> get(LocalDate date) {
        return crudRepository.get(date);
    }

    public List<Dish> getAll() {
        return crudRepository.findAll();
    }

    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }
}
