package com.lrrm.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	private Integer idPersona;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	public void assamble(PersonaBean personaBean) {
		this.idPersona = Integer.parseInt(personaBean.getIdPersona());
		this.nombre = personaBean.getNombre();
		this.apellidoMaterno = personaBean.getApellidoMaterno();
		this.apellidoPaterno = personaBean.getApellidoPaterno();
	}
	public PersonaBean toBean() {
		PersonaBean personaBean = new PersonaBean();
		personaBean.setIdPersona(String.valueOf(this.idPersona));
		personaBean.setNombre(this.nombre);
		personaBean.setApellidoPaterno(this.apellidoPaterno);
		personaBean.setApellidoMaterno(this.apellidoMaterno);
		return personaBean;
	}
}
