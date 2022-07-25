package com.lrrm.crud.model.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lrrm.crud.commons.CRUD;
import com.lrrm.crud.model.Persona;

@Repository
public class PersonaRepository implements CRUD<Persona>{
	@Autowired
	private JdbcTemplate template;
	private String sql;

	@Override
	public List<Persona> readAll() {
		sql = "SELECT * FROM persona";
		List<Persona> personas = template.query(sql, 
				new BeanPropertyRowMapper<Persona>(Persona.class));
		return personas;
	}

	@Override
	public Persona readOne(Integer id) {
		sql = "SELECT * FROM persona WHERE idPersona = ?";
		return template.queryForObject(sql, new Object[] {id},
				new BeanPropertyRowMapper<>(Persona.class));
	}

	@Override
	public void delete(Persona persona) {
		sql = "DELETE FROM PERSONA WHERE idPersona='" + persona.getIdPersona() +"'";
		template.update(sql);
	}

	@Override
	public void create(Persona persona) {
		sql = "INSERT INTO PERSONA(nombre,apellidoPaterno,apellidoMaterno)"
				+ " VALUES('"+ persona.getNombre() +"','"+ persona.getApellidoPaterno() 
				+ "','"+ persona.getApellidoMaterno() +"')";
		template.update(sql);
	}

	@Override
	public Persona update(Persona persona) {
		sql = "UPDATE PERSONA SET nombre = '"+ persona.getNombre() 
			+ "',apellidoPaterno='"+ persona.getApellidoPaterno() 
			+ "',apellidoMaterno='"+ persona.getApellidoMaterno() + "'"
			+ " WHERE idPersona='"+ persona.getIdPersona() +"'";
		template.update(sql);
		return persona;
	}


}
