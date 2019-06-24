package com.cbrr.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationForm {

    private Long movieId;
    private Long scheduleId;
    private Long movieFormatId;
    private Long userId;
    private Integer seats;
    private BigDecimal amount;

}
