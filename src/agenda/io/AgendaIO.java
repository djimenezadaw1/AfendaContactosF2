package agenda.io; 

import agenda.modelo.*;
 
/**
 * Utilidades para cargar la agenda
 * 
 * @author Alex Calderón, Irune Arratibel, Daniel Jiménez
 * @version 1.0
 *
 
 */

/**
 * A partir de los datos obtenidos por el método obtenerLineasDatos,
 * cargamos todos los contactos en el parametro agenda.
 * @param AgendaContactos agenda (donde meteremos los contactos)
 * 
 */
public class AgendaIO {

	public static void importar(AgendaContactos agenda) {
		String[] contactos = obtenerLineasDatos();
		for(int i=0;i<contactos.length;i++) {
			Contacto nuevo = parsearLinea(contactos[i]);
			agenda.añadirContacto(nuevo);
		}
	}
	
	/**
	 * De una linea crea un objeto dependiendo de que tipo de contacto sea.
	 * Los datos vienen separados por comas y tienen espacios al principio y al final.
	 * @param String linea (la linea con los datos)
	 * @return Contacto 
	 */
	private static Contacto parsearLinea(String linea) {
		String[] datos = linea.split(",");
		String tipo = datos[0].trim();
		String nombre = datos[1].trim();
		String apellidos = datos[2].trim();
		String tel = datos[3].trim();
		String email = datos[4].trim();
		if(Integer.parseInt(tipo) == 1) {
			String empresa = datos[5].trim();
			Contacto prof = new Profesional(nombre, apellidos, tel, email, empresa);
			return prof;
		}
		if(Integer.parseInt(tipo) == 2) {
			String fecha = datos[5].trim();
			String relacion = datos[6].trim();
			Relacion rel = Relacion.PADRE;
			if(relacion.equalsIgnoreCase("PADRE")) {
				rel = Relacion.PADRE;
			}
			if(relacion.equalsIgnoreCase("MADRE")) {
				rel = Relacion.MADRE;
			}
			if(relacion.equalsIgnoreCase("AMIGOS")) {
				rel = Relacion.AMIGOS;
			}
			if(relacion.equalsIgnoreCase("PAREJA")) {
				rel = Relacion.PAREJA;
			}
			if(relacion.equalsIgnoreCase("HIJO")) {
				rel = Relacion.HIJO;
			}
			if(relacion.equalsIgnoreCase("HIJA")) {
				rel = Relacion.HIJA;
			}
			Contacto pers = new Personal(nombre, apellidos, tel, email, fecha, rel);
			return pers;
		}
		return null;
	}

	

}
