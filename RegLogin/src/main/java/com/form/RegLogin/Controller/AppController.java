package com.form.RegLogin.Controller;

import com.form.RegLogin.Data.Entity.User;
import com.form.RegLogin.Data.Repository.UserRepository;
import com.form.RegLogin.Service.UserServices;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Controller
public class AppController {

    @Autowired
    private UserServices service;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "signup_form";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @PostMapping("/process_register")
    public String processRegister(User user, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        service.register(user, getSiteURL(request));
        return "register_success";
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (service.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }


    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }



}
