package ru.javawebinar.voting.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Menu;
import ru.javawebinar.voting.repository.DishRepository;
import ru.javawebinar.voting.repository.MenuRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.javawebinar.voting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<Menu> get(LocalDate date) {
        return repository.get(date);
    }
}