package authserver;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class test {

    @RequestMapping(value = {"", "/home"}, method=RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/helloadmin", method=RequestMethod.GET)
    @ResponseBody
    public String helloAdmin(){
        return "helloAdmin";
    }

    @RequestMapping(value = "/hellouser", method=RequestMethod.GET)
    @ResponseBody
    public String helloUser(){
        return "helloUser";
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("/403")
    @ResponseBody
    public String forbidden(){
        return "403";
    }

}
