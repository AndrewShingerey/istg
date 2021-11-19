package com.istg.controller;

import com.istg.domain.CardProduct;
import com.istg.domain.CheckoutOrder;
import com.istg.domain.TableGames;
import com.istg.domain.User;
import com.istg.domain.enums.TypeGame;
import com.istg.service.interfaces.CardProductService;
import com.istg.service.interfaces.CheckoutOrderService;
import com.istg.service.interfaces.TableGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardProductService cardProductService;

    @Autowired
    private TableGameService tableGameService;

    @Autowired
    private CheckoutOrderService checkoutOrderService;

    @GetMapping("/carduser")
    public String cardUser(@AuthenticationPrincipal User user, Model model){
        Function<Long,String> getType = TypeGame::getTypeGameNameById;
        model.addAttribute("tableService",tableGameService);
        model.addAttribute("Type",getType);
        model.addAttribute("product_user",cardProductService.find_all_by_id_user(user.getId_user()));
        model.addAttribute("summa_products", cardProductService.find_all_by_id_user(user.getId_user()).stream()
                .mapToInt(o1->tableGameService.getById(o1.getId_game()).getPrice()).sum());

        if(!cardProductService.checkExists(user.getId_user())){
            cardProductService.create_card(user);
        }
        return "carduserPage";
    }
    @GetMapping("/addtocard/{idGame}")
    public String addtoCard(@AuthenticationPrincipal User user, @PathVariable String idGame){
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_game(Long.valueOf(idGame));
        cardProductService.save(cardProduct,user);
        return "redirect:/games/";
    }

    @GetMapping("/deletecard/{tb_id}")
    public String deleteProductFromCard(@AuthenticationPrincipal User user, @PathVariable String tb_id){
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_game(Long.valueOf(tb_id));
        cardProductService.delete(cardProduct,user);
        return "redirect:/card/carduser";
    }

    @PostMapping("/orderCard")
    public String orderCard(@AuthenticationPrincipal User user,
                            @RequestParam(name = "name_client")String name_client,
                            @RequestParam(name = "soname_client")String soname_client,
                            @RequestParam(name = "email_client")String email_client,
                            @RequestParam(name = "phone_client")String phone_client

    ){
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setName_client(name_client);
        checkoutOrder.setSoname_client(soname_client);
        checkoutOrder.setEmail_client(email_client);
        checkoutOrder.setPhone_client(phone_client);
        checkoutOrderService.save(checkoutOrder,user);
        return "redirect:/games/";
    }

    @GetMapping("/onegame/{id}")
    public String oneGame(@PathVariable(name = "id")String idGame,Model model){
        Function<Long,String> getType = TypeGame::getTypeGameNameById;
        model.addAttribute("game",tableGameService.getById(Long.valueOf(idGame)));
        model.addAttribute("Type",getType);

        return "oneGame";
    }

}
