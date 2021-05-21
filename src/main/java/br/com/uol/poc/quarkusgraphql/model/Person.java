package br.com.uol.poc.quarkusgraphql.model;

public class Person {

	private String id;
	private int age;
	private String name;

	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public Person() {
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
}
