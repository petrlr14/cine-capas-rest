package com.cbrr.repository;

import com.cbrr.domain.Rol;
import com.cbrr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Procedure(name = "logInUser")
    void loginUser(@Param("_user_id") int userId);

    @Transactional
    @Procedure(name = "logOutUser")
    Integer logOutUser(@Param("_user_name") String username);

    @Transactional
    @Procedure(name = "deactivateUser")
    Integer deactivateUser(@Param("_user_id") int id, @Param("_cause") String cause);

    @Transactional
    @Procedure(name = "activeUser")
    Integer activeUser(@Param("_user_id") int id);

    @Transactional
    @Procedure(name = "register")
    Integer register(
            @Param("fname") String fname,
            @Param("lname") String lname,
            @Param("username") String username,
            @Param("password") String password,
            @Param("birthday") Date bday,
            @Param("address") String address,
            @Param("country") String contry,
            @Param("state") String state,
            @Param("province") String province);

    User findByUsernameAndPassWord(String username, String password);

    User findByUsername(String username);

    List<User> findAllByRolId(Rol rol);

}
