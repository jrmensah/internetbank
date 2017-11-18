package me.jrmensah.internetbank.controllers;

import me.jrmensah.internetbank.entities.UserData;
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
    UserRepository userRepository;


    @RequestMapping("/")
    public String showMainPage(Principal p)
    {
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/add")
    public String showPageTwo(Model model) {
        model.addAttribute("Registration Form", "Second Page");
        model.addAttribute("pagenumber", "2");
        return "registration";
    }

    @GetMapping("/process")
    public String showRegistrationPage(Model model)
    {
        model.addAttribute("user", new UserData());
        return "registration";
    }
        @PostMapping("/register")
        public String processRegistrationPage(@Valid @ModelAttribute("user") UserData user,
                BindingResult result, Model model)
        {
            if(result.hasErrors()){
                return "registration";
            }
            userRepository.save(user);
            return "redirect:/";
        }

    @GetMapping("/add")
        public String showPageThree(Model model){
        model.addAttribute("Deposit Form","Third Page");
        model.addAttribute("pagenumber", "3");
        return "depositform";
    }
    @PostMapping("/deposit")
    public String processDepositPage(@Valid @ModelAttribute("user") UserData user,
                                          BindingResult result, Model model)
    {
        if(result.hasErrors()){
            return "depositform";
        }
        userRepository.save(user);
        return "redirect:/";
    }


    @GetMapping("/withdrawal")
        public String showPageFour(Model model) {
        model.addAttribute("Withdrawal", "Fourth Page");
        model.addAttribute("pagenumber", "4");
        return "withdrawalform";
    }
        @PostMapping("/withdrawal")
        public String processWithdrawalPage(@Valid @ModelAttribute("user") UserData user,
                BindingResult result, Model model)
        {
            if(result.hasErrors()){
                return "withdrawalform";
            }
            userRepository.save(user);
            return "redirect:/";
        }
    @GetMapping("/transaction")
    public String showPageFive(Model model){
        model.addAttribute("Transaction", "Fifth Page");
        model.addAttribute("pagenumber", "5");
        return "transaction";
    }

    @RequestMapping("/balance")
    public String showPageSix(Model model){
        model.addAttribute("Balance", "Sixth Page");
        model.addAttribute("pagenumber", "6");
        return "balance";
    }

    @RequestMapping("/detail/{id}")
        public String showItem(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
        public String updateItem(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findOne(id));
        return "withdrawalform";
    }

    @RequestMapping("/delete/{id}")
        public String delItem(@PathVariable("id") long id){
        userRepository.delete(id);
        return "redirect:/";
    }



}
