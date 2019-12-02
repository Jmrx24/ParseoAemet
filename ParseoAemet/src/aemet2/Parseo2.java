package aemet2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import aemet1.Clima;
import aemet1.GestionFichero;

public class Parseo2 {

	static URL url;
	static File fichero;
	public static void ParsearURL()
	{
		Clima clima;
		ArrayList<Clima> lista = new ArrayList<Clima>();
		SAXBuilder b = new SAXBuilder();
			
		try {
			Scanner sc= new Scanner(System.in);
			System.out.println("Introduzca su código postal");
			String Cd=sc.nextLine();
			url = new URL("http://www.aemet.es/xml/municipios/localidad_"+Cd+".xml");
			URLConnection conex;
				conex = url.openConnection();
				BufferedReader bf= new BufferedReader(new InputStreamReader(conex.getInputStream()));
			Document documento = b.build(bf);
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
