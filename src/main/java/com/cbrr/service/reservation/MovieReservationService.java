package com.cbrr.service.reservation;

import com.cbrr.dto.MovieReservationDTO;
import com.cbrr.request.ReservationForm;

import java.util.List;

public interface MovieReservationService {

    List<MovieReservationDTO> getReservationsByUser(Long id);
    Integer insertReservation(ReservationForm reservationForm, Long id);
}
