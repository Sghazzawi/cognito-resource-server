package com.example.bananas.resourceserver;


import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class DummyRestSvc {

  @GetMapping({"/",""})
  public String getHello(Principal principal) {
    String username = "";
    if (principal != null) {
      username = (String)((JwtAuthenticationToken) principal).getTokenAttributes().get("username");
    }
    
    return "hello "+username +"\n";
  }
}
