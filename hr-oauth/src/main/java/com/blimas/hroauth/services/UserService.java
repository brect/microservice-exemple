package com.blimas.hroauth.services;

import com.blimas.hroauth.entities.User;
import com.blimas.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("E-mail not found: " + email);
            throw new IllegalArgumentException("E-mail not found");
        }
        logger.error("E-mail found: " + email);
        return user;
    }

}
