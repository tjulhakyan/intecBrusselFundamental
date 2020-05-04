package be.intecbrussel.the_notebook.plant_entities;

import java.util.Objects;

public class Plant implements Comparable <Plant>{
	protected String name;
	protected double height;
	
	public Plant(String name) {
		this.name = name;
	}

	public Plant(String name, double height) {
		this(name);
		this.height = height;
	}

	public String getName() {
		return name;
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Plant)) return false;
        Plant plant = (Plant) obj;
        return Objects.equals(this.name, plant.getName());
	}
	
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.height);
    }

	@Override
	public int compareTo(Plant pl) {
		return this.name.compareTo(pl.name);
	}
	
	@Override
	public String toString() {
		return "\r\nThe name of plant is : "+this.name+", height = "+this.height;
	}
}
