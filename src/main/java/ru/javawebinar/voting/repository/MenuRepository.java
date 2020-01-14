package ru.javawebinar.voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Menu;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MenuRepository {

    @Autowired
    private CrudMenuRepository crudRepository;

    public List<Menu> get(LocalDate date) {
        return crudRepository.get(date);
    }
}
