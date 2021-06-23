package com.stackroute.SoulmateRestServiceDemo.service;

import com.stackroute.SoulmateRestServiceDemo.model.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    List<User> getAllUser();
    public void deleteUser(int id) throws Exception;
    User updateUser(User user) throws Exception;
    User getUserById(int id) throws Exception;
   List<User> getAllByGender(String gender);
    List<User> searchByName(String firstName);
    List<User> searchByAge(int age);


}
