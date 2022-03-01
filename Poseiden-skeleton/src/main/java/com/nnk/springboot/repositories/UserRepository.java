package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path="users")
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
	
	@Query ("Select u FROM User u WHERE username = ?1")
	User findByUsername(String username);

}
