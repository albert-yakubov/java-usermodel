package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
//todo 1 extend to Paging instead of crud
public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
    User findByUsername(String username);
//todo 5.2 adjust the repo to Pageable
    List<User> findByUsernameContainingIgnoreCase(String name,
                                                  Pageable pageable);
}
