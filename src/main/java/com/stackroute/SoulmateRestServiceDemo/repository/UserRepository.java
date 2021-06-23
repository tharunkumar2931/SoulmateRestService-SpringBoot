package com.stackroute.SoulmateRestServiceDemo.repository;


import com.stackroute.SoulmateRestServiceDemo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("FROM User WHERE firstName=:firstname")
    List<User> getAllUserByName(@Param("firstname") String firstName);

@Query("FROM User WHERE gender=:gender")
    List<User> getAllUserByGender(@Param("gender") String gender);

@Query("FROM User WHERE age=:age")
    List<User> getAllUserByAge(@Param("age") int age);
}

