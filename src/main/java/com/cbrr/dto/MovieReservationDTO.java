package com.cbrr.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieReservationDTO {

    private String movieName;
    private String format;
    private String schedule;
    private String seats;
    private String subTotal;
    private String remanente;
    private String granTotal;

}
