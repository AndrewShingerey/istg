package com.istg.controller;


import com.istg.config.AppConfig;
import com.istg.dao.Interface.ContactUsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactUsController.class)
@ContextConfiguration(classes = AppConfig.class)
@AutoConfigureMockMvc(secure = false)
@ComponentScan("com.istg")
public class ContactUsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactUsDao contactUsDao;

    @Test
    public void LoadContactUsPage() throws Exception {
        this.mockMvc.perform(get("/contactus/"))
                .andExpect(status().isOk());
    }

    @Test
    public void SendContactFormSuccess()throws Exception{
        this.mockMvc.perform(post("/contactus/sendcontact")
                .param("name_client","test")
                .param("soname_client","test")
                .param("email_client","test")
                .param("phone_client","test")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/contactus/"));
    }

    @Test
    public void SendContactFormFailed()throws Exception{
        this.mockMvc.perform(post("/contactus/sendcontact")
                .param("name_client","")
                .param("soname_client","test")
                .param("email_client","test")
                .param("phone_client","test")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/contactus/"));
    }

}
