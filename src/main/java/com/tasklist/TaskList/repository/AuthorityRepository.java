package com.tasklist.TaskList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasklist.TaskList.domain.Authorities;

public interface AuthorityRepository extends JpaRepository<Authorities, Long>{

}
