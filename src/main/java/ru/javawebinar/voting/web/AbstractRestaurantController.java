package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.service.RestaurantService;
import ru.javawebinar.voting.to.RestaurantTo;
import ru.javawebinar.voting.util.RestaurantsUtil;

import java.util.List;

@Controller
public abstract class AbstractRestaurantController {
    private static final Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    @Autowired
    private RestaurantService service;

    public Restaurant create(Restaurant restaurant) {
        log.info("create restaurant {}", restaurant);
        return service.create(restaurant);
    }

    public RestaurantTo get(int id) {
        log.info("get restaurant {}", id);
        return RestaurantsUtil.createTo(service.get(id, 0));
    }

    public List<RestaurantTo> getAll() {
        log.info("get all restaurants");
        return RestaurantsUtil.createTos(service.getAll(0));
    }

    public void update(Restaurant restaurant, int id) {
        log.info("update restaurant {}", restaurant);
         service.update(restaurant, id);
    }

    public void delete(int id) {
        log.info("delete restaurant {}", id);
        service.delete(id);
    }
}
