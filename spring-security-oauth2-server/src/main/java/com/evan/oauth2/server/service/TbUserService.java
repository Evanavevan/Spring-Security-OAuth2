package com.evan.oauth2.server.service;

import com.evan.oauth2.server.domain.TbUser;

public interface TbUserService {
    default TbUser getUserByUsername(String username) {
        return null;
    }
}
