package com.istg.controller;


import com.istg.config.AppConfig;
import com.istg.config.WebSecurityConfig;
import com.istg.dao.Interface.*;
import com.istg.service.interfaces.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
@ContextConfiguration(classes = {AppConfig.class, WebSecurityConfig.class})
@AutoConfigureMockMvc
@ComponentScan("com.istg")
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdminController adminController;

    @MockBean
    private CheckoutOrderService checkoutOrderService;

    @MockBean
    private TableGameService tableGameService;

    @MockBean
    private ContactUsService contactUsService;

    @MockBean
    private UserService userService;

    @MockBean
    private FeedBackService feedBackService;

    @Test
    public void homeAdminPageLoad() throws Exception {
        this.mockMvc.perform(get("/admin/home").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='title_admin']")
                        .string("Списки объектов сайта для администратора"));
    }

    @Test
    public void homeAdminPageCountLink() throws Exception {
        this.mockMvc.perform(get("/admin/home").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='item_link']").nodeCount(5));
    }

    @Test
    public void AdminPanelListGameLoad()throws Exception{
        this.mockMvc.perform(get("/admin/listofgame").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='text_page']").string("List of all games"));
    }

    @Test
    public void AdminPanelListGameCountNode()throws Exception{
        this.mockMvc.perform(get("/admin/listofgame").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='item']").nodeCount(0));
    }

    @Test
    public void AdminPanelAddGame() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());
        this.mockMvc.perform(fileUpload("/admin/listofgame/addgame").file(file)
                .param("name_game","test")
                .param("describe_game","test")
                .param("price","123")
                .param("type_id","1").with(csrf()).with(user("adm").password("123")
                        .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listofgame"));
    }

    @Test
    public void AdminPanelAddGameFailed() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());
        this.mockMvc.perform(fileUpload("/admin/listofgame/addgame").file(file)
                .param("name_game","")
                .param("describe_game","test")
                .param("price","123")
                .param("type_id","1").with(csrf()).with(user("adm").password("123")
                        .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listofgame"));
    }

    @Test
    public void AdminPanelEditGame() throws Exception{
        MockMultipartFile file = new MockMultipartFile("file_edit", "orig", null, "bar".getBytes());
        this.mockMvc.perform(fileUpload("/admin/Edit/4").file(file)
                .param("name_game_edit","zoomzoomator")
                .param("describe_game_edit","test")
                .param("price_edit","123")
                .param("type_id_edit","1").with(csrf()).with(user("adm").password("123")
                        .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listofgame"));
    }


    @Test
    public void AdminPanelEditGameFailed() throws Exception{
        MockMultipartFile file = new MockMultipartFile("file_edit", "orig", null, "bar".getBytes());
        this.mockMvc.perform(fileUpload("/admin/Edit/-1").file(file)
                .param("name_game_edit","zoomzoomator")
                .param("describe_game_edit","test")
                .param("price_edit","123")
                .param("type_id_edit","1").with(csrf()).with(user("adm").password("123")
                        .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listofgame"));
    }

    @Test
    public void AdminPanelDeleteGame() throws Exception {
        this.mockMvc.perform(get("/admin/delete/7").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listofgame"));
    }

    @Test
    public void AdminPanelListUserLoadTest()throws Exception{
        this.mockMvc.perform(get("/admin/listofuser").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='title_admin']")
                        .string("List of all users"));
    }

    @Test
    public void AdminPanelListUserCountNodeTest()throws Exception{
        this.mockMvc.perform(get("/admin/listofuser").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='item']")
                        .nodeCount(0));
    }

    @Test
    public void AdminPanelListUserDeleteTest()throws Exception{
        this.mockMvc.perform(get("/admin/listofuser/delete/2").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listofuser"));
    }

    @Test
    public void AdminPanelListFeedBackLoad()throws Exception{
        this.mockMvc.perform(get("/admin/listoffeedback").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='title_admin']").string("List of all feedback"));
    }

    @Test
    public void AdminPanelListUserUpdateTest()throws Exception{
        this.mockMvc.perform(post("/admin/listofuser/edit/3")
                .param("username_user_edit","Tom")
                .param("name_user_edit","Tommas")
                .param("soname_user_edit","Shelby")
                .param("email_user_edit","tomshelb@mail.cu")
                .param("role","ADMIN").with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void AdminPanelListFeedBackNodeCount()throws Exception{
        this.mockMvc.perform(get("/admin/listoffeedback").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='item']")
                        .nodeCount(0));
    }

    @Test
    public void AdminPanelListFeedBackDelete()throws Exception{
        this.mockMvc.perform(get("/admin/listoffeedback/delete/1").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listoffeedback"));
    }

    @Test
    public void AdminPanelListCardUser()throws Exception{
        this.mockMvc.perform(get("/admin/listcarduser").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='title_admin']").string("List of all card user"));
    }

    @Test
    public void AdminPanelListContactUsCountNode()throws Exception{
        this.mockMvc.perform(get("/admin/listcontactus").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='item']")
                        .nodeCount(0));
    }

    @Test
    public void AdminPanelListContactUsDelete()throws Exception{
        this.mockMvc.perform(get("/admin/listcontactus/delete/3").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listcontactus"));
    }

    @Test
    public void AdminPanelListCheckoutOrder()throws Exception{
        this.mockMvc.perform(get("/admin/listcheckoutorder").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(xpath("//*[@id='title_admin']").string("List of all checkout order"));
    }

    @Test
    public void AdminPanelListCheckoutOrderCountNode() throws Exception {
            this.mockMvc.perform(get("/admin/listcheckoutorder").with(user("adm").password("123")
                    .authorities(new SimpleGrantedAuthority("ADMIN"))))
                    .andExpect(authenticated())
                    .andExpect(status().isOk())
                    .andExpect(xpath("//*[@id='item']")
                            .nodeCount(0));

    }

    @Test
    public void AdminPanelListCheckoutOrderDelete()throws Exception{
        this.mockMvc.perform(get("/admin/listcheckoutorder/delete/6").with(user("adm").password("123")
                .authorities(new SimpleGrantedAuthority("ADMIN"))))
                .andExpect(authenticated())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/listcheckoutorder"));
    }

}
