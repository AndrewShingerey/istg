package com.istg.controller;

import com.istg.domain.TableGames;
import com.istg.domain.enums.TypeGame;
import com.istg.service.interfaces.TableGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.function.Function;

@Controller
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private TableGameService tableGameService;

    @GetMapping("/")
    public String gameHome(Model model){
        Function<Long,String> getType = TypeGame::getTypeGameNameById;
        List<TableGames> allGame = tableGameService.getAll();
        model.addAttribute("ListGame",allGame);
        model.addAttribute("Type",getType);
        return "gamesPage";
    }

    @PostMapping("/find")
    public String findByName(@RequestParam(name = "name_game")String name, Model model){
        Function<Long, String> getType = TypeGame::getTypeGameNameById;
        List<TableGames> allGame;
        if(!name.equals("")) {
            allGame = tableGameService.findByName(name);
            model.addAttribute("ListGame", allGame);
            model.addAttribute("Type", getType);
        }else{
            allGame = tableGameService.getAll();
            model.addAttribute("ListGame", allGame);
            model.addAttribute("Type", getType);
        }
        return "gamesPage";
    }
}
