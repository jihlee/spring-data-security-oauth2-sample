package net.meshkorea.sample.contacts.domain.repository;

import net.meshkorea.sample.contacts.domain.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jihunlee on 2016. 1. 12..
 */
public interface UserRepository extends
        PagingAndSortingRepository<User, Long>
//        , RevisionRepository<User, Long, Integer>
{

    User findOneByUsername(String username);
}
