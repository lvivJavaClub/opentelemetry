package com.lvivjavaclub.opentelemetry;

import com.github.javafaker.Faker;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.WithSpan;

public class PersonService {

    private final Faker faker = new Faker();

    @WithSpan
    public Person generatePerson() {
        return new Person(generateName());
    }

    @WithSpan
    private String generateName() {
        String generatedName = faker.name().fullName();
        Span current = Span.current();
        current.setAttribute("generated-name", generatedName);
        return generatedName;
    }
}
