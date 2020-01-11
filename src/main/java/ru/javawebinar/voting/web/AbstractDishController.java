package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.service.DishService;

import java.util.List;

@Controller
public abstract class AbstractDishController {
    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);

    @Autowired
    private DishService service;

    public Dish create(Dish dish) {
        log.info("create dish {}", dish);
        return service.create(dish);
    }

    public Dish get(int id) {
        log.info("get dish {}", id);
        return service.get(id);
    }

    public List<Dish> getAll() {
        return service.getAll();
    }

    public void update(Dish dish, int id) {
        log.info("update dish {}", dish);
        service.update(dish);
    }

    public void delete(int id) {
        log.info("delete dish {}", id);
        service.delete(id);
    }
}