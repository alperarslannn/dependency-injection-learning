package com.alperArslan.springframeworkdependencyinjection.config;

import com.alperArslan.springframeworkdependencyinjection.repositories.EnglishGreetingRepository;
import com.alperArslan.springframeworkdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
// import com.alperArslan.springframeworkdependencyinjection.services.ConstructorInjectedGreetingService;
import com.alperArslan.springframeworkdependencyinjection.services.I18nGreetingService;
import com.alperArslan.springframeworkdependencyinjection.services.PrimaryGreetingService;
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog","default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }


    //@Bean
    //ConstructorInjectedGreetingService constructorInjectedGreetingService(){
       // return new ConstructorInjectedGreetingService();
    // }

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
