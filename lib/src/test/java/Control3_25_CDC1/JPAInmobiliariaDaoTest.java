package Control3_25_CDC1;

import Control3_25_CDC1.entities.Inmobiliaria;
import Control3_25_CDC1.entities.Piso;
import Control3_25_CDC1.model.Vivienda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class JPAInmobiliariaDaoTest {

    private Inmobiliaria inmobiliaria;

    @BeforeEach
    public void setUp() {
        // Antes de cada test, creamos una nueva instancia de Inmobiliaria
        inmobiliaria = new Inmobiliaria();
    }


    @Test
    public void testFindById() {
        Vivienda piso1 = new Piso("Calle Sol 1", "Laura", 4);
        inmobiliaria.save(piso1);

        // Buscamos la vivienda por su ID
        Vivienda viviendaEncontrada = inmobiliaria.findById(1);

        // Verificamos que la vivienda encontrada es la correcta
        assertNotNull(viviendaEncontrada, "La vivienda debe existir en la inmobiliaria");
        assertEquals("Calle Sol 1", viviendaEncontrada.getDireccion(), "La dirección de la vivienda no coincide");
    }

    @Test
    public void testDeleteVivienda() {
        Vivienda piso1 = new Piso("Calle Sol 1", "Laura", 4);
        inmobiliaria.save(piso1);

        // Borramos la vivienda
        inmobiliaria.delete(1);

        // Verificamos que la vivienda ha sido eliminada
        Vivienda viviendaEliminada = inmobiliaria.findById(1);
        assertNull(viviendaEliminada, "La vivienda debe haber sido eliminada");
    }

    @Test
    public void testUpdateVivienda() {
        Vivienda piso1 = new Piso("Calle Sol 1", "Laura", 4);
        inmobiliaria.save(piso1);

        // Creamos una nueva vivienda para actualizar
        Vivienda pisoActualizado = new Piso("Calle Sol 1", "Carlos", 3);

        // Actualizamos la vivienda
        inmobiliaria.update(pisoActualizado, 1);

        // Verificamos que la vivienda ha sido actualizada
        Vivienda viviendaActualizada = inmobiliaria.findById(1);
        assertEquals("Carlos", viviendaActualizada.getPropietario(), "El propietario de la vivienda no ha sido actualizado");
    }

   
    @Test
    public void testSaveAllViviendas() {
        // Creamos un array de viviendas
    	Piso p1 = new Piso("Calle Sol 1", "Laura", 3);
    	Piso p2 =new Piso("Calle Luna 2", "Pedro", 2);
        // Guardamos todas las viviendas
        inmobiliaria.save(p1);
        inmobiliaria.save(p2);

        // Verificamos que las viviendas han sido añadidas
        List<Vivienda> viviendas = inmobiliaria.findAll();
        assertEquals(2, viviendas.size(), "La inmobiliaria debe tener 2 viviendas");
    }

}
