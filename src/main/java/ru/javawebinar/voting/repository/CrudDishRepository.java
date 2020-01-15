package ru.javawebinar.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Dish;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {

    @Override
    @Transactional
    Dish save(Dish item);

    @Modifying
    @Transactional
    @Query("DELETE FROM Dish r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.id = ?1")
    Dish get(int id);

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.datetime = ?1")
    List<Dish> get(LocalDate date);
}
