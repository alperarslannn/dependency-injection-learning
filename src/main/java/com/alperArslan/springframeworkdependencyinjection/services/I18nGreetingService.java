package com.alperArslan.springframeworkdependencyinjection.services;

import com.alperArslan.springframeworkdependencyinjection.repositories.EnglishGreetingRepository;

public class I18nGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
