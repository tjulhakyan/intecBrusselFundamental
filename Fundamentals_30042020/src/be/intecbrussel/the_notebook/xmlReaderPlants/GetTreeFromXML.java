package be.intecbrussel.the_notebook.xmlReaderPlants;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import be.intecbrussel.the_notebook.plant_entities.*;

import javax.xml.parsers.*;
import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GetTreeFromXML {
	public Set<Plant> parseTreeXML() throws ParserConfigurationException, SAXException, IOException {
		// Initialize a list of employees
		Set<Plant> listOfPlants = new HashSet<>();

		Tree plantTree;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		String separator = File.separator;
		String path = "src" + separator + "be" + separator 
				+ "intecbrussel" + separator + "the_notebook" + separator
				+ "filesXML" + separator + "tree.xml";

		Document document = builder.parse(new File(path));
		document.getDocumentElement().normalize();

		NodeList nList = document.getElementsByTagName("plant");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
			
				String name=eElement.getElementsByTagName("name").item(0).getTextContent();
				Double hight=Double.parseDouble(eElement.getElementsByTagName("height").item(0).getTextContent());
				// Create new Employee Object
				plantTree=new Tree(name, hight);
				int rand = new Random().nextInt(5);
				plantTree.setLeafType(LeafType.values()[rand]);
				
				// Add Employee to list
				listOfPlants.add(plantTree);
			}
		}
		return listOfPlants;
	}
}
