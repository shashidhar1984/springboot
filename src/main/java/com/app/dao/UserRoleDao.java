package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.user.model.UserRoleModel;

public interface UserRoleDao extends JpaRepository<UserRoleModel, Long>{

}
