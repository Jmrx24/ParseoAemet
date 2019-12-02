package aemet1;
import java.util.ArrayList;

public class GestionFichero {

	public static String crearHtml(ArrayList<Clima> lista) {
		String html = "<html>";

		for (Clima clima : lista) {
			html += "<table border=1>";
			html += "<tr><td>Fecha</td><td>" + clima.getFechas() + "</td></tr>";
			System.out.println(clima.getFechas());
			html += "<tr><td>Max</td><td>" + clima.getMaximo() + "</td></tr>";
			System.out.println(clima.getMaximo());
			html += "<tr><td>Min</td><td>" + clima.getMinimo() + "</td></tr>";
			System.out.println(clima.getMinimo());
			html += "</table>";

		}

		html += "</html>";
		CrearHTML.Fichero(html);
		return html;

	}
	
}
