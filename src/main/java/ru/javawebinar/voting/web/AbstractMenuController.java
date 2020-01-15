package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.voting.service.MenuService;
import ru.javawebinar.voting.to.MenuTo;

import java.time.LocalDate;
import java.util.List;

@Controller
public abstract class AbstractMenuController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService service;

    public List<MenuTo> get(LocalDate date) {
        log.info("get menu for date {}", date);
        return service.get(date);
    }
}