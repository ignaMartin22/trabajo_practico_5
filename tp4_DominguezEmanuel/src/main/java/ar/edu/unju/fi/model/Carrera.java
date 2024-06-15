package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Component
public class Carrera {

	private int codigo;
	private String nombre;
	private byte cantidadAnios;
	private Boolean estado;
	
	public Carrera() {
		
	}

	public Carrera(int codigo, String nombre, byte cantidadAnios, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
	}


	
}
