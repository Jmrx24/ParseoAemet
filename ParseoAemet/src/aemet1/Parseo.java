package aemet1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Parseo {

	public static void Parsear() 
	{
		Clima clima;
		ArrayList<Clima> lista = new ArrayList<Clima>();
		SAXBuilder b = new SAXBuilder();
		File fichero = new File("aemet1.xml");

		try {
			Document documento = b.build(fichero);
			Element e = documento.getRootElement();
			Element prediccion = e.getChild("prediccion");

			List<Element> dia = prediccion.getChildren("dia");

			for (Element element : dia) {
				String fecha = element.getAttributeValue("fecha");

				List<Element> temperatura = element.getChildren("temperatura");

				for (Element element2 : temperatura) {
					System.out.println(element2.getName());
					// Maximas
					Element maxima = element2.getChild("maxima");
					String maximas = maxima.getValue();
					System.out.println("la temperatura maxima es " + maxima.getValue());
					// Minimas
					Element minima = element2.getChild("minima");
					String minimas = minima.getValue();
					System.out.println("la temperatura minima es " + minima.getValue());
					clima = new Clima(maximas, minimas, fecha);
					lista.add(clima);
				}

			}
			String html = GestionFichero.crearHtml(lista);

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
