package com.stackroute.SoulmateRestServiceDemo.service;

import com.stackroute.SoulmateRestServiceDemo.model.User;
import com.stackroute.SoulmateRestServiceDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) throws Exception {
        Optional<User> userDB=this.userRepository.findById(id);
        if(userDB.isPresent()){
            this.userRepository.delete(userDB.get());
        }else{
            throw new Exception("user not found");
        }
    }

    @Override
    public User updateUser(User user) throws Exception {
    Optional<User> userDB =this.userRepository.findById(user.getId());
    if(userDB.isPresent()) {
        User userUpdate = userDB.get();
        userUpdate.setId(user.getId());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setGender(user.getGender());
        userUpdate.setAge(user.getAge());
        userRepository.save(userUpdate);
        return userUpdate;
    }else{
        throw new Exception("Record not found with given id");
    }

    }

    @Override
    public User getUserById(int id) throws Exception {
        Optional<User> userDB =this.userRepository.findById(id);
        if(userDB.isPresent()){
            return userDB.get();
        }else{
            throw new Exception("User is not found");
        }

    }

    @Override
    public List<User> getAllByGender(String gender) {
        return userRepository.getAllUserByGender(gender);
    }

    @Override
    public List<User> searchByName(String firstName) {
        return userRepository.getAllUserByName(firstName);
    }

    @Override
    public List<User> searchByAge(int age) {
        return userRepository.getAllUserByAge(age);
    }
}
