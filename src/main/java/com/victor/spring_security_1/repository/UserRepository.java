package com.victor.spring_security_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.spring_security_1.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
