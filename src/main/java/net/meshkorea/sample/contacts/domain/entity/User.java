package net.meshkorea.sample.contacts.domain.entity;

import net.meshkorea.sample.contacts.domain.valueobject.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jihunlee on 2016. 1. 12..
 */
@Entity
@Table(name = "USERS")
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;


    private String firstName;
    private String lastName;
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<Authority>();

    @ManyToMany(mappedBy = "users")
    private Set<Group> groups = new HashSet<Group>();
    private String name;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
