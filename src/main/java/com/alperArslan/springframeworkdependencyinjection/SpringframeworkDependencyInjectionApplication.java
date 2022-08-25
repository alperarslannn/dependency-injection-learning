package com.alperArslan.springframeworkdependencyinjection;

import com.alperArslan.springframeworkdependencyinjection.config.SfDiConfig;
import com.alperArslan.springframeworkdependencyinjection.config.SfDiConstructorConfig;
import com.alperArslan.springframeworkdependencyinjection.controllers.*;
import com.alperArslan.springframeworkdependencyinjection.datasource.FakeDatasource;
import com.alperArslan.springframeworkdependencyinjection.datasource.SecondFakeDataSource;
import com.alperArslan.springframeworkdependencyinjection.datasource.ThirdFakeDataSource;
import com.alperArslan.springframeworkdependencyinjection.services.PrototypeBean;
import com.alperArslan.springframeworkdependencyinjection.services.SingletonBean;
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

		System.out.println("--------- Bean Scopes --------");

		SingletonBean singletonBean = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean.getMyScope());

		SingletonBean singletonBean1 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(singletonBean1.getMyScope());

		PrototypeBean prototypeBean = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean.getMyScope());

		PrototypeBean prototypeBean1 = (PrototypeBean) ctx.getBean("prototypeBean");
		System.out.println(prototypeBean1.getMyScope());

		System.out.println("--------- External Properties --------");

		FakeDatasource fakeDatasource = ctx.getBean(FakeDatasource.class);
		System.out.println(fakeDatasource.getUsername());
		System.out.println(fakeDatasource.getPassword());
		System.out.println(fakeDatasource.getJdbcUrl());

		System.out.println("--------- Config Props Bean --------");

		SfDiConfig sfDiConfig = ctx.getBean(SfDiConfig.class);
		System.out.println(sfDiConfig.getUsername());
		System.out.println(sfDiConfig.getPassword());
		System.out.println(sfDiConfig.getJdbcUrl());

		System.out.println("--------- Config Props Bean used in SecondFakeDatasource --------");

		SecondFakeDataSource secondFakeDataSource = ctx.getBean(SecondFakeDataSource.class);
		System.out.println(secondFakeDataSource.getUsername());
		System.out.println(secondFakeDataSource.getPassword());
		System.out.println(secondFakeDataSource.getJdbcUrl());

		System.out.println("--------- Constructor Properties Binding --------");

		SfDiConstructorConfig sfDiConstructorConfig = ctx.getBean(SfDiConstructorConfig.class);
		System.out.println(sfDiConstructorConfig.getUsername());
		System.out.println(sfDiConstructorConfig.getPassword());
		System.out.println(sfDiConstructorConfig.getJdbcUrl());

		System.out.println("--------- Config Props Bean used in ThirdFakeDataSource --------");

		ThirdFakeDataSource thirdFakeDataSource = ctx.getBean(ThirdFakeDataSource.class);
		System.out.println(thirdFakeDataSource.getUsername());
		System.out.println(thirdFakeDataSource.getPassword());
		System.out.println(thirdFakeDataSource.getJdbcUrl());

	}

}
