package com.cbrr.responses.reservation;

import com.cbrr.domain.MovieFormat;
import com.cbrr.domain.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationFormInflater {

    private List<MovieFormat> formats;
    private List<Schedule> schedules;
    private BigDecimal balance;
    private Integer seat;

}
