package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.user.model.UserModel;

public interface UserDao extends JpaRepository<UserModel, Long> {
	UserModel findByUsername(String username);
}
