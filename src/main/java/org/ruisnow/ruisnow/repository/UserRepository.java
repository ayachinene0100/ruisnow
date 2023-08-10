package org.ruisnow.ruisnow.repository;

import org.ruisnow.ruisnow.domain.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
