package com.cbrr.service.reservation;

import com.cbrr.dto.MovieReservationDTO;
import com.cbrr.repository.MovieReservationRepository;
import com.cbrr.request.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieReservationServiceImpl implements MovieReservationService {

    @Autowired
    MovieReservationRepository movieReservationRepository;

    @Override
    public List<MovieReservationDTO> getReservationsByUser(Long id) {
        return movieReservationRepository.retriveAllByUserId(id)
                .stream()
                .map(objects -> MovieReservationDTO
                        .builder()
                        .movieName(objects[0].toString())
                        .format(objects[1].toString())
                        .schedule(objects[2].toString())
                        .seats(objects[3].toString())
                        .subTotal(objects[4].toString())
                        .remanente(objects[5].toString())
                        .granTotal(objects[6].toString())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public Integer insertReservation(ReservationForm reservationForm, Long id) {
        return movieReservationRepository.insertReservation(Integer.parseInt(reservationForm.getMovieId()+""), reservationForm.getScheduleAk(), reservationForm.getMovieFormatAk(), Integer.parseInt(id+""), reservationForm.getSeats(), new BigDecimal(reservationForm.getSaldoRemanente()), new BigDecimal(reservationForm.getGrandTotal()), new BigDecimal(reservationForm.getSubtotal()));
    }
}
