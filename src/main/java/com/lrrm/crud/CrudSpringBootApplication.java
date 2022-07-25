package com.lrrm.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner{
	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("DROP TABLE PUBLIC.PERSONA IF EXISTS");
		template.execute("CREATE TABLE PUBLIC.PERSONA("
				+ "idPersona INT AUTO_INCREMENT,"
				+ "nombre VARCHAR(255),"
				+ "apellidoPaterno VARCHAR(255),"
				+ "apellidoMaterno VARCHAR(255),"
				+ "PRIMARY KEY(idPersona)"
				+ ")");
		template.update("INSERT INTO PERSONA(nombre,apellidoPaterno,apellidoMaterno)"
				+ " VALUES('Luis Roberto','Rodríguez','Méndez')");
	}

}
