package com.fis.controller;

import com.fis.dto.User;
import com.fis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

@Controller
public class HomeController {


    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping("/name")
    public ModelAndView namePage() {
        ModelAndView modelAndView = new ModelAndView("name");
        return modelAndView;
    }
    @GetMapping("/contact")
    public ModelAndView contactPage() {
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/sendMessage")
    public ModelAndView userContactMessage(User user) {
        ModelAndView modelAndView = new ModelAndView("responsePage");
        modelAndView.addObject("response", user.toString());
        return modelAndView;
    }

    @RequestMapping("/QRCodePage")
    public ModelAndView qrCodePage() {
        ModelAndView modelAndView = new ModelAndView("qrCodeGeneratorPage");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/getQrCode")
    public ModelAndView getQrCode(User user, @RequestParam(value = "width", defaultValue = "100") String width,
                                  @RequestParam(value = "height", defaultValue = "200") String height) {
        ModelAndView modelAndView = new ModelAndView("responsePage");
        try {
            byte[] bytArray = userService.generateAndGetQrCode(user, Integer.parseInt(width), Integer.parseInt(height));

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytArray);
            BufferedImage image = ImageIO.read(byteArrayInputStream);

            String absolutePath = ".//src//main//java//com//fis//res//QRCode"+ Calendar.getInstance().getTimeInMillis() +".png";
            File file = new File(absolutePath);
            ImageIO.write(image, "png", file);
            modelAndView.addObject("response",file.getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        return modelAndView;
    }
}
