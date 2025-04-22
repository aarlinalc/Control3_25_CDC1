package is.c3.controller;
import is.c3.entities.Piso;
import is.c3.entities.Inmobiliaria;


public class GestorInmobiliaria {
	public GestorInmobiliaria(Inmobiliaria inmobiliaria) {
		super();
		this.inmobiliaria = inmobiliaria;
	}

	private Inmobiliaria inmobiliaria;
	
	public static void main(String[] args) {
		
		// Crear una nueva instancia de la Inmobiliaria
		Inmobiliaria inmo = new Inmobiliaria();
		GestorInmobiliaria gestor=new GestorInmobiliaria(inmo);
		gestor.setInitialData();
		gestor.printData();	
		
	}
	private void setInitialData() {
		// Crear algunas viviendas (Pisos)
				Piso piso1 = new Piso("Calle Sol 1", "Laura", 0);
				Piso piso2 = new Piso("Calle Luna 2", "Pedro", 2);
				Piso piso3 = new Piso("Calle Estrella 3", "María", 3);

				// Añadir viviendas a la inmobiliaria
				inmobiliaria.save(piso1);
				inmobiliaria.save(piso2);
				inmobiliaria.save(piso3);
		
	}
    private void printData() {
    	System.out.println("Viviendas en la inmobiliaria de aarlinalc:");
		// Mostrar todas las viviendas en la inmobiliaria
		System.out.println(inmobiliaria.findAll());
    	
    }
}
