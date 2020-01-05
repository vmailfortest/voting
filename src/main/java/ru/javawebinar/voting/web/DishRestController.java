package ru.javawebinar.voting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.service.DishService;

@Controller
public class DishRestController {
//    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);

    private final DishService service;

    @Autowired
    public DishRestController(DishService service) {
        this.service = service;
    }

//    public Dish get(int id) {
//        int userId = SecurityUtil.authUserId();
//        log.info("get meal {} for user {}", id, userId);
//        return service.get(id);
//    }

    //    public void delete(int id) {
//        int userId = SecurityUtil.authUserId();
//        log.info("delete meal {} for user {}", id, userId);
//        service.delete(id, userId);
//    }
//
//    public List<MealTo> getAll() {
//        int userId = SecurityUtil.authUserId();
//        log.info("getAll for user {}", userId);
//        return MealsUtil.getTos(service.getAll(userId), SecurityUtil.authUserCaloriesPerDay());
//    }
//
    public Dish create(Dish meal) {
//        int userId = SecurityUtil.authUserId();
//        checkNew(meal);
//        log.info("create {} for user {}", meal, userId);
        return service.create(meal);
    }
//
//    public void update(Meal meal, int id) {
//        int userId = SecurityUtil.authUserId();
//        assureIdConsistent(meal, id);
//        log.info("update {} for user {}", meal, userId);
//        service.update(meal, userId);
//    }
//
//    /**
//     * <ol>Filter separately
//     * <li>by date</li>
//     * <li>by time for every date</li>
//     * </ol>
//     */
//    public List<MealTo> getBetween(@Nullable LocalDate startDate, @Nullable LocalTime startTime,
//                                   @Nullable LocalDate endDate, @Nullable LocalTime endTime) {
//        int userId = SecurityUtil.authUserId();
//        log.info("getBetween dates({} - {}) time({} - {}) for user {}", startDate, endDate, startTime, endTime, userId);
//
//        List<Meal> mealsDateFiltered = service.getBetweenDates(startDate, endDate, userId);
//        return MealsUtil.getFilteredTos(mealsDateFiltered, SecurityUtil.authUserCaloriesPerDay(), startTime, endTime);
//    }
}