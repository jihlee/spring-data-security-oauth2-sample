package net.meshkorea.sample.contacts.application.controller;

import net.meshkorea.sample.contacts.application.model.GetUserRes;
import net.meshkorea.sample.contacts.application.model.UserDto;
import net.meshkorea.sample.contacts.domain.entity.User;
import net.meshkorea.sample.contacts.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jihunlee on 2016. 1. 14..
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/getuser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetUserRes getUser(@Param("id") long id) {
        User user = userRepository.findOne(id);

        UserDto userDto = new UserDto(user.getUsername(), user.getName(), user.getEmail());

        return new GetUserRes(userDto);
//        return userDto.getName();
    }
}
