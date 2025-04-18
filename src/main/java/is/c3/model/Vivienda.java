package is.c3.model;

/**
 * Interfaz de operaciones típicas para gestionar los datos de una vivienda
 */
public interface Vivienda {

	String getDireccion();

	void setDireccion(String direccion);

	String getPropietario();

	void setPropietario(String propietario);

	int getHabitaciones();

	void setHabitaciones(int habitaciones);

	void mostrarInformacion();
}
