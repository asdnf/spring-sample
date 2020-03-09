package org.test.sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.test.service.service.DogService;

@Controller
@RequestMapping(path = "/main")
public class MainController {

    @Autowired
    private DogService dogService;

    @RequestMapping(path = "index")
    public String index(Model model) {
        model.addAttribute("list", dogService.findDogs(""));
        return "main";
    }

}
