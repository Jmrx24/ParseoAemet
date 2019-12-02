package aemet1;
import java.util.Date;

public class Clima {

	String maximo;
	String minimo;
	String fechas;
	public Clima(String maximas, String minimas, String fecha) {
		super();
		this.maximo = maximas;
		this.minimo = minimas;
		this.fechas = fecha;
	}
	public String getMaximo() {
		return maximo;
	}
	public void setMaximo(String maximo) {
		this.maximo = maximo;
	}
	public String getMinimo() {
		return minimo;
	}
	public void setMinimo(String minimo) {
		this.minimo = minimo;
	}
	public String getFechas() {
		return fechas;
	}
	public void setFechas(String fechas) {
		this.fechas = fechas;
	}
	
	
	
	
}
