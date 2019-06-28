package com.cbrr.repository;

import com.cbrr.domain.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Long> {

    @Query(nativeQuery = true,
    value = "SELECT f.function_id, l.lounge_id, mf.format_ak, s.schedule, f.seats, mf.price " +
            "from function f " +
            "inner join lounge l " +
            "on f.lounge_id = l.lounge_id " +
            "inner join movie_format mf " +
            "on f.format_id = mf.format_id " +
            "inner join schedule s " +
            "on f.schedule_id = s.schedule_id where f.movie_id=:id")
    List<Object[]> retrieveAllByMovieId(@Param("id") Long id);
    List<Function> findAllByMovieId(Long id);

}
