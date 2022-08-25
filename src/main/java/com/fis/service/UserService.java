package com.fis.service;

import com.fis.dto.User;

public interface UserService {

    String getUserData();
    String getUserDataFromExternal();


    byte[] generateAndGetQrCode(User user, int width, int height);
}
