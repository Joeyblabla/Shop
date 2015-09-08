package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.UserDao;
import test.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao dao;
    
    public List<User> getUsers() {
        return dao.getAllUser();
    }
    
    public void getUserById(int id) {
        String sql = "select * from USER where id = " + id;
        dao.getUserBySQL(sql);
    }
}
