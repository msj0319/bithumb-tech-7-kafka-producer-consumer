package net.msj0319.api.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserController {

    @GetMapping
    public String home(){
        return "Hello Kafka";
    }
}
