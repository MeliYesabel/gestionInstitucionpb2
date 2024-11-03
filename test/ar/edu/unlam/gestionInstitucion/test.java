package ar.edu.unlam.gestionInstitucion;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class test {

	@Test
	public void crearUnaInstitucionQueContengaJardinPrimariaSecundaria() {
		String nombre = "";
		Institucion nueva = new Institucion(nombre);
		
		Jardin jardin = new Jardin();
		Primaria primaria = new Primaria();
		Secundaria secundaria = new Secundaria();
		
		nueva.agregarNivelEducativo(jardin);
		nueva.agregarNivelEducativo(primaria);
		nueva.agregarNivelEducativo(secundaria);
		
		assertEquals(3, nueva.getNivelesEducativos().size());
	}
	@Test
	public void obtenerUnListadoDeLosAlumnosPorOrdenNaturalQueEstanInscriptoEnSecundaria() {
	    Secundaria secundaria = new Secundaria();
	    Division primero = (Division) secundaria.getDivisiones().get("Primero");
	    
	    TreeSet<Alumno> alumnos = new TreeSet<>();
	    
	    Alumno alumno1 = new Alumno("Pepe", "Pepon", 12, 1111);
	    alumno1.getExpediente().setJardin(true);
	    alumno1.getExpediente().setPrimaria(true);

	    Alumno alumno2 = new Alumno("Juan", "Perez", 13, 1112);
	    alumno2.getExpediente().setJardin(true);
	    alumno2.getExpediente().setPrimaria(true);

	    Alumno alumno3 = new Alumno("Maria", "Gomez", 14, 1113);
	    alumno3.getExpediente().setJardin(true);
	    alumno3.getExpediente().setPrimaria(true);

	    Alumno alumno4 = new Alumno("Ana", "Lopez", 15, 1114);
	    alumno4.getExpediente().setJardin(true);
	    alumno4.getExpediente().setPrimaria(true);

	   
	    alumnos.add(alumno1);
	    alumnos.add(alumno2);
	    alumnos.add(alumno3);
	    alumnos.add(alumno4);
	    primero.getAlumnos().addAll(alumnos);

	    String orden = "[" + alumno4 +", "+ alumno2  +", "+alumno3 +", "+alumno1 + "]";
	    
	    assertEquals(4, primero.getAlumnos().size());
	    assertEquals(orden, primero.getAlumnos().toString());
	
	}
	
	@Test
	public void obtenerUnListadoDeLosAlumnosDePrimeroDePrimariaOrdenadosPorDNI() {
		Primaria primaria = new Primaria();
	    Grado primero = (Grado) primaria.getDivisiones().get("Primero");
	    
	    TreeSet<Alumno> alumnos = new TreeSet<>();
	    
	    Alumno alumno1 = new Alumno("Pepe", "Pepon", 6, 5);
	    alumno1.getExpediente().setJardin(true);

	    Alumno alumno2 = new Alumno("Juan", "Perez", 6, 4);
	    alumno2.getExpediente().setJardin(true);

	    Alumno alumno3 = new Alumno("Maria", "Gomez", 6, 3);
	    alumno3.getExpediente().setJardin(true);

	    Alumno alumno4 = new Alumno("Ana", "Lopez", 6, 6);
	    alumno4.getExpediente().setJardin(true);
   
	    alumnos.add(alumno1);
	    alumnos.add(alumno2);
	    alumnos.add(alumno3);
	    alumnos.add(alumno4);
	    primero.getAlumnos().addAll(alumnos);

	    String orden = "[" + alumno3 +", "+ alumno2  +", "+alumno1 +", "+alumno4 + "]";
	    
	    assertEquals(4, primero.getAlumnosPorDNIMenorAMayor().size());
	    assertEquals(orden, primero.getAlumnosPorDNIMenorAMayor().toString());
	}
	
	@Test
	public void buscarAlumnoEnSalaRojaPorDNI() throws RequisitoNoCumplidoException {
		Jardin jardin = new Jardin();
	    Sala rojo = (Sala) jardin.getDivisiones().get("Roja");
	    
	    Alumno alumno1 = new Alumno("Pepe", "Pepon", 4, 1235);
	    Alumno alumno2 = new Alumno("Juan", "Perez", 4, 4123);
	    Alumno alumno3 = new Alumno("Maria", "Gomez", 5, 1233);
	    Alumno alumno4 = new Alumno("Ana", "Lopez", 5, 6231);

	    rojo.agregarAlumno(alumno1);
	    rojo.agregarAlumno(alumno2);
	    rojo.agregarAlumno(alumno3);
	    rojo.agregarAlumno(alumno4);

	    Alumno buscado = new Alumno("Pepe", "Pepon", 4, 1235);
	    
	    assertEquals(buscado, rojo.obtenerAlumno(1235) );
	}
	
	@Test
	public void tomarAsistenciaDeJardin() throws RequisitoNoCumplidoException, FechaUtilizadaExption {
		Jardin jardin = new Jardin();
	    Sala rojo = (Sala) jardin.getDivisiones().get("Roja");
	    
	    Alumno alumno1 = new Alumno("Pepe", "Pepon", 4, 1235);
	    Alumno alumno2 = new Alumno("Juan", "Perez", 4, 4123);
	    Alumno alumno3 = new Alumno("Maria", "Gomez", 5, 1233);
	    Alumno alumno4 = new Alumno("Ana", "Lopez", 5, 6231);

	    rojo.agregarAlumno(alumno1);
	    rojo.agregarAlumno(alumno2);
	    rojo.agregarAlumno(alumno3);
	    rojo.agregarAlumno(alumno4);
	    
	    Date fechaDeHoy = new Date();
	    Boolean opcion = true;
	    Asistencia test = new Asistencia(fechaDeHoy, opcion);
	    
	    for (Alumno a : rojo.getAlumnos()) {
	    	rojo.tomarAsistencia(fechaDeHoy, a, opcion);
		}
	    
	    assertTrue(alumno1.getAsistencias().contains(test));
	    assertTrue(alumno2.getAsistencias().contains(test));
	    assertTrue(alumno3.getAsistencias().contains(test));
	    assertTrue(alumno4.getAsistencias().contains(test));

	}
	
	@Test (expected = FechaUtilizadaExption.class)
	public void NOtomarAsistenciaDeJardinSiLaFechaRegistradaYaTieneInformacion() throws RequisitoNoCumplidoException, FechaUtilizadaExption  {
		Jardin jardin = new Jardin();
	    Sala rojo = (Sala) jardin.getDivisiones().get("Roja");
	    
	    Alumno alumno1 = new Alumno("Pepe", "Pepon", 4, 1235);
	    Alumno alumno2 = new Alumno("Juan", "Perez", 4, 4123);
	    Alumno alumno3 = new Alumno("Maria", "Gomez", 5, 1233);
	    Alumno alumno4 = new Alumno("Ana", "Lopez", 5, 6231);

	    rojo.agregarAlumno(alumno1);
	    rojo.agregarAlumno(alumno2);
	    rojo.agregarAlumno(alumno3);
	    rojo.agregarAlumno(alumno4);
	    
	    Date fechaDeHoy = new Date();
	    Boolean opcion = true;
	    //Primera vez
	    for (Alumno a : rojo.getAlumnos()) {
	    	rojo.tomarAsistencia(fechaDeHoy, a, opcion);
		}
	    
	    //Segunda vez no tendria que poder 
	    for (Alumno a : rojo.getAlumnos()) {
	    	rojo.tomarAsistencia(fechaDeHoy, a, opcion);
		}   
	    
	}
	
}
