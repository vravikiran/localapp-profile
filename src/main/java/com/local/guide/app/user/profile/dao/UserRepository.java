package com.local.guide.app.user.profile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.guide.app.user.profile.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
