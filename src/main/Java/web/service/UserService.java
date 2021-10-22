package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void add(User user);
    User show(long id);
    void remove(long id);
    void update(long id, User user);
}
