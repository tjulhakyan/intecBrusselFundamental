package be.intecbrussel.the_notebook.animal_entities;

import java.util.Set;

import be.intecbrussel.the_notebook.plant_entities.Plant;

public class Omnivore extends Animal {
	private Set<Plant> plantDiet;
	private double maxFoodSize;

	public Omnivore(String name) {
		super(name);
	}

	public Omnivore(String name, double weight, double height, double length) {
		super(name, weight, height, length);
	}

	public void addPlantToDiet(Plant plant) {
		if (plant != null) {
			plantDiet.add(plant);
		}
	}

	public Set<Plant> getPlantDiet() {
		return plantDiet;
	}

	public void setPlantDiet(Set<Plant> plantDiet) {
		this.plantDiet = plantDiet;
	}

	public double getMaxFoodSize() {
		return maxFoodSize;
	}

	public void setMaxFoodSize(double maxFoodSize) {
		this.maxFoodSize = maxFoodSize;
	}

	@Override
	public String toString() {
		return "\r\n\n*"+this.getClass().getSimpleName()+"* " + super.toString() + "\r\nplantDiet = " + plantDiet + ", maxFoodSize = "
				+ maxFoodSize;
	}

}
