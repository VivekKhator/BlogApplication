package com.spring.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.blogapp.entities.User;



public interface UserRepository extends JpaRepository<User, Integer>{

}
