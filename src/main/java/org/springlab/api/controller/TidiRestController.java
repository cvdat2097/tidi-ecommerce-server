package org.springlab.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TidiRestController {

    @GetMapping(name = "/home")
    public String helloHome(){ 
        return "Hello this is rest";
    }
}
