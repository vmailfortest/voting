package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.service.VoteService;
import ru.javawebinar.voting.util.SecurityUtil;

import java.util.List;

@Controller
public abstract class AbstractVoteController {
    private static final Logger log = LoggerFactory.getLogger(VoteRestController.class);

    @Autowired
    private VoteService service;

    public Vote create(Vote vote) {
        int userId = SecurityUtil.authUserId();
        log.info("create vote {}", vote);
        return service.create(vote, userId);
    }

    public Vote get(int id) {
        log.info("get vote {}", id);
        return service.get(id);
    }

    public List<Vote> getAll() {
        return service.getAll();
    }

    public void update(Vote vote, int id) {
        int userId = SecurityUtil.authUserId();
        log.info("update vote {}", vote);
        service.update(vote, userId);
    }

    public void delete(int id) {
        log.info("delete vote {}", id);
        service.delete(id);
    }
}