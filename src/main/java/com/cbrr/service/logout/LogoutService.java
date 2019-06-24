package com.cbrr.service.logout;

import com.cbrr.responses.auth.LogoutResponse;

import javax.servlet.http.HttpServletRequest;

public interface LogoutService {

    LogoutResponse performLogout(HttpServletRequest request);

}
