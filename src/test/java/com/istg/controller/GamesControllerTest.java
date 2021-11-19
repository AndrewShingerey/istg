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

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@WebMvcTest(GamesController.class)
@ContextConfiguration(classes = AppConfig.class)
@AutoConfigureMockMvc(secure = false)
@ComponentScan("com.istg")
public class GamesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TableGameService tableGameService;

    @Test
    public void loadPageGame() throws Exception {
        this.mockMvc.perform(get("/games/"))
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='text_logo']").string("Games"));
    }

    @Test
    public void PageGameCountNode() throws Exception {
        this.mockMvc.perform(get("/games/"))
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='card_item']").nodeCount(0));
    }

    @Test
    public void findGameByName() throws Exception {
        this.mockMvc.perform(post("/games/find")
                .param("name_game","GameTest").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='card_item']").nodeCount(0));
    }

    @Test
    public void findGameByNameWithEmpty() throws Exception {
        this.mockMvc.perform(post("/games/find")
                .param("name_game","").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='card_item']").nodeCount(0));
    }



}
