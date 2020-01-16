package ru.javawebinar.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javawebinar.voting.model.Vote;
import ru.javawebinar.voting.service.VoteService;
import ru.javawebinar.voting.to.VoteTo;
import ru.javawebinar.voting.util.SecurityUtil;
import ru.javawebinar.voting.util.VotesUtil;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    static final String REST_URL = "/rest/profile/votes";

    @Autowired
    private VoteService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> createWithLocation(@RequestBody VoteTo voteTo) {
        log.info("create vote {}", voteTo);

        int userId = SecurityUtil.authUserId();
        Vote created = service.create(VotesUtil.createNewFromTo(voteTo), userId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping("/{id}")
    public VoteTo get(@PathVariable int id) {
        log.info("get vote {}", id);
        return VotesUtil.createTo(service.get(id));
    }

    @GetMapping
    public List<VoteTo> getAll() {
        return VotesUtil.createTos(service.getAll());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody VoteTo voteTo, @PathVariable int id) {
        log.info("update vote {}", voteTo);

        int userId = SecurityUtil.authUserId();
        var voteUser = get(id).getUser();
        Assert.isTrue(userId == voteUser, "Trying to update vote of other user");
        voteTo.setId(id);

        service.update(VotesUtil.createNewFromTo(voteTo), userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete vote {}", id);
        service.delete(id);
    }
}
