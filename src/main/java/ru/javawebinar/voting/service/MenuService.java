package ru.javawebinar.voting.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.repository.DishRepository;
import ru.javawebinar.voting.repository.VoteRepository;
import ru.javawebinar.voting.to.MenuTo;
import ru.javawebinar.voting.util.DishesUtil;
import ru.javawebinar.voting.util.RestaurantsUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final DishRepository dishRepository;

    //    @Autowired
    private final VoteRepository voteRepository;

    public MenuService(DishRepository dishRepository, VoteRepository voteRepository) {
        this.dishRepository = dishRepository;
        this.voteRepository = voteRepository;
    }

    public List<MenuTo> get(LocalDate date) {
        var dishes = dishRepository.get(date);
        var votes = voteRepository.get(date);

        Map<Restaurant, List<Dish>> dishesMap = dishes.stream()
                .collect(Collectors.groupingBy(Dish::getRestaurant));

        Map<Restaurant, Long> votesMap = votes.stream()
                .collect(Collectors.groupingBy(Vote::getRestaurant, Collectors.counting()));

        List<MenuTo> result = new ArrayList<>();
        for (Map.Entry<Restaurant, List<Dish>> entry : dishesMap.entrySet()) {
            MenuTo menuTo = new MenuTo(
                    RestaurantsUtil.createTo(entry.getKey()),
                    DishesUtil.createTos(entry.getValue()),
                    votesMap.get(entry.getKey()));
            result.add(menuTo);
        }

        return result;
    }
}