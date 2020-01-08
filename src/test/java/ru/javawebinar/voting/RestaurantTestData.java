package ru.javawebinar.voting;

import ru.javawebinar.voting.model.Restaurant;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.voting.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final int RESTAURANT_1_ID = START_SEQ + 2;

    public static final Restaurant RESTAURANT_1 = new Restaurant(RESTAURANT_1_ID, "Планета чебуреков");
    public static final Restaurant RESTAURANT_2 = new Restaurant(RESTAURANT_1_ID + 1, "Гречкин дом");

    public static final List<Restaurant> MEALS = List.of(RESTAURANT_1, RESTAURANT_2);

    public static Restaurant getNew() {
        return new Restaurant("Созданный ресторан");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT_1_ID, "Планета чебуреков-2");
    }

    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }

//    public static ResultMatcher contentJson(MealTo... expected) {
//        return contentJson(List.of(expected));
//    }
//
//    public static ResultMatcher contentJson(Iterable<MealTo> expected) {
//        return result -> assertThat(readListFromJsonMvcResult(result, MealTo.class)).isEqualTo(expected);
//    }
}
