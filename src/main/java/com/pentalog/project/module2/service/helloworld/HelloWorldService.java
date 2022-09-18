package com.pentalog.project.module2.service.helloworld;

import com.pentalog.project.module2.model.greeting.GreetingDTO;
import com.pentalog.project.module2.model.greeting.NewGreetingDTO;

public interface HelloWorldService {

    String helloWorld ();

    String greetUser (GreetingDTO greeting);

    String createGreeting (NewGreetingDTO greeting);

    String greetUserRandomly (GreetingDTO greetingDTO);
}
