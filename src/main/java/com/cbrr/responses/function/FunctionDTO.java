package com.cbrr.responses.function;

import com.cbrr.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FunctionDTO {

    private Long functionId;
    private User createdByUser;
    private User modifiedByUser;
    private Movie movieId;
    private Schedule scheduleId;
    private MovieFormat formatId;
    private Lounge loungeId;

}
