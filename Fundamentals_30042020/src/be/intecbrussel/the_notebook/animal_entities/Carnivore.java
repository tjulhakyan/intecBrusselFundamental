package be.intecbrussel.the_notebook.animal_entities;

public class Carnivore extends Animal{
	private double maxFoodSize;
	
	public Carnivore(String name) {
		super(name);
	}

	public Carnivore(String name, double weight, double height, double length) {
		super(name, weight, height, length);
	}

	public double getMaxFoodSize() {
		return maxFoodSize;
	}

	public void setMaxFoodSize(double maxFoodSize) {
		this.maxFoodSize = maxFoodSize;
	}

	@Override
	public String toString() {
		return "\r\n\n*"+this.getClass().getSimpleName()+"* "+super.toString()+"\r\nmaxFoodSize = " + maxFoodSize+" m\r\n";
	}
	
}
