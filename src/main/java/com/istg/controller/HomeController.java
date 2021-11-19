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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private TableGameService tableGameService;

    @GetMapping("/")
    public String homePage(Model model){
        Function<Long,String>getType = TypeGame::getTypeGameNameById;
        List<TableGames>activegame = tableGameService.getAll().stream().limit(3).collect(Collectors.toList());
        List<TableGames>gamerow1 = tableGameService.getAll().stream().skip(3).limit(3).collect(Collectors.toList());
        List<TableGames>gamerow2 = tableGameService.getAll().stream().skip(6).limit(3).collect(Collectors.toList());

        model.addAttribute("ListGameActive",activegame);
        model.addAttribute("ListGamerow1",gamerow1);
        model.addAttribute("ListGamerow2",gamerow2);

        model.addAttribute("Type",getType);
        return "index";
    }


}
