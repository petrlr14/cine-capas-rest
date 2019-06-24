package com.cbrr.responses.token;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@JsonSerialize
@AllArgsConstructor
@Data
public class BadToken {

    private HttpStatus status;
    private String msg="";

}
