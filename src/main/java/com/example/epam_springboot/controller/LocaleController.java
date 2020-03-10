package com.example.epam_springboot.controller;

import com.example.epam_springboot.entity.User;
import com.example.epam_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class LocaleController {

    private final UserService userService;

    @Autowired
    public LocaleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/locales")
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/locale", params = "eng", method = RequestMethod.POST)
    public String engLocale(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<User> users =userService.findAll();
        model.addAttribute("users", users);
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString("en"));
        model.addAttribute("locale", "en");
        return "users";
    }

    @RequestMapping(value = "/locale", params = "ru", method = RequestMethod.POST)
    public String ruLocale(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString("ru"));
        model.addAttribute("locale", "ru");
        return "users";
    }

}
