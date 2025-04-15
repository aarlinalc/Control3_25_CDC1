package Control3_25_CDC1.controller;

import Control3_25_CDC1.entities.Piso;
import Control3_25_CDC1.entities.Inmobiliaria;
import Control3_25_CDC1.entities.Piso;

public class Main {
    public static void main(String[] args) {
        // Crear una nueva instancia de la Inmobiliaria
        Inmobiliaria inmobiliaria = new Inmobiliaria();

        // Crear algunas viviendas (Pisos)
        Piso piso1 = new Piso("Calle Sol 1", "Laura", 0);
        Piso piso2 = new Piso("Calle Luna 2", "Pedro", 2);
        Piso piso3 = new Piso("Calle Estrella 3", "María", 3);

        // Añadir viviendas a la inmobiliaria
        inmobiliaria.save(piso1);
        inmobiliaria.save(piso2);
        inmobiliaria.save(piso3);

        // Mostrar todas las viviendas en la inmobiliaria
        inmobiliaria.mostrarTodas();

        // Buscar y actualizar una vivienda por ID
        Piso pisoActualizado = new Piso("Calle Volcan 2", "Luis", 3);  // Cambio de propietario
        inmobiliaria.update(pisoActualizado, 2);  // Actualizamos el piso con ID = 2

        // Mostrar todas las viviendas después de la actualización
        System.out.println("\nViviendas en la inmobiliaria después de la actualización:");
        inmobiliaria.mostrarTodas();

        // Eliminar una vivienda por ID
        inmobiliaria.delete(1);  // Eliminamos el piso con ID = 1

        // Mostrar todas las viviendas después de la eliminación
        System.out.println("\nViviendas en la inmobiliaria después de la eliminación:");
        inmobiliaria.mostrarTodas();
    }
}
