package edu.spring.boot.api.users.repository;

import edu.spring.boot.api.users.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
