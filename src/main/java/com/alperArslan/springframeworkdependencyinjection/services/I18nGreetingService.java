package com.alperArslan.springframeworkdependencyinjection.services;

public class I18nGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
