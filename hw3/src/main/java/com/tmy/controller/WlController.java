package com.tmy.controller;

import com.tmy.wordladder.wordladder;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import java.util.Stack;


@Controller
@EnableAutoConfiguration
public class WlController {
    @RequestMapping("/wl")
    @PreAuthorize("hasAnyRole('admin', 'user')")
    @ResponseBody
    String home(@RequestParam("word1") String word1, @RequestParam("word2") String word2) {
        wordladder test_wl = new wordladder("src/dictionary.txt", word1, word2);
        test_wl.read_dict();
        Stack<String> wl = test_wl.wl_stack();
        String output= test_wl.print_wl(wl);
        output="word ladder from "+word2+" to "+word1 +" is : \n"+output;
        return (output);
    }


}
