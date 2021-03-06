package ru.javawebinar.voting;

import org.springframework.test.web.servlet.ResultMatcher;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.to.VoteTo;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.voting.RestaurantTestData.RESTAURANT_1;
import static ru.javawebinar.voting.RestaurantTestData.RESTAURANT_2;
import static ru.javawebinar.voting.TestUtil.readListFromJsonMvcResult;
import static ru.javawebinar.voting.model.AbstractBaseEntity.START_SEQ;

public class VoteTestData {
    public static final int VOTE_1_ID = START_SEQ + 12;
    public static final LocalDateTime DATE_YESTERDAY = LocalDateTime.of(2020, 01, 10, 10, 00, 00);
    public static final LocalDateTime DATE_TODAY = LocalDateTime.of(2020, 01, 11, 10, 00, 00);

    public static final Vote VOTE_1 = new Vote(VOTE_1_ID, DATE_YESTERDAY, RESTAURANT_1);
    public static final Vote VOTE_2 = new Vote(VOTE_1_ID + 1, DATE_YESTERDAY, RESTAURANT_2);
    public static final Vote VOTE_3 = new Vote(VOTE_1_ID + 2, DATE_TODAY, RESTAURANT_2);
    public static final Vote VOTE_4 = new Vote(VOTE_1_ID + 3, DATE_TODAY, RESTAURANT_2);

    public static final List<Vote> VOTES = List.of(VOTE_1, VOTE_2, VOTE_3);

    public static Vote getNew() {
        return new Vote(VOTE_1_ID + 3, DATE_TODAY, RESTAURANT_2);
    }

//    public static Vote getUpdated() {
//        return new Vote(VOTE_1_ID, "Планета чебуреков-2", DATE_TODAY, VOTE_1_ID);
//    }

    public static void assertMatch(Vote actual, Vote expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

    public static void assertMatch(VoteTo actual, VoteTo expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

    public static void assertMatch(Iterable<Vote> actual, Vote... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Vote> actual, Iterable<Vote> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }

    public static ResultMatcher contentJson(Vote... expected) {
        return contentJson(List.of(expected));
    }

    public static ResultMatcher contentJson(Iterable<Vote> expected) {
        return result -> assertThat(readListFromJsonMvcResult(result, Vote.class)).isEqualTo(expected);
    }
}
