package com.estudos.microservice.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.microservice.hruser.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
