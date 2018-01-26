package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.user.model.UserRoleModel;

@Repository
public interface UserRoleDao extends JpaRepository<UserRoleModel, Long>{

}
