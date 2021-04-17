package com.example.CrudSpringApplication;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//Pass in user class and type of primary key
public interface UserRepository extends CrudRepository<User, Integer> {
	//Query the database
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getByUsername(@Param("username") String username);

}
