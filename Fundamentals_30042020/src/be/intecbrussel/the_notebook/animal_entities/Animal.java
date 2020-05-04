package be.intecbrussel.the_notebook.animal_entities;

import java.util.Objects;

public class Animal implements Comparable<Animal> {
	protected String name;
	protected double weight;
	protected double height;
	protected double length;
	
	public Animal(String name) {
		this.name = name;
	}

	public Animal(String name, double weight, double height, double length) {
		this(name);
		this.weight = weight;
		this.height = height;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal animal = (Animal) obj;
        return Objects.equals(this.name, animal.getName());
	}
	
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
	
	@Override
	public String toString() {
		return "\r\nThe animal is: " + name + "\r\nweight = " + weight + "m, height = " + height + "m, length = " + length+"m";
	}

	@Override
	public int compareTo(Animal anim) {
		return this.name.compareTo(anim.name);
	}
	
	
	
}
