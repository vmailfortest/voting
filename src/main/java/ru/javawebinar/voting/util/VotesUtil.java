package ru.javawebinar.voting.util;

import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.to.DishTo;
import ru.javawebinar.voting.to.VoteTo;

import java.util.ArrayList;
import java.util.List;

public class VotesUtil {

    public static VoteTo createTo(Vote vote) {
        return new VoteTo(vote.getId(), vote.getDate(), vote.getUser().id(), vote.getRestaurant().id());
    }

    public static List<VoteTo> createTos(List<Vote> votes) {
        List<VoteTo> result = new ArrayList<>();
        votes.forEach(x -> result.add(createTo(x)));
        return result;
    }

    public static Vote createNewFromTo(VoteTo voteTo) {
        return new Vote(voteTo.getId(), voteTo.getDatetime(), new Restaurant(voteTo.getRestaurantId(), ""));
    }
}
