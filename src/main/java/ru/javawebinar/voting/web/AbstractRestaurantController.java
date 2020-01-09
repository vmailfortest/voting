package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.service.RestaurantService;

import java.util.List;

public abstract class AbstractRestaurantController {
        private static final Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    @Autowired
    private RestaurantService service;

    public Restaurant create(Restaurant restaurant) {
        log.info("create restaurant {}", restaurant);
        return service.create(restaurant);
    }

    public Restaurant get(int id) {
//        int userId = SecurityUtil.authUserId();
        log.info("get restaurant {}", id);
        return service.get(id, 0);
    }

    public List<Restaurant> getAll() {
        return service.getAll(0);
    }

    public void update(Restaurant restaurant, int id) {
        log.info("update restaurant {}", restaurant);
        service.update(restaurant);
    }

    public void delete(int id) {
        log.info("delete restaurant {}", id);
        service.delete(id);
    }
}
