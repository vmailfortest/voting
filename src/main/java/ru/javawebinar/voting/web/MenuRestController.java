package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javawebinar.voting.service.MenuService;
import ru.javawebinar.voting.to.MenuTo;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MenuRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    static final String REST_URL = "/rest/profile/menus";

    @Autowired
    private MenuService service;

    @GetMapping("/{date}")
    public List<MenuTo> get(@PathVariable LocalDate date) {
        log.info("get menu for date {}", date);
        return service.get(date);
    }
}