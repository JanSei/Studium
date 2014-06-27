package org.totalbeginner.tutorial;

public class Person {
	
	// Instanzvariablen
	private String name;		// Name der Person
	private int maximumBooks; 	// maximale Anzahl an Bücher die eine Person ausleihen kann
	
	// Konstruktoren
	public Person() {
		name = "unknown name";
		maximumBooks = 3;
	}
	
	// Methoden
	public String getName() {
		return name;
	}
	
	public void setName(String anyName) {
		name = anyName;
	}

	public int getMaximumBooks() {
		return maximumBooks;
	}

	public void setMaximumBooks(int maximumBooks) {
		this.maximumBooks = maximumBooks;
	}
	
	

}
