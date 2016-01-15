package net.meshkorea.sample.contacts.application.model;

/**
 * Created by jihunlee on 2016. 1. 14..
 */
public class GetUserRes {
    private final UserDto userDto;

    public GetUserRes(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }
}
