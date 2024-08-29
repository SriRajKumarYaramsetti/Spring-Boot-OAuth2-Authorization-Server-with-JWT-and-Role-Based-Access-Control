package com.SriRaj.AutherzationServer.Repository;

import com.SriRaj.AutherzationServer.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
