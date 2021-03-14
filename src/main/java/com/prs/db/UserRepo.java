package com.prs.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.business.Request;
import com.prs.business.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);

	void save(Request r);

}
