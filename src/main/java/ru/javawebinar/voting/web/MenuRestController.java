package ru.javawebinar.voting.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Menu;
import ru.javawebinar.voting.to.DishTo;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MenuRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuRestController extends AbstractMenuController {

    static final String REST_URL = "/rest/profile/menus";

    @Override
    @GetMapping("/{date}")
    public List<Menu> get(@PathVariable LocalDate date) {
        return super.get(date);
    }
}
