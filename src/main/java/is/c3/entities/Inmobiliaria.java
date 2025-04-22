package is.c3.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import is.c3.model.GestionStock;
import is.c3.model.Vivienda;

/**
 * Clase para gestionar el stock de viviendas en una inmobiliaria
 */
public class Inmobiliaria implements GestionStock<Vivienda> {
	private static Logger log = Logger.getLogger(Inmobiliaria.class.getName());

	private Map<Integer, Vivienda> viviendas;
	private int currentId;

	public Inmobiliaria() {
		viviendas = new HashMap<>();
		currentId = 0;
	}

	public Map<Integer, Vivienda> getViviendas() {
		return viviendas;
	}

	@Override
	public void save(Vivienda vivienda) {
		viviendas.put(currentId, vivienda);
		log.fine("Vivienda añadida con ID: " + currentId);
		currentId++; // Incrementamos el ID para la siguiente vivienda
	}

	@Override
	public void delete(Vivienda vivienda) {
		// Buscamos la vivienda por su referencia
		Integer keyToRemove = null;
		for (Map.Entry<Integer, Vivienda> entry : viviendas.entrySet()) {
			if (entry.getValue().equals(vivienda)) {
				keyToRemove = entry.getKey();
				break;
			}
		}

		if (keyToRemove != null) {
			viviendas.remove(keyToRemove);
			log.fine("Vivienda eliminada con ID: " + keyToRemove);
		} else {
			log.fine("Vivienda no encontrada.");
		}
	}

	@Override
	public Vivienda findById(int key)
	{
	
		return viviendas.get(key); // Buscamos la vivienda por su clave (ID)
	}

	@Override
	public void update(Vivienda vivienda, int key) {
		if (viviendas.containsKey(key)) {
			viviendas.put(key, vivienda);
			log.fine("Vivienda actualizada con ID: " + key);
		} else {
			log.fine("Vivienda no encontrada con ID: " + key);
		}
	}

	@Override
	public void delete(int key) {
		if (viviendas.remove(key) != null) {
			log.fine("Vivienda eliminada con ID: " + key);
		} else {
			log.fine("Vivienda no encontrada con ID: " + key);
		}
	}

	@Override
	public List<Vivienda> findAll() {
		log.fine("Viviendas en la inmobiliaria:");
		for (Map.Entry<Integer, Vivienda> entry : viviendas.entrySet()) {
			log.fine("ID: " + entry.getKey());
			entry.getValue().mostrarInformacion();
			log.fine("------------");
		}
		return viviendas.values().stream().collect(Collectors.toList());
	}

	@Override
	public void saveAll(Vivienda[] t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
}
