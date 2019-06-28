package com.cbrr.repository;

import com.cbrr.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StateRepository  extends JpaRepository<State, Long> {

    @Query(value = "SELECT s.state_id, s.state_name, s.state_ak from state as s inner join country as c on c.country_id=s.country_id WHERE country_ak=:id", nativeQuery = true)
    List<Object[]> getStateDTO(@Param("id") String id);

}
