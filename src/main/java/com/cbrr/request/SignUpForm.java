package com.cbrr.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String birthday;
    private String address;
    private String country;
    private String state;
    private String province;
}
