package com.archonalliance.crud.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentMVC {
    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin_panel";
    }

}
