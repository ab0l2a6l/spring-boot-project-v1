package com.example.springbootproject.repository;

import com.example.springbootproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Optional<T> findByNationalCode(long nationalCode);
    Optional<T> findByUsername(String username);
}
