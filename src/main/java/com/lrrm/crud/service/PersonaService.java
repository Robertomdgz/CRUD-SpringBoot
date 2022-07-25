package com.lrrm.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrrm.crud.model.Persona;
import com.lrrm.crud.model.PersonaBean;
import com.lrrm.crud.model.DAO.PersonaRepository;

@Service
public class PersonaService{
	@Autowired
	private PersonaRepository repository;

	public List<Persona> readAll() {
		return repository.readAll();
	}

	public PersonaBean readOne(Integer id) {
		return repository.readOne(id).toBean();
	}

	public void delete(int id) {
		repository.delete(id);
	}

	public void create(PersonaBean personaBean) {
		Persona persona = new Persona();
		persona.assamble(personaBean);
		repository.create(persona);
	}

	public Persona update(PersonaBean personaBean) {
		Persona persona = new Persona();
		persona.assamble(personaBean);
		repository.update(persona);
		return persona;
	}

}
