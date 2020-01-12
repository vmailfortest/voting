package ru.javawebinar.voting.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.javawebinar.voting.VoteTestData;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.service.VoteService;
import ru.javawebinar.voting.web.json.JsonUtil;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static ru.javawebinar.voting.TestUtil.*;
import static ru.javawebinar.voting.UserTestData.USER;
import static ru.javawebinar.voting.VoteTestData.assertMatch;

public class VoteRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = VoteRestController.REST_URL + '/';

    @Autowired
    private VoteService voteService;

    @Test
    void createWithLocation() throws Exception {
        Vote newVote = VoteTestData.getNew();
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newVote))
                .with(userAuth(USER)));

        Vote created = readFromJson(action, Vote.class);
        Integer newId = created.getId();
        newVote.setId(newId);
        assertMatch(created, newVote);
        assertMatch(voteService.get(newId), newVote);
    }

//    @Test
//    void get() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL + RESTAURANT_1_ID)
//                .with(userAuth(USER)))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(result -> assertMatch(readFromJsonMvcResult(result, Vote.class), RESTAURANT_1));
//    }

//    @Test
//    void getAll() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL)
//                .with(userAuth(USER)))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(contentJson(RESTAURANTS));
//    }

//    @Test
//    void delete() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.delete(REST_URL + RESTAURANT_1_ID)
//                .with(userAuth(USER)))
//                .andExpect(status().isNoContent());
//
//        assertThrows(NotFoundException.class, () -> voteService.get(RESTAURANT_1_ID, 0));
//    }

//    @Test
//    void update() throws Exception {
//        Vote updated = VoteTestData.getUpdated();
//        mockMvc.perform(MockMvcRequestBuilders.put(REST_URL + RESTAURANT_1_ID)
//                .contentType(MediaType.APPLICATION_JSON)
//                .with(userHttpBasic(USER))
//                .content(JsonUtil.writeValue(updated)))
//                .andExpect(status().isNoContent());
//
//        assertMatch(voteService.get(RESTAURANT_1_ID, 0), updated);
//    }
//
//    @Test
//    void getUnAuth() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL + RESTAURANT_1_ID))
//                .andExpect(status().isUnauthorized());
//    }
}
