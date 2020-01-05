package ru.javawebinar.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Dish;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {
//    @Query(name = Dish.ALL_SORTED)
//    List<Dish> findAll(@Param("userId") int userId);
//
//    @Transactional
//    @Modifying
//    @Query(name = Dish.DELETE)
//    int delete(@Param("id") int id, @Param("userId") int userId);
//
//    @Query(name = Dish.GET_BETWEEN)
//    List<Dish> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);
}
