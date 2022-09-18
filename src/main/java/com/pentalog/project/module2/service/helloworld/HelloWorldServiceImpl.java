package com.pentalog.project.module2.service.helloworld;

import com.pentalog.project.module2.model.greeting.GreetingDTO;
import com.pentalog.project.module2.model.greeting.NewGreetingDTO;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HelloWorldServiceImpl implements HelloWorldService {

    private final List<String> greetings = new ArrayList<>(Arrays.asList(
            "Hello, world!",
            "Howdy",
            "Hi",
            "Welcome",
            "Greetings"
    ));

    @Override
    public String helloWorld() {
        return "Hello World!";
    }

    @Override
    public String greetUser(GreetingDTO greeting) {
        return String.format("Hello %s %s %s!", greeting.lastName(), greeting.firstName(), greeting.middleName());
    }

    @Override
    public String createGreeting(final NewGreetingDTO newGreeting) {
        if(newGreeting == null || Strings.isBlank(newGreeting.getGreeting())){
            throw new IllegalArgumentException("Greeting must be provided!");
        }

        greetings.add(newGreeting.getGreeting());
        return "Greeting created!";
    }

    @Override
    public String greetUserRandomly(GreetingDTO greeting) {
        final String randomGreeting = greetings.get(new Random().nextInt(greetings.size()));

        return String.format(
                "%s %s %s %s!",
                randomGreeting,
                greeting.lastName(),
                greeting.firstName(),
                greeting.middleName()
        );
    }
}
