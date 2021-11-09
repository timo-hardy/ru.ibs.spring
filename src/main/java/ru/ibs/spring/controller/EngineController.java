package ru.ibs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ibs.spring.exception.FuelExceptionHandle;
import ru.ibs.spring.service.Engine;

import java.util.HashMap;

@Controller
public class EngineController {
    @Autowired(required = false)
    @Qualifier("mapServic")
    HashMap<String, Engine> engineMap;

    @FuelExceptionHandle
    @RequestMapping("/mvc/fuel")
    public String checkFuelType(@RequestParam(name = "name", required = false) String engineType, Model model){
        model.addAttribute("name", engineMap.get(engineType).powerUp());

        return "engineType";
    }
}
