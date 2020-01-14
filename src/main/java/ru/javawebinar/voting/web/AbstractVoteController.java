package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.service.VoteService;
import ru.javawebinar.voting.to.VoteTo;
import ru.javawebinar.voting.util.SecurityUtil;
import ru.javawebinar.voting.util.VotesUtil;

import java.util.List;

@Controller
public abstract class AbstractVoteController {
    private static final Logger log = LoggerFactory.getLogger(VoteRestController.class);

    @Autowired
    private VoteService service;

    public Vote create(VoteTo voteTo) {
        int userId = SecurityUtil.authUserId();
        log.info("create vote {}", voteTo);
        return service.create(VotesUtil.createNewFromTo(voteTo), userId);
    }

    public VoteTo get(int id) {
        log.info("get vote {}", id);
        return VotesUtil.createTo(service.get(id));
    }

    public List<VoteTo> getAll() {
        return VotesUtil.createTos(service.getAll());
    }

    public void update(VoteTo voteTo) {
        int userId = SecurityUtil.authUserId();
        log.info("update vote {}", voteTo);
        service.update(VotesUtil.createNewFromTo(voteTo), userId);
    }

    public void delete(int id) {
        log.info("delete vote {}", id);
        service.delete(id);
    }
}