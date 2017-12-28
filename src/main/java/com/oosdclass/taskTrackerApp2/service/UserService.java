package com.oosdclass.taskTrackerApp2.service;

import com.oosdclass.taskTrackerApp2.model.User;

public interface UserService {

	public boolean isUserValid(User user);

	boolean isUserAdmin(User user);

	boolean doesUserExist(User user);
}
