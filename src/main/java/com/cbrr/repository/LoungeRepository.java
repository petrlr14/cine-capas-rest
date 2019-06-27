package com.cbrr.repository;

import com.cbrr.domain.Lounge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoungeRepository extends JpaRepository<Lounge, Long> {

}
