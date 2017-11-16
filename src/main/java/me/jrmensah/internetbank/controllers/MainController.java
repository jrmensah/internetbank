package me.jrmensah.internetbank.controllers;


import me.jrmensah.internetbank.entities.UserData;
import me.jrmensah.internetbank.entities.UserService;
import me.jrmensah.internetbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;


    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new UserData());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user,
                                          BindingResult result,
                                          Model model){
        model.addAttribute("user", user);
        if (result.hasErrors())
        {
            return "registration";
        }else{
            userService.saveUserData(user);
            model.addAttribute("message", "User Account Successfully Created");
            return "index";
        }
    }
    @RequestMapping("/")
    public String showMainPage(Principal p){
        return "index";
    }

    @RequestMapping("/login")
        public String login(){
            return "login";
        }
    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }
    @RequestMapping("/admin")
        public String admin(){
            return "admin";
    }
    @RequestMapping("/base")
        public String showPageOne(Model model){
            model.addAttribute("title", "First Page");
            model.addAttribute("pagenumber" ,"1");
            return "base";
    }
    @GetMapping("/register")
        public String showPageTwo(Model model){
        model.addAttribute("user", new UserData());
        model.addAttribute("pagenumber", "2");
            return "registration";
    }
    @PostMapping("/register")
        public String processRegistrationPage(@Valid @ModelAttribute("user") UserData user,
                                          BindingResult result, Model model){
        model.addAttribute("user", user);

        if(result.hasErrors()){
            return "registration";
        }else{
            userService.saveUserData(user);
            model.addAttribute("message", "User Account Successfully created");
        }
        return "index";
    }


    @RequestMapping("/deposit")
        public String showPageThree(Model model){
        model.addAttribute("Deposit Form","Third Page");
        model.addAttribute("pagenumber", "3");
        return "deposit";
    }
    @RequestMapping("/detail/{id}")
        public String showDeposit(@PathVariable("deposit") long id, Model model) {
        model.addAttribute("user", userRepository.findOne(id));
        return "deposit";
    }

    @RequestMapping("/update/{id}")
        public String updateDeposit(@PathVariable("deposit") long id, Model model) {
        model.addAttribute("user", userRepository.findOne(id));
        return "depositform";
    }

    @RequestMapping("/delete/{id}")
        public String delDeposit(@PathVariable("deposit") long id){
        userRepository.delete(id);
        return "redirect:/";
    }


    @RequestMapping("/withdrawal")
        public String showPageFour(Model model){
        model.addAttribute("Withdrawal", "Fourth Page");
        model.addAttribute("pagenumber", "4");
        return "withdrawal";
    }
    @RequestMapping("/detail/{id}")
        public String showWithdrawal(@PathVariable("withdrawal") long id, Model model) {
        model.addAttribute("user", userRepository.findOne(id));
        return "withdrawal";
    }

    @RequestMapping("/update/{id}")
        public String updateWithdrawal(@PathVariable("withdrawal") long id, Model model) {
        model.addAttribute("user", userRepository.findOne(id));
        return "withdrawalform";
    }

    @RequestMapping("/delete/{id}")
        public String delWithdrawal(@PathVariable("withdrawal") long id){
        userRepository.delete(id);
        return "redirect:/";
    }



    @RequestMapping("/transaction")
    public String transaction(){
        return "transaction";
    }

    @RequestMapping("/balance")
    public String balance(){
        return "balance";
    }
}
