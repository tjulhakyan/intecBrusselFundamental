package be.intecbrussel.the_notebook.xmlReaderPlants;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import be.intecbrussel.the_notebook.plant_entities.*;

import javax.xml.parsers.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GetWeedFromXML {
	public Set<Plant> parseWeedXML() throws ParserConfigurationException, SAXException, IOException {
		// Initialize a list of employees
		Set<Plant> listOfPlants = new HashSet<>();

		Weed plantWeed;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		String separator = File.separator;
		String path = "src" + separator + "be" + separator 
				+ "intecbrussel" + separator + "the_notebook" + separator
				+ "filesXML" + separator + "weed.xml";

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
				plantWeed=new Weed(name, hight);
				plantWeed.setArea(Double.parseDouble(eElement.getElementsByTagName("area").item(0).getTextContent()));
				
				// Add Employee to list
				listOfPlants.add(plantWeed);
			}
		}
		return listOfPlants;
	}
}
