package com.alperArslan.springframeworkdependencyinjection.config;

import com.alperArslan.springframeworkdependencyinjection.repositories.EnglishGreetingRepository;
import com.alperArslan.springframeworkdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.alperArslan.springframeworkdependencyinjection.services.ConstructorInjectedGreetingService;
import com.alperArslan.springframeworkdependencyinjection.services.I18nGreetingService;
import com.alperArslan.springframeworkdependencyinjection.services.PrimaryGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nGreetingService(englishGreetingRepository);
    }

}
