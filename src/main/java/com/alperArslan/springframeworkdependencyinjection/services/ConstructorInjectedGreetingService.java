package com.alperArslan.springframeworkdependencyinjection.services;

public class ConstructorInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world -- COnstructor";
    }
}
