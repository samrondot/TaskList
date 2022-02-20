package com.tasklist.TaskList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tasklist.TaskList.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u"
			+ " left join fetch u.authorities"
			+ " where u.username = :username")
	User findByUsername(String username);

}
