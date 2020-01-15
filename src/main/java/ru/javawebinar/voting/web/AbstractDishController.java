package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.service.DishService;
import ru.javawebinar.voting.to.DishTo;
import ru.javawebinar.voting.util.DishesUtil;

import java.util.List;

@Controller
public abstract class AbstractDishController {
    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);

    @Autowired
    private DishService service;

    public Dish create(DishTo dishTo) {
        log.info("create dish {}", dishTo);
        return service.create(DishesUtil.createNewFromTo(dishTo));
    }

    public DishTo get(int id) {
        log.info("get dish {}", id);
        return DishesUtil.createTo(service.get(id));
    }

    public List<DishTo> getAll() {
        return DishesUtil.createTos(service.getAll());
    }

    public void update(DishTo dishTo, int id) {
        log.info("update dish {}", dishTo);
        service.update(DishesUtil.createNewFromTo(dishTo), id);
    }

    public void delete(int id) {
        log.info("delete dish {}", id);
        service.delete(id);
    }
}