package ru.javawebinar.voting.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javawebinar.voting.model.Restaurant;

@RestController
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController extends AbstractRestaurantController{
    static final String REST_URL = "/rest/profile/restaurants";

    @Override
    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return super.get(id);
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
//    public Restaurant create(Restaurant restaurant) {
//        int userId = SecurityUtil.authUserId();
//        checkNew(meal);
//        log.info("create {} for user {}", meal, userId);
//        return service.create(restaurant);
//    }
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