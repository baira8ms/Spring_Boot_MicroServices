package com.chart.openId.google.loginModule.controller;

import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

  @RequestMapping("/")
  public String login(Model model) {
    Authentication auth = SecurityContextHolder.getContext()
        .getAuthentication();
    System.out.println(auth.getPrincipal());
    return "index";
  }

  @RequestMapping("/callback")
  public String callback() {
    System.out.println("redirecting to home page::");
    return "home";
  }
//
//  @RequestMapping(value = "/user")
//  public Principal user(Principal principal) {
//    return principal;
//  }
}
