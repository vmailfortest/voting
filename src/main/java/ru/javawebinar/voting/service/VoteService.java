package ru.javawebinar.voting.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.javawebinar.voting.model.Dish;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.repository.DishRepository;
import ru.javawebinar.voting.repository.VoteRepository;

import java.util.List;

import static ru.javawebinar.voting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote create(Vote vote, int userId) {
        Assert.notNull(vote, "vote must not be null");
        return repository.save(vote, userId);
    }

//    @Transactional
    public Vote get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Vote> getAll() {
        return repository.getAll();
    }

    public void update(Vote vote, int userId) {
        Assert.notNull(vote, "vote must not be null");
        checkNotFoundWithId(repository.save(vote, userId), vote.getId());
        repository.save(vote, userId);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }
}