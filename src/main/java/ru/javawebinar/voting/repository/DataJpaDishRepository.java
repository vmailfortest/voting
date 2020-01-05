package ru.javawebinar.voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Dish;

import java.util.List;

@Repository
public class DataJpaDishRepository implements DishRepository {

    @Autowired
    private CrudDishRepository crudRepository;

    @Override
    @Transactional
    public Dish save(Dish meal) {
//        if (!meal.isNew() && get(meal.getId(), userId) == null) {
//            return null;
//        }
//
//        var user = crudUserRepository.getOne(userId);
//        meal.setUser(user);

        return crudRepository.save(meal);
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
