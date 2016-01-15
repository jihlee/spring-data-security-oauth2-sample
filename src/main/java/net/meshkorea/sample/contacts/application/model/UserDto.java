package net.meshkorea.sample.contacts.application.model;

/**
 * Created by jihunlee on 2016. 1. 14..
 */
public class UserDto {

    private final String username;
    private final String name;
    private final String email;

    public UserDto(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
