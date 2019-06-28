package com.cbrr.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FunctionDTO {

    private Long functionId;
    private Long loungeId;
    private String format;
    private Double price;
    private String schedule;
    private Integer seats;

}
