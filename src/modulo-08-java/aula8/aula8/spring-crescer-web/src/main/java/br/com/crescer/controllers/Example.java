package br.com.crescer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author murillo.peteffi
 */
@Controller
public class Example {

    @RequestMapping(value = "/Example")
    String toIndex(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name != null ? name : "Murillo");
        return "index";
    }
}
