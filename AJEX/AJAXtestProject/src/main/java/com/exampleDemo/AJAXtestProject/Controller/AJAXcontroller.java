package com.exampleDemo.AJAXtestProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ajaxApi")
@RestController
public class AJAXcontroller {
    @GetMapping("/call")
    public String call(){
        return "Returning Call method";
    }

}
