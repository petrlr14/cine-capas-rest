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
    private String scheduleAk;
    private String movieFormatAk;
    private Integer seats;
    private Double subtotal;
    private Double saldoRemanente;
    private Double grandTotal;

}
