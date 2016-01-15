package net.meshkorea.sample.contacts.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jihunlee on 2016. 1. 12..
 */
@Entity
@Table(name="AUTHORITIES")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users = new HashSet<User>();

    @ManyToMany(mappedBy = "authorities")
    private Set<Group> groups = new HashSet<Group>();

    public Authority(String name) {
        setName(name);
    }

    public Authority() {

    }

    public Set<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setName(String name) {
        this.name = name;
    }
}
