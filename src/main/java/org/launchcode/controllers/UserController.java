package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by stephen on 3/27/17.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("title", "New User");
        model.addAttribute(new User());
        return "users/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "New User");
            model.addAttribute(user);
            return "users/new";
        }
        UserData.addUser(user);
        return "redirect:";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexUsers(Model model) {
        model.addAttribute("users", UserData.getUsers());
        return "users/index";
    }

}
