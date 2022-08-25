package com.alperArslan.springframeworkdependencyinjection.config;

import com.alperArslan.springframeworkdependencyinjection.datasource.FakeDatasource;
import com.alperArslan.springframeworkdependencyinjection.datasource.SecondFakeDataSource;
import com.alperArslan.springframeworkdependencyinjection.repositories.EnglishGreetingRepository;
import com.alperArslan.springframeworkdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
// import com.alperArslan.springframeworkdependencyinjection.services.ConstructorInjectedGreetingService;
import com.alperArslan.springframeworkdependencyinjection.services.I18nGreetingService;
import com.alperArslan.springframeworkdependencyinjection.services.PrimaryGreetingService;
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource(value="classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    SecondFakeDataSource secondFakeDataSource(SfDiConfig sfDiConfig){
        SecondFakeDataSource secondFakeDataSource = new SecondFakeDataSource();
        secondFakeDataSource.setUsername(sfDiConfig.getUsername());
        secondFakeDataSource.setPassword(sfDiConfig.getPassword());
        secondFakeDataSource.setJdbcUrl(sfDiConfig.getJdbcUrl());

        return secondFakeDataSource;
    }

    @Bean
    FakeDatasource fakeDatasource(@Value("${alper.username}") String username,
                                  @Value("${alper.password}") String password,
                                  @Value("${alper.jdbcurl}") String jdbcurl){
        FakeDatasource fakeDatasource = new FakeDatasource();
        fakeDatasource.setUsername(username);
        fakeDatasource.setPassword(password);
        fakeDatasource.setJdbcUrl(jdbcurl);

        return fakeDatasource;
    }

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
