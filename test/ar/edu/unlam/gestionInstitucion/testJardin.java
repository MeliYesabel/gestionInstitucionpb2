package ar.edu.unlam.gestionInstitucion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class testJardin {

	@Test
	public void alcrearJardinseCreanSalasCelesteVerdeAzulRoja() {

		Jardin jardin = new Jardin();
		
		Sala celeste = (Sala) jardin.getDivisiones().get("Celeste");
		Sala verde = (Sala) jardin.getDivisiones().get("Verde");
		Sala azul = (Sala) jardin.getDivisiones().get("Azul");
		Sala roja = (Sala) jardin.getDivisiones().get("Roja");	
		
		assertEquals("Nombre Celeste, Edad minima 2", celeste.toString());
		assertEquals("Nombre Verde, Edad minima 3", verde.toString());
		assertEquals("Nombre Azul, Edad minima 4", azul.toString());
		assertEquals("Nombre Roja, Edad minima 5", roja.toString());
		
	}
	
	@Test
	public void agregarDocenteASalaRoja() {
		Jardin jardin = new Jardin();		
		Sala roja = (Sala) jardin.getDivisiones().get("Roja");	
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 30, dni = 1111;
		Boolean esMaestro = true;		
		
		Docente maestra = new Docente(nombre, apellido, edad,  dni);
		maestra.getExpediente().setJardin(esMaestro);
		Boolean test = roja.agregarDocente(maestra);
		
		assertTrue(test);
	}
	
	@Test
	public void noagregarDocenteASalaRojaSiNoEsMaestro() {
		Jardin jardin = new Jardin();		
		Sala roja = (Sala) jardin.getDivisiones().get("Roja");	
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 30, dni = 1111;
		Boolean esMaestro = false;		
		
		Docente maestra = new Docente(nombre, apellido, edad,  dni);
		maestra.getExpediente().setJardin(esMaestro);
		Boolean test = roja.agregarDocente(maestra);
		
		assertFalse(test);
	}
	
	@Test
	public void agregarDosDocenteASalaRoja() {
		Jardin jardin = new Jardin();		
		Sala roja = (Sala) jardin.getDivisiones().get("Roja");	
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 30, dni = 1111;
		Boolean esMaestro = true;		
		
		Docente maestra = new Docente(nombre, apellido, edad,  dni);
		maestra.getExpediente().setJardin(esMaestro);
		Docente maestra2 = new Docente(nombre, apellido, edad,  (dni+1));
		maestra2.getExpediente().setJardin(esMaestro);
		
		roja.agregarDocente(maestra2);
		Boolean test = roja.agregarDocente(maestra);
		
		assertTrue(test);
	}
	
	@Test
	public void noagregarTresDocenteASalaRoja() {
		Jardin jardin = new Jardin();		
		Sala roja = (Sala) jardin.getDivisiones().get("Roja");	
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 30, dni = 1111;
		Boolean esMaestro = true;		
		
		Docente maestra = new Docente(nombre, apellido, edad,  dni);
		maestra.getExpediente().setJardin(esMaestro);
		Docente maestra2 = new Docente(nombre, apellido, edad,(dni+1));
		maestra2.getExpediente().setJardin(esMaestro);
		Docente maestra3 = new Docente(nombre, apellido, edad,(dni+2));
		maestra3.getExpediente().setJardin(esMaestro);
		
		roja.agregarDocente(maestra2);
		roja.agregarDocente(maestra3);
		Boolean test = roja.agregarDocente(maestra);
		
		assertFalse(test);
	}
	
	@Test
	public void noagregarDosVecesElMismoDocenteDelMismoDNIASalaRoja() {
		Jardin jardin = new Jardin();		
		Sala roja = (Sala) jardin.getDivisiones().get("Roja");	
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 30, dni = 1111;
		Boolean esMaestro = true;		
		
		Docente maestra = new Docente(nombre, apellido, edad,  dni);
		maestra.getExpediente().setJardin(esMaestro);
		Docente maestra2 = new Docente(nombre, apellido, edad, dni);
		maestra2.getExpediente().setJardin(esMaestro);
		
		
		roja.agregarDocente(maestra2);
		Boolean test = roja.agregarDocente(maestra);
		
		assertFalse(test);
	}
	
	@Test
	public void agregar10AlumnosASalaVerde() {
		Jardin jardin = new Jardin();		
		Sala verde = (Sala) jardin.getDivisiones().get("Verde");
		
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 30, dni = 1111;
		
		for (int i = 0; i < 10; i++) {
			verde.agregarAlumno(new Alumno(nombre, apellido, edad, dni));
			dni++;
		}
		
		assertEquals(10, verde.getAlumnos().size());
	}
	@Test
	public void noSuperarElLimiteDeAlumnosASalaVerde() {
		Jardin jardin = new Jardin();		
		Sala verde = (Sala) jardin.getDivisiones().get("Verde");
		
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 30, dni = 1111;
		
		for (int i = 0; i < verde.getLIMITE_CANTIDAD_ALUMNOS() + 3; i++) {
			verde.agregarAlumno(new Alumno(nombre, apellido, edad, dni));
			dni++;
		}
	
		assertNotEquals(verde.getLIMITE_CANTIDAD_ALUMNOS() + 3, verde.getAlumnos().size());
	}
	@Test 
	public void NOagrega2vecesElMismoAlumnoASalaVerde() {
		Jardin jardin = new Jardin();		
		Sala verde = (Sala) jardin.getDivisiones().get("Verde");
		
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 5, dni = 1111;
		
		verde.agregarAlumno(new Alumno(nombre, apellido, edad, dni));
		verde.agregarAlumno(new Alumno(nombre, apellido, edad, dni));
		verde.agregarAlumno(new Alumno(nombre, apellido, edad, dni));
		
		assertEquals(1, verde.alumnos.size());
	}

}
