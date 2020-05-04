package be.intecbrussel.the_notebook.animal_entities;

import java.util.Set;

import be.intecbrussel.the_notebook.plant_entities.Plant;

public class Herbivore extends Animal {
	private Set<Plant> plantDiet;

	public Herbivore(String name) {
		super(name);
	}

	public Herbivore(String name, double weight, double height, double length) {
		super(name, weight, height, length);
	}

	public void addPlantToDiet(Plant plant) {
		if (plant != null) {
			plantDiet.add(plant);
		}
	}

	public void printDiet() {
		plantDiet.stream().forEach(System.out::println);
	}

	public Set<Plant> getPlantDiet() {
		return plantDiet;
	}

	public void setPlantDiet(Set<Plant> plantDiet) {
		this.plantDiet = plantDiet;
	}

	@Override
	public String toString() {
		return "\r\n\n*"+this.getClass().getSimpleName()+"* " + super.toString() + "\r\nplantDiet=" + plantDiet + "\r\n";
	}

}
