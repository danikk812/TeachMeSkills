package test;

public class Cat {
	private String name;

	public Cat(String name) {
		this.name = name;
	}

	public void sayHello(){
		System.out.println("Hello " + name);
	}

	@Override
	public String toString() {
		return "Cat{" +
				"name='" + name + '\'' +
				'}';
	}
}
