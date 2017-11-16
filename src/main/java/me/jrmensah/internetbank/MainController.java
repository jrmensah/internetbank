package me.jrmensah.internetbank;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
        public String login(){
            return "login";
        }
    @RequestMapping("/register")
    public String register(){
            return "register";
    }

    @RequestMapping("/deposit")
    public String deposit(){
        return "deposit";
    }

    @RequestMapping("/withdrawal")
    public String withdrawl(){
        return "withdrawal";
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
