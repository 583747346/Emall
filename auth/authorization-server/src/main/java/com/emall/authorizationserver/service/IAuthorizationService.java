package com.emall.authorizationserver.service;

import javax.servlet.http.HttpServletRequest;

public interface IAuthorizationService {

    boolean auth(HttpServletRequest request, String url, String method);

}
