package be.intecbrussel.the_notebook.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import be.intecbrussel.the_notebook.animal_entities.*;
import be.intecbrussel.the_notebook.plant_entities.*;
import be.intecbrussel.the_notebook.service.*;
import be.intecbrussel.the_notebook.xmlReaderPlants.GetBushFromXML;
import be.intecbrussel.the_notebook.xmlReaderPlants.GetFlowerFromXML;
import be.intecbrussel.the_notebook.xmlReaderPlants.GetTreeFromXML;
import be.intecbrussel.the_notebook.xmlReaderPlants.GetWeedFromXML;

public class NatureApp {

	public static void main(String[] args) throws Exception {
		GetBushFromXML getBushFromXML=new GetBushFromXML();
		GetFlowerFromXML getPlantsFromXml=new GetFlowerFromXML();
		GetTreeFromXML getTreeFromXML=new GetTreeFromXML();
		GetWeedFromXML getWeedFromXML=new GetWeedFromXML();
		
		
		// ===== Plants =====
		Set<Plant> listOfPlants=new HashSet<>();
		listOfPlants.addAll(getBushFromXML.parseBushXML());
		listOfPlants.addAll(getPlantsFromXml.parseFlowerXML());
		listOfPlants.addAll(getTreeFromXML.parseTreeXML());
		listOfPlants.addAll(getWeedFromXML.parseWeedXML());
		
	
		
		// Animals
		Herbivore herbivoreKenguru= new Herbivore("Kenguru", 0.5, 2.15, 1.52);
		herbivoreKenguru.setPlantDiet(listOfPlants);
		Weed plantWeedMota=new Weed("Mota", 15.5);
		plantWeedMota.setArea(215.2);
		herbivoreKenguru.addPlantToDiet(plantWeedMota);
		Herbivore herbivoreElephant= new Herbivore("Elephant", 3.5, 4.20, 6.5);
		herbivoreElephant.setPlantDiet(listOfPlants);
		Herbivore herbivoreSheep= new Herbivore("Sheep", 0.45, 0.55, 1.11);
		herbivoreSheep.setPlantDiet(listOfPlants);
		List<Herbivore> listHerbivore=new ArrayList<>();
		listHerbivore.add(herbivoreKenguru);
		listHerbivore.add(herbivoreElephant);
		listHerbivore.add(herbivoreSheep);
		
		Omnivore omnivoreEzel=new Omnivore("Ezel", 0.4, 0.62, 0.88);
		omnivoreEzel.setPlantDiet(listOfPlants);;
		omnivoreEzel.setMaxFoodSize(0.9);
		Omnivore omnivoreBizon=new Omnivore("Bizon", 0.82, 0.99, 2.35);
		omnivoreBizon.setPlantDiet(listOfPlants);;
		omnivoreBizon.setMaxFoodSize(1.2);
		Omnivore omnivoreSnake=new Omnivore("Snake", 0.05, 0.05, 2.80);
		omnivoreSnake.setPlantDiet(listOfPlants);;
		omnivoreSnake.setMaxFoodSize(0.2);
		List<Omnivore> listOmnivore=new ArrayList<>();
		listOmnivore.add(omnivoreEzel);
		listOmnivore.add(omnivoreBizon);
		listOmnivore.add(omnivoreSnake);
		
		Carnivore carnivoreTiger= new Carnivore("Tiger", 0.5, 1, 2.1);
		carnivoreTiger.setMaxFoodSize(2.2);
		Carnivore carnivoreBeer= new Carnivore("Beer", 0.5, 3, 2.5);
		carnivoreBeer.setMaxFoodSize(4.2);
		Carnivore carnivoreLien= new Carnivore("Lien", 0.9, 1.5, 2.55);
		carnivoreLien.setMaxFoodSize(4.2);
		List<Carnivore> listCarnivore=new ArrayList<>();
		listCarnivore.add(carnivoreTiger);
		listCarnivore.add(carnivoreBeer);
		listCarnivore.add(carnivoreLien);
		
		
		
		ForestNotebook forestNotebook=new ForestNotebook();
		
		
		forestNotebook.setHerbivores(listHerbivore);
		forestNotebook.setCornivores(listCarnivore);
		forestNotebook.setOmnivores(listOmnivore);

		
		Carnivore carnivoreLien1= new Carnivore("Len", 0.999, 1.5, 2.55);
		carnivoreLien1.setMaxFoodSize(3.2);
		forestNotebook.addAnimal(carnivoreLien1);
		
		Omnivore omnivoreSnake1=new Omnivore("Sake", 0.05, 0.05, 2.80);
		omnivoreSnake1.setPlantDiet(listOfPlants);;
		omnivoreSnake1.setMaxFoodSize(0.2);
		forestNotebook.addAnimal(omnivoreSnake1);
	
		// print count of Animals and Plants
		System.out.println("Total animals : "+forestNotebook.getAnimalCount());
		System.out.println("Total plants : "+forestNotebook.getPlantCount());
		
		// print all Animals and all Plants without sorting
		System.out.print("\r\nAll Animals and all Plants without sorting");
		forestNotebook.printNotebook();
		
		System.out.println("\r\n]]===<< All animals of the cornivore >>===["+forestNotebook.getCornivores());
		System.out.println("\r\n]]===<< All animals of the herbivore >>===["+forestNotebook.getHerbivores());
		System.out.println("\r\n]]===<< All animals of the omnivore >>===["+forestNotebook.getOmnivores());
		
		// sorting Animals and Plants by Name;
		System.out.print("\r\n**All Animals and all Plants sorted by name**");
		forestNotebook.sortAnimalsByName();
		forestNotebook.sortPlantsByName();
		
		// now all Animals and Plants are sorted by name  
		// print all Animals and all Plants
		forestNotebook.printNotebook();
		
		// sorting Animals and Plants by height;
		System.out.print("\r\n**All Animals and all Plants sorted by height**");
		forestNotebook.sortAnimalsByHeight();
		forestNotebook.sortPlantsByHeight();
		
		// now all Animals and Plants are sorted by height  
		// print all Animals and all Plants
		forestNotebook.printNotebook();

	}
}
