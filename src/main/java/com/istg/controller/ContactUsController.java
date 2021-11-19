package com.istg.controller;

import com.istg.domain.ContactUs;
import com.istg.service.interfaces.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contactus")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("/")
    public String contactUsPage(){
        return "contactUsPage";
    }

    @PostMapping("/sendcontact")
    public String sendContact(@RequestParam(name = "name_client")String name_client,
                              @RequestParam(name = "soname_client")String soname_client,
                              @RequestParam(name = "email_client")String email_client,
                              @RequestParam(name = "phone_client")String phone_client){
        ContactUs contactUs = new ContactUs();
        contactUs.setName_ct(name_client);
        contactUs.setSoname_ct(soname_client);
        contactUs.setPhone_ct(phone_client);
        contactUs.setEmail_ct(email_client);
        contactUsService.save(contactUs);

        return "redirect:/contactus/";
    }
}
