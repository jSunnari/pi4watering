package com.sunnari.pi4watering.controller;

import com.sunnari.pi4watering.domain.PumpRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Jonas on 2016-04-19.
 */

@Controller
@RequestMapping("/pumpruns")
public class DatabaseController {

    @Autowired
    private PumpRunRepository repository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listPumpRuns(Model model) {
        model.addAttribute("pumpruns", repository.findAll());
        return "list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/lists");
    }
}
