package com.app.service;

import com.app.user.model.UserModel;

public interface UserService {
	void save(UserModel user);

	UserModel findByUsername(String username);

}
