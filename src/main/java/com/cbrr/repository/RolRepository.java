package com.cbrr.repository;

import com.cbrr.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol getRolByRolAk(String ak);

}
