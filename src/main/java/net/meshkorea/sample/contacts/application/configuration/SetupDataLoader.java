package net.meshkorea.sample.contacts.application.configuration;

import net.meshkorea.sample.contacts.domain.entity.Authority;
import net.meshkorea.sample.contacts.domain.entity.User;
import net.meshkorea.sample.contacts.domain.repository.AuthorityRepository;
import net.meshkorea.sample.contacts.domain.repository.GroupRepository;
import net.meshkorea.sample.contacts.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by jihunlee on 2016. 1. 14..
 */
@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

//        // == create initial privileges
        final Authority readPrivilege = createAuthorityIfNotFound("READ_PRIVILEGE");
        final Authority writePrivilege = createAuthorityIfNotFound("WRITE_PRIVILEGE");
//
//        // == create initial roles
//        final List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
//        createRoleIfNotFound("ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

//        final Authority adminRole = groupRepository.findByName("ROLE_ADMIN");
        final User user = createUserIfNotFound("sanjay", "gupta", "Sanjay", "Gupta", "sanjay.gupta@gupta.com");


        Set<Authority> authorities = new HashSet<>();
        authorities.add(readPrivilege);
        user.setAuthorities(authorities);
        user.setEnabled(true);
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    private final Authority createAuthorityIfNotFound(final String name) {
        Authority authority = authorityRepository.findByName(name);
        if (authority == null) {
            authority = new Authority(name);
            authorityRepository.save(authority);
        }
        return authority;
    }

    private final User createUserIfNotFound(final String username, final String password, final String firstName,
                                            final String lastName, final String email) {
        User user = userRepository.findOneByUsername(username);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            user.setEmail(email);
            userRepository.save(user);
        }
        return user;

    }

//    @Transactional
//    private final Group createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
//        Role role = groupRepository.findByName(name);
//        if (role == null) {
//            role = new Role(name);
//            role.setPrivileges(privileges);
//            groupRepository.save(role);
//        }
//        return role;
//    }

}