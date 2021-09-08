package net.msj0319.api.producer.controller;

import lombok.RequiredArgsConstructor;
import net.msj0319.api.producer.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "kafka-spring-producer";

    //아직 몽고DB에 연결하지 않았기 때문에 이런식으로 더미 데이터로 예시를 들었다.\
    //name이 publish 되면 name에 대한 id가 할당된다.
    @GetMapping("/publish/{name}")
    public String postMessage(@PathVariable final String name){
        User user = new User();
        user.setId("blahblah");
        user.setName(name);
        user.setEmail(name + "@test.com");
        kafkaTemplate.send(TOPIC, user);
        return "Message Published Successfully";
    }



}
