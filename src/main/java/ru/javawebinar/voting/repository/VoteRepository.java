package ru.javawebinar.voting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.util.DateTimeUtil;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class VoteRepository {

    @Autowired
    private CrudVoteRepository crudRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Transactional
    public Vote save(Vote vote, int userId) {
        vote.setUser(crudUserRepository.getOne(userId));
        return crudRepository.save(vote);
    }

    @Transactional
    public Vote get(int id) {
        return crudRepository.get(id);
    }

    public List<Vote> get(LocalDate date) {
        return crudRepository.get(DateTimeUtil.getStartInclusive(date), DateTimeUtil.getEndExclusive(date));
    }

    public List<Vote> getAll() {
        return crudRepository.getAll();
    }

    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

//    public Vote getWithUser(int id, int userId) {
//        return crudRepository.getWithUser(id, userId);
//    }
}
