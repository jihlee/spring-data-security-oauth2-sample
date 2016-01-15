package net.meshkorea.sample.contacts.domain.repository;

import net.meshkorea.sample.contacts.domain.entity.Authority;
import net.meshkorea.sample.contacts.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jihunlee on 2016. 1. 13..
 */
public interface AuthorityRepository extends
        CrudRepository<Authority, Long>
//        , RevisionRepository<Authority, Long, Integer>
{

    List<Authority> findByUsers(User user);

    List<Authority> findByGroups_Users(User user);

    Authority findByName(String name);
}
