package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO UserDAO;

    @Autowired
    public UserServiceImpl(UserDAO UserDAO) {
        this.UserDAO = UserDAO;

//        add some data to our empty table
        UserDAO.addUser(new User("Petr", "Pervy", 40));
        UserDAO.addUser(new User("Ioann", "Grozny", 35));
        UserDAO.addUser(new User("Nikolay", "Vtoroy", 41));
        UserDAO.addUser(new User("Alexandr", "Tretiy", 30));
    }

    @Override
    public void addUser(User user) {
        UserDAO.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return UserDAO.getUserById(id);
    }

    @Override
    public void updateUserById(Long id, User user) {
        UserDAO.updateUserById(id, user);
    }

    @Override
    public void deleteUserById(Long id) {
        UserDAO.deleteUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return UserDAO.getAllUsers();
    }
}