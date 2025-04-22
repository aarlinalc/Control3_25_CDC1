package is.c3.entities;

import java.util.logging.Logger;

import is.c3.model.Vivienda;

/**
 * Datos de un tipo particular de vivienda, un piso
 */
public class Piso implements Vivienda {
	private static Logger log = Logger.getLogger(Piso.class.getName());
	private String direccion;
	private String propietario;
	int habitaciones;

	// Constructor
	public Piso(String direccion, String propietario, int habitaciones) {
		this.direccion = direccion;
		this.propietario = propietario;
		this.habitaciones = habitaciones;
	}

	// Implementación de los métodos de una vivienda

	@Override
	public String getDireccion() {
		return direccion;
	}

	@Override
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String getPropietario() {
		return propietario;
	}

	@Override
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	@Override
	public int getHabitaciones() {
		return habitaciones;
	}

	@Override
	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	@Override
	public void mostrarInformacion() {
		log.fine("Información del piso:");
		log.fine("Dirección: " + direccion);
		log.fine("Propietario: " + propietario);
		log.fine("Nº habitaciones: " + habitaciones);
	}

	@Override
	public String toString() {
		String me = "\nDatos del piso: \nDirección: " + direccion + "\nPropietario: " + propietario + "\nHabitaciones: "
				+ habitaciones + "\n***************************************\n";
		return me;
	}
}
