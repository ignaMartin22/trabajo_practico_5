package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {

	private static List<Docente> docentes = new ArrayList<Docente>();
	
	//Listar Docentes
	public static List<Docente> getDocentes(){
		if(docentes.isEmpty()) {
			docentes.add(new Docente("LEG-5551", "José Luis", "Zapana", "zapana2018@gmail.com", "388-456123"));
			docentes.add(new Docente("LEG-4203", "Miguel", "Salazar", "miguels4l4z4ar@gmail.com", "388-423-675"));
			docentes.add(new Docente("LEG-7894", "Fabiana", "Rodriguez", "fabir0drigu3z@gmail.com", "388-741-514"));
		}
		return docentes;
	}
	
	//Agregar Docente
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	
	//Eliminar Docente
	public static void eliminarDocente(String legajo) {
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			Docente doc = iterator.next();
			if (doc.getLegajo().equals(legajo)) {
				iterator.remove();
			}
		}
	}
	
	//Modificar Docente
	public static void modificarDocente(Docente docente) {
		for(Docente doc : docentes) {
			if(doc.getLegajo().equals(docente.getLegajo())) {
				doc.setLegajo(docente.getLegajo());
				doc.setNombre(docente.getNombre());
				doc.setApellido(docente.getApellido());
				doc.setEmail(docente.getEmail());
				doc.setTelefono(docente.getTelefono());
			}else {
				System.out.println("No se encontró al alumno");
			}
		}
	}
	
	//Buscar Docente
	public static Docente buscarDocente(String legajo) {
		Predicate<Docente> filterCodigo = d -> d.getLegajo().equals(legajo);
		Optional<Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
		if(docente.isPresent()) {
			return docente.get();
		}else {
			return null;
		}
	}
}