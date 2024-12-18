package org.ashar.Service;

import org.ashar.DAO.UserDao;
import org.ashar.Entity.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public boolean registerUser(User user){
        if (user==null){
            throw new RuntimeException("Bad request");
        }
        if (user.getEmail()==null || user.getEmail().isBlank() || user.getUsername()==null || user.getUsername().isBlank()
                || user.getPassword()==null || user.getPassword().isBlank()){
            throw new RuntimeException("Please fill all the details");
        }
        if (userDao.get(user.getEmail())!=null || userDao.findByUsername(user.getUsername())!=null) throw new RuntimeException("User with same email/username already exists.");
        return userDao.save(user) != null;
    }

    public List<User> getAllUsers(){
        return userDao.get();
    }

    public User getUser(String email){
        if (email==null || email.isBlank()){
            throw new RuntimeException("No user found");
        }
        return userDao.get(email);
    }

    public boolean deleteUser(String email){
        if (email==null || !email.isBlank()){
            throw new RuntimeException("No user found");
        }
        if (userDao.get(email)==null) throw new RuntimeException("No user found");
        try {
            userDao.delete(email);
        }catch (RuntimeException e){
            return false;
        }
        return true;
    }

    public boolean login(String email, String password){
        if (email==null || email.isBlank()|| password==null || password.isBlank()){
            throw new RuntimeException("Wrong email/password");
        }
        User user = userDao.get(email);
        if (user==null){
            return false;
        }
        return user.getPassword().equals(password);
    }

    public boolean usernameAlreadyExists(String username){
        if (username==null || username.isBlank()) throw new RuntimeException("Username cannot be empty.");
        return userDao.findByUsername(username) == null;
    }
}