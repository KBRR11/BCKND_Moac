package pe.edu.upeu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.ToStringConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.upeu.dao.EscuelasProfesionalesDao;
import pe.edu.upeu.dao.UsuariosDao;
import pe.edu.upeu.entity.EscuelasProfesionales;
import pe.edu.upeu.entity.Usuarios;


@SpringBootTest
class MovilidadAcademidaBckndApplicationTests {
	@Autowired
	UsuariosDao usuariosDao;
	@Autowired
	EscuelasProfesionalesDao epDao;
	
	/*@Test
	void updateColores() {
		Usuarios us = new Usuarios(1,"white_content","red");
		usuariosDao.update_colores(us);
	}*/
	
	/*@Test
	void epForId() {
	assertTrue(epDao.readEpForFAC(3)!=null);
	}*/
	
	@Test
	void autentificarUser() {

		assertTrue(usuariosDao.validarUsuario("salma")!=null);
	}
}
