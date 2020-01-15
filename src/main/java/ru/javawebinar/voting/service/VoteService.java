package ru.javawebinar.voting.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.repository.VoteRepository;

import java.time.LocalTime;
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
        Assert.isTrue(repository.getByDateAndUser(vote.getDate(), userId).size() == 0, "Vote for user/date already exists");
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
        Assert.isTrue(vote.getDate().toLocalTime().compareTo(LocalTime.of(11, 00, 00)) <= 0, "Vote can be changed before 11:00");
        repository.save(vote, userId);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }
}