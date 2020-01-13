package ru.javawebinar.voting.util;

import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.to.VoteTo;

public class VotesUtil {

    public static VoteTo createTo(Vote vote) {
        var test = new VoteTo(vote.getId(), vote.getDate(), vote.getUser().id(), vote.getRestaurant().id());
        return test;
//        return new VoteTo(vote.getId(), vote.getDate(), vote.getUser().id(), vote.getRestaurant().id());
    }
}
