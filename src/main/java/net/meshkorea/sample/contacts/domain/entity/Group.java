package net.meshkorea.sample.contacts.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jihunlee on 2016. 1. 13..
 */
@Entity
@Table(name="GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<Authority>();

    @ManyToMany
    private Set<User> users = new HashSet<User>();
}
