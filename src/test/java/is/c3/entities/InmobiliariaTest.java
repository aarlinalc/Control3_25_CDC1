package is.c3.entities;


import is.c3.model.Vivienda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class InmobiliariaTest {

	private Inmobiliaria inmobiliaria;

	@BeforeEach
	public void setUp() {
		// Antes de cada test, creamos una nueva instancia de Inmobiliaria
		inmobiliaria = new Inmobiliaria();
	}

	@Test
	public void testFindById() {
		Vivienda piso1 = new Piso("Calle Sol 1", "Laura", 4);
		//Debemos permitir almacenar nuevas viviendas (CU-00)
		inmobiliaria.save(piso1);

		// Buscamos la vivienda por su ID (una vivienda tiene que tener un identificador unívoco según la RN-02)
		// Como sólo hay una el id debe ser 1 
		// (valor de inicio de los identificadores según las RN-01)
		//Debemos permitir localizar una vivienda a partir de su ID unívoco (CU-01)
		Vivienda viviendaEncontrada = inmobiliaria.findById(1);

		// Verificamos que la vivienda encontrada es la correcta
		assertNotNull(viviendaEncontrada, "La vivienda debe existir en la inmobiliaria");
		assertEquals("Calle Sol 1", viviendaEncontrada.getDireccion(), "La dirección de la vivienda no coincide");
	}

	@Test
	public void testDeleteVivienda() {
		Vivienda piso1 = new Piso("Calle Sol 1", "Laura", 4);
		//Debemos permitir almacenar nuevas viviendas, de una en una o en grupo (CU-00)
		inmobiliaria.save(piso1);

		//Debemos permitir borrar una vivienda a partir de su ID unívoco (CU-02)
		// Borramos la vivienda
		// Como sólo hay una el id debe ser 1 
		//(valor de inicio de los identificadores según las RN-01)

		inmobiliaria.delete(1);

		// Verificamos que la vivienda ha sido eliminada
		Vivienda viviendaEliminada = inmobiliaria.findById(1);
		assertNull(viviendaEliminada, "La vivienda debe haber sido eliminada");
	}

	@Test
	public void testUpdateVivienda() {
		Piso piso1 = new Piso("Calle Sol 1", "Laura", 4);
		inmobiliaria.save(piso1);

		// Creamos una nueva vivienda para actualizar
		piso1.setPropietario("Carlos");
		piso1.setHabitaciones(3);

		//Debemos permitir actualizar una vivienda a partir de su ID unívoco (CU-03)
		// Actualizamos la vivienda
		// Como sólo hay una el id debe ser 1 
		//(valor de inicio de los identificadores según las RN-01)
	
		inmobiliaria.update(piso1, 1);

		// Verificamos que la vivienda ha sido actualizada
		Vivienda viviendaActualizada = inmobiliaria.findById(1);
		assertNotNull(viviendaActualizada, "No se localiza la vivienda");
		assertEquals("Carlos", viviendaActualizada.getPropietario(),
				"El propietario de la vivienda no ha sido actualizado");
	}

	@Test
	public void testSaveAllViviendas() {
		
		//Debemos permitir almacenar nuevas viviendas, de una en una o en grupo (CU-00)
		// Creamos un array de viviendas
		Piso p1 = new Piso("Calle Sol 1", "Laura", 3);
		Piso p2 = new Piso("Calle Luna 2", "Pedro", 2);
		// Guardamos todas las viviendas
		inmobiliaria.save(p1);
		inmobiliaria.save(p2);

		// Verificamos que las viviendas han sido añadidas
		List<Vivienda> viviendas = inmobiliaria.findAll();
		assertEquals(2, viviendas.size(), "La inmobiliaria debe tener 2 viviendas");
	}

}
