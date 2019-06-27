package com.cbrr.repository;

import com.cbrr.domain.MovieFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieFormatRepository extends JpaRepository<MovieFormat, Long> {
}
