package com.istg.controller;

import com.istg.config.AppConfig;
import com.istg.service.interfaces.TableGameService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
@ContextConfiguration(classes = AppConfig.class)
@AutoConfigureMockMvc(secure = false)
@ComponentScan("com.istg")
public class HomeControllerTest {

 @MockBean
 private TableGameService tableGameService;

 @Autowired
 private MockMvc mockMvc;

 @Test
 public void HomePageLoad() throws Exception {
   this.mockMvc.perform(get("/home/"))
           .andExpect(status().isOk())
           .andExpect(xpath("//*[@id='home']").string(" Home (current)"));
 }

 @Test
 public void HomePageCheckCountGameActive() throws Exception {
   this.mockMvc.perform(get("/home/"))
           .andExpect(xpath("//*[@id='game_active']").nodeCount(1))
           .andExpect(xpath("//*[@id='game_row1']").nodeCount(1))
           .andExpect(xpath("//*[@id='game_row2']").nodeCount(1));
 }

}