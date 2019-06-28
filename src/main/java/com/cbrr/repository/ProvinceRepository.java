package com.cbrr.repository;

import com.cbrr.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, Long> {

    @Query(value = "SELECT p.state_id, p.province_name, p.province_ak from province as p inner join state as s on s.state_id=p.state_id WHERE s.state_ak=:id", nativeQuery = true)
    List<Object[]> getProvinceDTO(@Param("id") String id);

}
