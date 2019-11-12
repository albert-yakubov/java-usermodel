package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.views.UserNameCountEmails;

import java.util.ArrayList;
import java.util.List;

public interface UserService
{
    List<User> findAll();

    List<User> findByNameContaining(String username);

    User findUserById(long id);

    User findByName(String name);

    void delete(long id);

    User save(User user);

    User update(User user,
                long id);

    //still getting the emnails
    List<UserNameCountEmails> getCountUserEmails();

    // void deleteUserRole(long userid,
    //                     long roleid);

    // void addUserRole(long userid,
    //                 long roleid);

}