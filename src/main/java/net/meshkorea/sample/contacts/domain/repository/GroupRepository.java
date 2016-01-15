package net.meshkorea.sample.contacts.domain.repository;

import net.meshkorea.sample.contacts.domain.entity.Group;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jihunlee on 2016. 1. 12..
 */
public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
}
