package com.fis.service;

import com.fis.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    public String getUserData() {
        return "Hello from INTERNAL User ";
    }

    public String getUserDataFromExternal() {
        String externalUserData = restTemplate.getForObject("http://localhost:8082/externalUser/", String.class);
        return externalUserData;
    }

    @Override
    public byte[] generateAndGetQrCode(User user, int width, int height) {

    Map<String, Object> map = new HashMap<>();
    map.put("contents",user.toString());
    map.put("width", width);
    map.put("height", height);

        byte[] qrCode = restTemplate.getForObject("http://localhost:8082/QRCode/contents/{contents}/width/{width}/height/{height}",byte[].class, map);
        return qrCode ;
    }
}
