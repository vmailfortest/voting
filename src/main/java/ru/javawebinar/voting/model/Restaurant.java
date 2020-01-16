package ru.javawebinar.voting.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    protected List<Vote> votes;

    public Restaurant() {
    }

    public Restaurant(String name) {
        super(null, name);
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    protected List<Dish> dishes;

    public List<Vote> getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}