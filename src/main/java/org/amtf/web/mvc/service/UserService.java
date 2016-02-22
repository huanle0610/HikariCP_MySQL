package org.amtf.web.mvc.service;

import org.amtf.web.mvc.model.User;

import java.util.List;

/**
 * Created by huanle0610 on 2016/2/23.
 */
public interface UserService {
    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(User user);
}
