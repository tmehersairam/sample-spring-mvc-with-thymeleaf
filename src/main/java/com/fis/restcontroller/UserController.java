package com.fis.restcontroller;

import com.fis.dto.User;
import com.fis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/internalUser")
    public String internalUserData() {
        return userService.getUserData();
    }


    @GetMapping("/externalUser")
    public String externalUserData() {
        return userService.getUserDataFromExternal();
    }


}
