package Control3_25_CDC1.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Control3_25_CDC1.model.Dao;
import Control3_25_CDC1.model.Vivienda;

public class Inmobiliaria implements Dao<Vivienda> {

    private Map<Integer, Vivienda> viviendas;
    private int currentId;

    public Inmobiliaria() {
        viviendas = new HashMap<>();
        currentId = 1;  // El primer ID que se asignará a la vivienda será 1
    }
    
    public Map<Integer, Vivienda> getViviendas() {
        return viviendas;
    }

    @Override
    public void save(Vivienda vivienda) {
        viviendas.put(currentId, vivienda);
        System.out.println("Vivienda añadida con ID: " + currentId);
        currentId++;  // Incrementamos el ID para la siguiente vivienda
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
            System.out.println("Vivienda eliminada con ID: " + keyToRemove);
        } else {
            System.out.println("Vivienda no encontrada.");
        }
    }
    
    @Override
    public Vivienda findById(int key) {
        return viviendas.get(key);  // Buscamos la vivienda por su clave (ID)
    }

    @Override
    public void update(Vivienda vivienda, int key) {
        if (viviendas.containsKey(key)) {
            viviendas.put(key, vivienda);
            System.out.println("Vivienda actualizada con ID: " + key);
        } else {
            System.out.println("Vivienda no encontrada con ID: " + key);
        }
    }

    @Override
    public void delete(int key) {
        if (viviendas.remove(key-1) != null) {
            System.out.println("Vivienda eliminada con ID: " + key);
        } else {
            System.out.println("Vivienda no encontrada con ID: " + key);
        }
    }

   
    // Mostar las viviendas, junto a su ID
    public void mostrarTodas() {
        System.out.println("Viviendas en la inmobiliaria:");
        for (Map.Entry<Integer, Vivienda> entry : viviendas.entrySet()) {
            System.out.println("ID: " + entry.getKey());
            entry.getValue().mostrarInformacion();
            System.out.println("------------");
        }
    }

	@Override
	public List<Vivienda> findAll() {
		return new ArrayList<>(getViviendas().values());
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
