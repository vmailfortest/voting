package ru.javawebinar.voting.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.javawebinar.voting.RestaurantTestData;
import ru.javawebinar.voting.model.Restaurant;
import ru.javawebinar.voting.service.RestaurantService;
import ru.javawebinar.voting.web.json.JsonUtil;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javawebinar.voting.RestaurantTestData.*;
import static ru.javawebinar.voting.TestUtil.readFromJson;
import static ru.javawebinar.voting.TestUtil.readFromJsonMvcResult;

public class RestaurantRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantRestController.REST_URL + '/';

    @Autowired
    private RestaurantService restaurantService;

    @Test
    void createWithLocation() throws Exception {
        Restaurant newRestaurant = RestaurantTestData.getNew();
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newRestaurant)) );
//                .with(userAuth(USER)));

        Restaurant created = readFromJson(action, Restaurant.class);
        Integer newId = created.getId();
        newRestaurant.setId(newId);
        assertMatch(created, newRestaurant);
        assertMatch(restaurantService.get(newId, 0), newRestaurant);
    }

    @Test
    void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL + RESTAURANT_1_ID))
//                .with(userAuth(USER)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readFromJsonMvcResult(result, Restaurant.class), RESTAURANT_1));
    }
}
