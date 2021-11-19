package com.istg.controller;

import com.istg.config.AppConfig;
import com.istg.dao.Interface.UserDao;
import com.istg.service.interfaces.TableGameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
@ContextConfiguration(classes = AppConfig.class)
@AutoConfigureMockMvc(secure = false)
@ComponentScan("com.istg")
public class LoginRegistrationSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDao userDao;

    @Test
    public void LoadLoginPage() throws Exception{
        this.mockMvc.perform(get("/admin/home"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void BadLoginParams() throws Exception {
        this.mockMvc.perform(post("/login").param("user","АндрейШингерей"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void ResitgrationLoadPageTest() throws Exception {
        this.mockMvc.perform(get("/registration/"))
                .andExpect(xpath("//*[@id='regForm']")
                        .string("Registration Form"))
                .andExpect(status().isOk());
    }

    @Test
    public void RegistrationUserSucessTest_WithGoodParam()throws Exception{
        this.mockMvc.perform(post("/registration/addnewuser").
                param("username","tommy").
                param("name_user","tomas").
                param("soname_user","Shin").
                param("email","andreyshina@mail.ru").
                param("password","12345678").with(csrf())).
                andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void RegistrationUserTest_WithBadParam()throws Exception{
        this.mockMvc.perform(post("/registration/addnewuser").
                param("username","Tim").
                param("name_user","tommy").
                param("soname_user","Shin").
                param("email","andreyshina@mail.ru").
                param("password","12345678").with(csrf())).
                andExpect(status().isFound());
    }



}
