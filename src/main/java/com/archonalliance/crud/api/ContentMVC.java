package com.archonalliance.crud.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentMVC {
    @GetMapping("/")
    public String index(){return "redirect:/admin";}

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

    @GetMapping("/admin/userId")
    public String deleteByIdPage(){return "admin_user_id";}

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin_panel";
    }

}
