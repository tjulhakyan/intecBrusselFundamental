package be.intecbrussel.the_notebook.plant_entities;

public class Bush extends Plant{
	private String fruit;
	private LeafType leafType;
	
	public Bush(String name) {
		super(name);
	}
	
	public Bush(String name, double height) {
		super(name, height);
	}
	
	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public LeafType getLeafType() {
		return leafType;
	}

	public void setLeafType(LeafType leafType) {
		this.leafType = leafType;
	}

	@Override
	public String toString() {
		String printTxt=super.toString();
		if (this.leafType!=null) {
			printTxt+=", leafType=" + leafType;
		}
		if(this.fruit!=null){
			printTxt+=", fruit=" + fruit;
		}
		return printTxt;
	}
	
	
}
