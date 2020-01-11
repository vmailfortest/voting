package ru.javawebinar.voting;

import org.springframework.test.web.servlet.ResultMatcher;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Restaurant;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.voting.RestaurantTestData.RESTAURANT_1_ID;
import static ru.javawebinar.voting.RestaurantTestData.RESTAURANT_2_ID;
import static ru.javawebinar.voting.TestUtil.readListFromJsonMvcResult;
import static ru.javawebinar.voting.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {
    public static final int DISH_1_ID = START_SEQ + 4;
    public static final String DATE_YESTERDAY = "2020-01-10";
    public static final String DATE_TODAY = "2020-01-11";

    public static final Dish DISH_1 = new Dish(DISH_1_ID, "Чебурек с сыром", DATE_YESTERDAY, RESTAURANT_1_ID);
    public static final Dish DISH_2 = new Dish(DISH_1_ID + 1, "Пепси", DATE_YESTERDAY, RESTAURANT_1_ID);
    public static final Dish DISH_3 = new Dish(DISH_1_ID + 2, "Гречка", DATE_YESTERDAY, RESTAURANT_2_ID);
    public static final Dish DISH_4 = new Dish(DISH_1_ID + 3, "Отбивная", DATE_YESTERDAY, RESTAURANT_2_ID);
    public static final Dish DISH_5 = new Dish(DISH_1_ID + 4, "Бутерброд", DATE_TODAY, RESTAURANT_1_ID);
    public static final Dish DISH_6 = new Dish(DISH_1_ID + 5, "Чай", DATE_TODAY, RESTAURANT_1_ID);
    public static final Dish DISH_7 = new Dish(DISH_1_ID + 6, "Гречневые блины", DATE_TODAY, RESTAURANT_2_ID);
    public static final Dish DISH_8 = new Dish(DISH_1_ID + 7, "Компот", DATE_TODAY, RESTAURANT_2_ID);

    public static final List<Dish> DISHES = List.of(DISH_1, DISH_2, DISH_3, DISH_4, DISH_5, DISH_6, DISH_7, DISH_8);

    public static Dish getNew() {
        return new Dish("Созданный ресторан", DATE_TODAY, DISH_1_ID);
    }

    public static Dish getUpdated() {
        return new Dish(DISH_1_ID, "Планета чебуреков-2", DATE_TODAY, DISH_1_ID);
    }

    public static void assertMatch(Dish actual, Dish expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }

    public static ResultMatcher contentJson(Dish... expected) {
        return contentJson(List.of(expected));
    }

    public static ResultMatcher contentJson(Iterable<Dish> expected) {
        return result -> assertThat(readListFromJsonMvcResult(result, Dish.class)).isEqualTo(expected);
    }
}
