package com.cbrr.repository;

import com.cbrr.domain.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Long> {

/*    @Query(nativeQuery = true, value = "select com.cbrr,request.FunctionForm(movie_id) from function")
    List<FunctionForm> retrieveAll();*/
    List<Function> findAllByMovieId(Long id);

}
