package com.lrrm.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lrrm.crud.model.Persona;
import com.lrrm.crud.model.PersonaBean;
import com.lrrm.crud.service.PersonaService;

@Controller
public class PersonaController {
	@Autowired
	private PersonaService service;
	
	@GetMapping({"/","/listar"})
	public String showAll(Model model) {
		model.addAttribute("personas", service.readAll());
		return "index";
	}
	
	@GetMapping("/registrarPersona")
	public String showCreateView(Model model) {
		Persona persona = new Persona();
		model.addAttribute("persona", persona);
		return "crear_persona";
	}
	
	@PostMapping("/persona")
	public String create(@Validated Persona persona) {
		service.create(persona);
		return "redirect:/listar";
	}
	
	@GetMapping("/editarPersona/{id}")
	public String showUpdateView(@PathVariable int id, Model model) {
		PersonaBean persona = service.readOne(id);
		model.addAttribute("persona", persona);
		return "editar_persona";
	}
	
	@PostMapping("/persona/actualizar")
	public String update(@Validated PersonaBean persona) {
		service.update(persona);
		return "redirect:/listar";
	}
	

}
