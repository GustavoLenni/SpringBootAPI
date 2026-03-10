package com.repositories;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// the class UserRepository have the methods of update,read,save,delete,create
// and others methods of my database
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
