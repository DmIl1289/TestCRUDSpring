package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        TypedQuery<User> users = entityManager.createQuery("from User", User.class);
        return users.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show (long id) {
        return (User) entityManager.createQuery("from User where id= :ID")
                .setParameter("ID", id).getSingleResult();
    }

    @Override
    public void remove(long id) {
        entityManager.createQuery("delete User where id=:ID")
                .setParameter("ID", id).executeUpdate();
    }

    @Override
    public void update(long id, User user) {
        entityManager.createQuery("update User set name=:name1, surName=:surname1, email=:email1 where id=:ID")
                .setParameter("ID", id)
                .setParameter("name1", user.getName())
                .setParameter("surname1", user.getSurName())
                .setParameter("email1", user.getEmail())
                .executeUpdate();
    }
}
