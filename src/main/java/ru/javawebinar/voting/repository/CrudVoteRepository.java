package ru.javawebinar.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    Vote save(Vote item);

    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user JOIN FETCH v.restaurant WHERE v.id = ?1")
    Vote get(int id);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user JOIN FETCH v.restaurant")
    List<Vote> getAll();

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant WHERE v.datetime between ?1 and ?2")
    List<Vote> get(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT v FROM Vote v WHERE v.datetime=?1 AND v.user.id=?2")
    List<Vote> getByDateAndUser(LocalDateTime date, int id);
}
