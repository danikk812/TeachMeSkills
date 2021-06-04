package test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "test")
public class RootConfiguration {

//	@Bean
//	public User user(@Qualifier("") Animal cat, Dog dog){
//		return new User("User", cat2, dog);
//	}

//
//	@Bean
//	public String name(){
//		return "User";
//	}

	@Bean
	public Cat cat(@Value("Cat") String name){
		return new Cat(name);
	}

	//	@Bean
//	public Cat cat2(){
//		return new Cat("Cat2");
//	}

	@Bean
	public Dog dog(@Value("Dog") String name){
		return new Dog(name);
	}
}
