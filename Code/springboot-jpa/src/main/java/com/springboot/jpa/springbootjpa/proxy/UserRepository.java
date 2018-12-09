package com.springboot.jpa.springbootjpa.proxy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.springbootjpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
