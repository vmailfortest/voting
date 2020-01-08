package ru.javawebinar.voting.web;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.service.RestaurantService;

public abstract class AbstractRestaurantController {
    //    private static final Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    @Autowired
    private RestaurantService service;

    public Restaurant get(int id) {
//        int userId = SecurityUtil.authUserId();
//        log.info("get meal {} for user {}", id, userId);
        return service.get(id, 0);
    }
}
