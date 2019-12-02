package aemet1;
import java.io.FileWriter;
import java.io.IOException;

public class CrearHTML {

	public static void Fichero(String html) {

		try {
			// Abro stream, crea el fichero si no existe
			FileWriter fw = new FileWriter("aemet1.html");

			fw.write(html);
			// Cierro el stream
			fw.close();

		} catch (IOException e) {
			System.out.println("Error E/S: " + e);
		}

	}
}
