package Control3_25_CDC1.entities;

import Control3_25_CDC1.model.Vivienda;

public class Piso implements Vivienda {
    private String direccion;
    private String propietario;
    int habitaciones;

    // Constructor
    public Piso(String direccion, String propietario, int habitaciones) {
        this.direccion = direccion;
        this.propietario = propietario;
        this.habitaciones = habitaciones;
    }

    // Implementación de los métodos de la interfaz

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
    
    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Información del piso:");
        System.out.println("Dirección: " + direccion);
        System.out.println("Propietario: " + propietario);
        System.out.println("Nº habitaciones: " + habitaciones);
    }
}

