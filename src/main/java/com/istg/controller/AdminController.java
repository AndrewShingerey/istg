package com.istg.controller;

import com.istg.domain.TableGames;
import com.istg.domain.User;
import com.istg.domain.enums.TypeGame;
import com.istg.domain.enums.UserRole;
import com.istg.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private TableGameService tableGameService;

    @Autowired
    private UserService userService;

    @Autowired
    private FeedBackService feedBackService;

    @Autowired
    private CardProductService cardProductService;

    @Autowired
    private CheckoutOrderService checkoutOrderService;

    @Autowired
    private ContactUsService contactUsService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/home")
    public String homeAdminPanel(){
        return "adminPanel";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listofgame")
    public String listOfGame(Model model){
        Function<Long,String> getType = TypeGame::getTypeGameNameById;
        List<TableGames> allGame = tableGameService.getAll();
        model.addAttribute("ListGame",allGame);
        model.addAttribute("Type",getType);
        return "listofgame";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/listofgame/addgame")
    public String addnewGame(@RequestParam(name = "name_game")String name_game,
                             @RequestParam(name = "describe_game")String describe_game,
                             @RequestParam(name = "price")String price_game,
                             @RequestParam(name="type_id")String type_id,
                             @RequestParam(name="file") String file) throws IOException {
        TableGames tableGames = new TableGames();
        tableGames.setName_game(name_game);
        tableGames.setDescribe_game(describe_game);
        tableGames.setPrice(Integer.valueOf(price_game));
        tableGames.setType_id(Long.valueOf(type_id));
        tableGames.setFilename_photo_game(file);
        tableGameService.save(tableGames);
        return "redirect:/admin/listofgame";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable String id){
        tableGameService.delete(tableGameService.getById(Long.valueOf(id)));
        return "redirect:/admin/listofgame";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/Edit/{id}")
    public String editGame(@RequestParam(name = "name_game_edit") String name_game,
                           @RequestParam(name = "describe_game_edit") String describe_game,
                           @RequestParam(name = "price_edit") String price_game,
                           @RequestParam(name = "type_id_edit") String type_id,
                           @RequestParam("file_edit") String file, @PathVariable String id){
        TableGames tableGames = new TableGames();
        tableGames.setId_game(Long.valueOf(id));
        tableGames.setName_game(name_game);
        tableGames.setDescribe_game(describe_game);
        tableGames.setPrice(Integer.valueOf(price_game));
        tableGames.setType_id(Long.valueOf(type_id));
        if(!file.isEmpty()){
            tableGames.setFilename_photo_game(file);
        }else {
            tableGames.setFilename_photo_game("None");
        }

        tableGameService.update(tableGames);
        return "redirect:/admin/listofgame";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listofuser")
    public String userList(Model model){
        model.addAttribute("userList",userService.getAll());
        return "listofuser";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listofuser/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userService.delete(userService.getById(Long.valueOf(id)));
        return "redirect:/admin/listofuser";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/listofuser/edit/{id}")
    public String editUser(
            @RequestParam(name = "username_user_edit") String username,
            @RequestParam(name = "name_user_edit") String name,
            @RequestParam(name = "soname_user_edit") String soname,
            @RequestParam(name = "email_user_edit") String email,
            @RequestParam(name = "role") String role,
            @PathVariable(name = "id") String id){
        User user = userService.getById(Long.valueOf(id));
        user.setId_user(Long.valueOf(id));
        user.setUsername(username);
        user.setName(name);
        user.setSoname(soname);
        user.setEmail(email);
        user.setRole(UserRole.valueOf(role));
        userService.update(user);
        return "redirect:/admin/listofuser/";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listoffeedback")
    public String listFeedback(Model model){
        model.addAttribute("listFd",feedBackService.getAll());
        return "listoffedback";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listoffeedback/delete/{id}")
    public String deleteFeedback(@PathVariable String id){
        feedBackService.delete(feedBackService.getById(Long.valueOf(id)));
        return "redirect:/admin/listoffeedback";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listcarduser")
    public String listcardUser(Model model){
        model.addAttribute("cardList",cardProductService.getAll());
        return "listofcarduser";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listcontactus")
    public String listofContactus(Model model){
        model.addAttribute("listContact",contactUsService.getAll());
        return "listofcontactus";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listcontactus/delete/{id}")
    public String deleteContactUS(@PathVariable String id){
         contactUsService.delete(contactUsService.getById(Long.valueOf(id)));
         return "redirect:/admin/listcontactus";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listcheckoutorder")
    public String listcheckoutOrder(Model model){
        model.addAttribute("listOrder",checkoutOrderService.getAll());
        return "listofcheckoutorder";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/listcheckoutorder/delete/{id}")
    public String deleteCheckoutOrder(@PathVariable String id){
        checkoutOrderService.delete(checkoutOrderService.getById(Long.valueOf(id)));
        return "redirect:/admin/listcheckoutorder";
    }


}
