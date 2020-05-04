package be.intecbrussel.the_notebook.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import be.intecbrussel.the_notebook.animal_entities.*;
import be.intecbrussel.the_notebook.plant_entities.Plant;

public class ForestNotebook {
	private List<Carnivore> cornivores = new ArrayList<>();
	private List<Omnivore> omnivores = new ArrayList<>();
	private List<Herbivore> herbivores = new ArrayList<>();
	private int plantCount;
	private int animalCount;
	private List<Animal> animals = new ArrayList<>();
	private List<Plant> plants = new ArrayList<>();

	public ForestNotebook() {
		this.plantCount = 0;
		this.animalCount = 0;
	}

	public List<Carnivore> getCornivores() {
		return this.cornivores;
	}

	public void setCornivores(List<Carnivore> cornivores) {
		cornivores.forEach(cor -> addAnimal(cor));
	}

	public List<Omnivore> getOmnivores() {
		return this.omnivores;
	}

	public void setOmnivores(List<Omnivore> omnivores) {
		if (omnivores != null) {
			omnivores.forEach(omni -> addAnimal(omni));
			omnivores.forEach((anm) -> anm.getPlantDiet().forEach((plnt) -> addPlant(plnt)));
		}
	}

	public List<Herbivore> getHerbivores() {
		return this.herbivores;
	}

	public void setHerbivores(List<Herbivore> herbivores) {
		if (herbivores != null) {
			herbivores.forEach(her -> addAnimal(her));
			herbivores.forEach(anm -> anm.getPlantDiet().forEach(plnt -> addPlant(plnt)));
		}
	}

	public int getPlantCount() {
		return plantCount;
	}

	public int getAnimalCount() {
		return animalCount;
	}

	public void addAnimal(Animal animal) {
		if (animal != null) {
			if (!this.animals.contains(animal)) {
				this.animals.add(animal);
				this.animalCount++;
				if (animal instanceof Carnivore) {
					Carnivore an = (Carnivore) animal;
					this.cornivores.add(an);
				}
				if (animal instanceof Omnivore) {
					Omnivore an = (Omnivore) animal;
					this.omnivores.add(an);
				}
				if (animal instanceof Herbivore) {
					Herbivore an = (Herbivore) animal;
					this.herbivores.add(an);
				}
			} else {
				System.out.println("Repead animale: "+animal.getName()+", "+animal.getClass().getSimpleName());
			}
		}
	}

	public void addPlant(Plant plant) {
		if (plant != null && !this.plants.contains(plant)) {
			this.plants.add(plant);
			this.plantCount++;
		}
	}

	public void printNotebook() {
		System.out.print("\r\n]]===<< All ANIMALS >>===[");
		System.out.println(this.animals);

		System.out.print("\r\n]]===<< All PLANTS >>===[");
		System.out.println(this.plants);
	}

	public void sortAnimalsByName() {
		Collections.sort(this.animals);
	}

	public void sortPlantsByName() {
		Collections.sort(this.plants);
	}

	public void sortAnimalsByHeight() {
		this.animals = this.animals.stream()
				.sorted(Comparator.comparing(Animal::getHeight))
				.collect(Collectors.toList());
	}

	public void sortPlantsByHeight() {
		this.plants = this.plants.stream()
				.sorted(Comparator.comparing(Plant::getHeight))
				.collect(Collectors.toList());
	}

}
