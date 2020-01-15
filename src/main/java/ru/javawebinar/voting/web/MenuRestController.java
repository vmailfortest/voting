package ru.javawebinar.voting.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javawebinar.voting.to.MenuTo;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MenuRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuRestController extends AbstractMenuController {

    static final String REST_URL = "/rest/profile/menus";

    @Override
    @GetMapping("/{date}")
    public List<MenuTo> get(@PathVariable LocalDate date) {
        return super.get(date);
    }
}