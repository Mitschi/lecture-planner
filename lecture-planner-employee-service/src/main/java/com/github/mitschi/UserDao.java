package com.github.mitschi;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    public User findByName(String name);
}
