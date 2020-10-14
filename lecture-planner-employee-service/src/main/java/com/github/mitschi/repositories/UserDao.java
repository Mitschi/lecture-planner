package com.github.mitschi.repositories;


import com.github.mitschi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    public User findByName(String name);
}
