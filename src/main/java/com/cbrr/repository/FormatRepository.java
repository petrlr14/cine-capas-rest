package com.cbrr.repository;

import com.cbrr.domain.MovieFormat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormatRepository extends JpaRepository<MovieFormat, Long> {


}
