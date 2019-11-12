package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.views.UserNameCountEmails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);

    List<User> findByUsernameContainingIgnoreCase(String name);

   @Query(value = "SELECT u.username as usernamerpt, count(ue.useremailid) as countemails\n FROM users u JOIN useremails ue\n ON u.userid = ue.userid\n GROUP BY u.username", nativeQuery = true)
    List<UserNameCountEmails> getCountUserEmeails();
}
