package com.cbrr.repository;

import com.cbrr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Procedure(name = "logInUser")
    void loginUser(@Param("_user_id") int userId);

    @Transactional
    @Procedure(name = "logOutUser")
    Integer logOutUser(@Param("_user_name") String username);

    public User findByUsernameAndPassWord(String username, String password);
    public User findByUsername(String username);

}
