package com.alperArslan.springframeworkdependencyinjection;

import com.alperArslan.springframeworkdependencyinjection.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"com.alperArslan.springframeworkdependencyinjection","com.springframework.pets"})
// We can now remove componentScan because we are utilizing all of the components as a bean in out app

@SpringBootApplication
public class SpringframeworkDependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringframeworkDependencyInjectionApplication.class, args);

		System.out.println("--- The Best Pet is ---");
		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("--- My Controller ---");
		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.sayHello();

		System.out.println(greeting);

		System.out.println("--------- Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------- Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("--------- Primary");

		MyController myController1 = (MyController) ctx.getBean("myController");

		System.out.println(myController1.getGreeting());

		System.out.println("--------- i18nController");

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");

		System.out.println(i18nController.sayHello());



	}

}
