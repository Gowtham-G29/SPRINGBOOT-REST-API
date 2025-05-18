package com.g_29.restWebservice.restful_web_service.repository;

import com.g_29.restWebservice.restful_web_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


}
