package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void updateUserById(Long id, User user) {
        User u = getUserById(id);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setAge(user.getAge());
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}