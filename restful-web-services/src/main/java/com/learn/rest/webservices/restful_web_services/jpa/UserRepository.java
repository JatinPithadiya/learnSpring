package com.learn.rest.webservices.restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.rest.webservices.restful_web_services.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
