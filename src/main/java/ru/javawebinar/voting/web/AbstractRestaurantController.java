package ru.javawebinar.voting.web;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.service.RestaurantService;

import java.util.List;

public abstract class AbstractRestaurantController {
    //    private static final Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    @Autowired
    private RestaurantService service;

    public Restaurant create(Restaurant restaurant) {
//        log.info("create from to {}", restaurant);
        return service.create(restaurant);
    }

    public Restaurant get(int id) {
//        int userId = SecurityUtil.authUserId();
//        log.info("get meal {} for user {}", id, userId);
        return service.get(id, 0);
    }

    public List<Restaurant> getAll() {
        return service.getAll(0);
    }

    public void update(Restaurant restaurant, int id) {
//        log.info("create from to {}", restaurant);
        service.update(restaurant);
    }

    public void delete(int id) {
        service.delete(id);
    }
}
