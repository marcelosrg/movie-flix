package io.github.marcelosrg.movieflix.repository;

import io.github.marcelosrg.movieflix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailAndName(String email, String name);
    Optional<UserDetails> findByEmail(String email);
}
