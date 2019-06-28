package com.cbrr.repository;

import com.cbrr.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MovieReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(nativeQuery = true,
            value = "SELECT m.movie_name, mf.format_ak, s.schedule, r.seating, r.subtotal, r.balance_from_account, r.grand_total " +
                    "from movie_reservation r " +
                    "inner join movie m on r.movie_id = m.movie_id " +
                    "inner join schedule s on r.schedule_id = s.schedule_id " +
                    "inner join movie_format mf on r.movie_format_id = mf.format_id " +
                    "where r.user_id=:id")
    List<Object[]> retriveAllByUserId(@Param("id") Long id);

    @Transactional
    @Procedure(name = "insertReservation")
    Integer insertReservation(@Param("_movie_id") int movieId , @Param("_schedule_ak") String schedule, @Param("_movie_format_ak") String movieFormat , @Param("_user_id") int userId, @Param("_seating") Integer seating, @Param("_balance_from_account") BigDecimal balance, @Param("_grand_total") BigDecimal grandTotal, @Param("_subtotal") BigDecimal subtotal);

}
