package org.scaler.book_my_show_sept23morning.repositories;

import org.scaler.book_my_show_sept23morning.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User save(User entity);
}

// "Select * from users where email = "" ";