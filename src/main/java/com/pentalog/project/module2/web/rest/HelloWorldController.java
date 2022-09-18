package com.pentalog.project.module2.web.rest;

import com.pentalog.project.module2.model.greeting.GreetingDTO;
import com.pentalog.project.module2.model.greeting.NewGreetingDTO;
import com.pentalog.project.module2.service.helloworld.HelloWorldService;
import com.pentalog.project.module2.service.helloworld.HelloWorldServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/api/v1/hello-world")
public class HelloWorldController {

    private final HelloWorldService helloWorldService = new HelloWorldServiceImpl();

    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld();
    }

    @GetMapping("/greet/{lastName}")
    public String greetUser(
            @PathVariable("lastName") String lastName,
            @RequestParam("firstName") String firstName,
            @RequestParam("middleName") String middleName
    ){
        return helloWorldService.greetUser(new GreetingDTO(firstName, middleName, lastName));
    }

    @PostMapping("/greetings")
    @ResponseStatus(HttpStatus.CREATED)
    public String createAGreeting(@RequestBody NewGreetingDTO newGreeting) {
        return helloWorldService.createGreeting(newGreeting);
    }
}
