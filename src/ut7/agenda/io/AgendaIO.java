package ut7.agenda.io; 

import ut7.agenda.modelo.*;
 
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

	/**
	 * 
	 * @return un array de String con todas las líneas de información de todos
	 *         los contactos. 1 significa contacto profesional, 2 significa
	 *         contacto personal
	 */
	private static String[] obtenerLineasDatos() {
		return new String[] {
				"1, Isabel, Acosta Mendioroz,  678895433 ,  iacostamen@gmail.com ,  walden estrella ",
				"2,  pedro , urruti tello , 616789654 ,  urrutitello@gmail.com , 09/03/2007, amigos",
				"1, Angel , Esteban Grande , 674544123 ,  aestebang@gmail.com ,  magma publicidad ",
				"2, elena , bueno ganuza , 6786547699 ,  ebuenogan@gmail.com , 17/03/2000, amigos",
				"2, amaia , romero sein , 642222343 ,  aromerosein@gmail.com , 09/03/2012, pareja",
				"2, Ignacio ,  Anto roth ,  688912799 , iantoroth@gmail.com ,  11/11/1969 , padre",
				"1,  Isabel ,  Acosta Marin , 678895433 ,  iacostamar@gmail.com ,  publicidad holdings ",
				"1 ,    roberto , casas maura , 666777888 ,  rocasasma@gmail.com ,  strato banca ",
				"1,juan maria, garcía oliva, 699898111, jmgarcioliva@gmail.com, conway motor ",
				"2, pedro , urruti tello , 616789654 ,  urrutitello@gmail.com , 17/03/2000, amigos",
				"1,marta, sanz iris, 622999876, msanzi@gmail.com, jump literatura ",
				"1,javier, porto luque, 691256777 , japorlu@gmail.com, gas natural ",
				"1,pablo, ponce larraoz, 689123456, pabloponce@gmail.com, la caixa",
				"1, javier, marin lancho, 666666666, jruizlanchoe@gmail.com, bbva",
				"1,juan maria, garcía oliva, 699898111, jmgarcioliva@gmail.com, conway motor ",
				"2, Berta ,  andia solano ,  621123345 , bandiasol@gmail.com ,  12/12/1999 ,  HIJA",
				"2, Ignacio ,  Anto roth ,  688912799 , iantoroth@gmail.com ,  11/11/1969 , padre",
				"  1,  roberto , casas maura , 666777888 ,  rocasasma@gmail.com ,  strato banca ",
				" 2, daniel , martin martin , 678901234 ,  damrtinmartin@gmail.com , 15/07/1980, amigos",
				"  2, pablo , martin abradelo , 667788899 ,  martinabra@gmail.com , 31/01/2010, amigos",
				"  2, susana , santaolalla bilbao , 676767676 ,  ssantaolalla@gmail.com , 17/03/1998, amigos",
				"  2, adur ,  martin merino ,  611112113 , adurmartinme@gmail.com ,  14/02/2003 , amigos" };

	}

}
