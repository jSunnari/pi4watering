package com.sunnari.pi4watering.controller;

import com.sunnari.pi4watering.domain.PumpRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jonas on 2016-04-19.
 */

@Controller
@RequestMapping("/lists")
public class DatabaseController {

    @Autowired
    private PumpRunRepository repository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listPumpRuns(Model model) {
        model.addAttribute("pumpruns", repository.findAll());
        return "list";
    }
}
