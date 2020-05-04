package be.intecbrussel.the_notebook.plant_entities;

public class Weed extends Plant{
	private double area;
	
	public Weed(String name) {
		super(name);
		this.area=0;
	}
	
	public Weed(String name, double height) {
		super(name, height);
		this.area=0;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return this.area==0 ? super.toString() : super.toString()+", area = " + area;
	}
	
	
}
