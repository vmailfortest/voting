package ru.javawebinar.voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Vote;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class VoteRepository {

    @Autowired
    private CrudVoteRepository crudRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Transactional
    public Vote save(Vote vote, int userId) {
//        if (get(vote.getId()).getDate() >= LocalTime.of(11, 00)) {
//            return null;
//        }
        vote.setUser(crudUserRepository.getOne(userId));
        return crudRepository.save(vote);
    }

    public Vote get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    public List<Vote> getAll() {
        return crudRepository.findAll();
    }

    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }
}
