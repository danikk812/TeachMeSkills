package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	@Value("User")
	private String name;

//	@Autowired
	private Cat cat;

//	@Autowired
	private Dog dog;

	public Cat getCat() {
		return cat;
	}

	@Autowired
	public User(Cat cat, Dog dog) {
		this.cat = cat;
		this.dog = dog;
	}

//	@Autowired
	public User(String name, Cat cat, Dog dog) {
		this.name = name;
		this.cat = cat;
		this.dog = dog;
	}

	//	@Autowired
//	public void setCat(Cat cat) {
//		this.cat = cat;
//	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", cat=" + cat +
				", dog=" + dog +
				'}';
	}
}
