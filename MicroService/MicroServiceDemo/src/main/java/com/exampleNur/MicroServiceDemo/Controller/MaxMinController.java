package com.exampleNur.MicroServiceDemo.Controller;

import com.exampleNur.MicroServiceDemo.Configuration.MaxMinConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaxMinController {
    @Autowired
    private MaxMinConfiguration maxMinConfiguration;
    @GetMapping("/api/maxAndMin")
    public MaxMinConfiguration maxMinConfiguration()
    {
        return new MaxMinConfiguration(maxMinConfiguration.getNum1(),maxMinConfiguration.getNum2());
    }
}
