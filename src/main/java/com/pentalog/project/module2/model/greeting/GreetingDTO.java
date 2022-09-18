package com.pentalog.project.module2.model.greeting;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
public class GreetingDTO {

    final String firstName;

    final String middleName;

    final String lastName;
}