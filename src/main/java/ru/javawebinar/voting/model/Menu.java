package ru.javawebinar.voting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class Menu extends AbstractBaseEntity {

    @Column(name = "datetime", nullable = false)
    private String datetime;

}
