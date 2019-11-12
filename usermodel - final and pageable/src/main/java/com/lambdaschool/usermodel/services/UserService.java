package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.view.UserNameCountEmails;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService
{
    //todo 3 add Pageable param
    List<User> findAll(Pageable pageable);
//todo 5.1 add it to service
    List<User> findByNameContaining(String username,
                                    Pageable pageable);

    User findUserById(long id);

    User findByName(String name);

    void delete(long id);

    User save(User user);

    User update(User user,
                long id);

    void deleteUserRole(long userid,
                        long roleid);

    void addUserRole(long userid,
                     long roleid);

    List<UserNameCountEmails> getCountUserEmails();
}