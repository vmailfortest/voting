package ru.javawebinar.voting;

import org.hsqldb.rights.User;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.repository.JdbcDishRepository;
import ru.javawebinar.voting.web.DishRestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
//        var test = new JdbcDishRepository();
//        test.save(new Dish(1, "hello", "2019-12-24", 12));

//        System.out.println(test.get(2));
//        System.out.println(test.get(1));

        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            DishRestController dishController = appCtx.getBean(DishRestController.class);
            dishController.create(new Dish("hello", "2019-12-24 10:00:00", 100000));
            System.out.println();

//            MealRestController mealController = appCtx.getBean(MealRestController.class);
//            List<MealTo> filteredMealsWithExcess =
//                    mealController.getBetween(
//                            LocalDate.of(2015, Month.MAY, 30), LocalTime.of(7, 0),
//                            LocalDate.of(2015, Month.MAY, 31), LocalTime.of(11, 0));
//            filteredMealsWithExcess.forEach(System.out::println);
        }

    }
}