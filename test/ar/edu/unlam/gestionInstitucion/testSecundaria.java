package ar.edu.unlam.gestionInstitucion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testSecundaria {
	@Test
	public void anotarAUnAlumnoAPrimerAno() throws RequisitoNoCumplidoException {
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);
		alumno.getExpediente().setPrimaria(true);
		
		primero.agregarAlumno(alumno);
		
		assertEquals(1, primero.alumnos.size());

	}
	
	@Test (expected = RequisitoNoCumplidoException.class)
	public void noAnotarAUnAlumnoAPrimerAnoCuandoNoTieneLaPrimariaCompleta() throws RequisitoNoCumplidoException {
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);
		alumno.getExpediente().setPrimaria(false);
		
		primero.agregarAlumno(alumno);
	}
	
	@Test (expected = RequisitoNoCumplidoException.class)
	public void noAnotarAUnAlumnoAPrimerAnoCuandoNoTieneElJardinCompleto() throws RequisitoNoCumplidoException {
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(false);
		alumno.getExpediente().setPrimaria(true);
		
		primero.agregarAlumno(alumno);
	}
	
	@Test (expected = RequisitoNoCumplidoException.class)
	public void noAnotarAUnAlumnoASegundoAnoCuandoTieneDoceAnos() throws RequisitoNoCumplidoException {
		Secundaria secundaria = new Secundaria();
		Division segundo = (Division) secundaria.getDivisiones().get("Segundo");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(false);
		alumno.getExpediente().setPrimaria(true);
		
		segundo.agregarAlumno(alumno);
	}
	
	@Test
	public void agregarLaMateriaProgramacionAlPlanDeEstudioDePrimero() {
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");

		Materia materia = new Materia("Programación");
		
		primero.getCargaAcademicaAnual().add(materia);
		
		assertEquals(1, primero.getCargaAcademicaAnual().size());
	}
	
	@Test
	public void noagregarDosVecesLaMateriaProgramacionAlPlanDeEstudioDePrimero() {
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");

		Materia materia = new Materia("Programación");
		Materia materia2 = new Materia("Programación");
		
		primero.getCargaAcademicaAnual().add(materia);
		primero.getCargaAcademicaAnual().add(materia);
		primero.getCargaAcademicaAnual().add(materia2);
		
		assertEquals(1, primero.getCargaAcademicaAnual().size());
	}
	
	@Test(expected = RequisitoNoCumplidoException.class)
	public void noasignarUnDocenteAlaMateriaDeProgramacionDePrimerAñoSiNoTieneLaExperiencia() throws RequisitoNoCumplidoException {
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Docente docente = new Docente(nombre, apellido, edad, dni);

		Materia materia = new Materia("Programación");

		primero.getCargaAcademicaAnual().add(materia);
		materia.agregarDocente(docente);

	}
	@Test
	public void asignarUnDocenteAlaMateriaDeProgramacionDePrimerAño() throws RequisitoNoCumplidoException {
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Docente docente = new Docente(nombre, apellido, edad, dni);

		Materia materia = new Materia("Programación");
			
		primero.getCargaAcademicaAnual().add(materia);
		docente.adoptarExperienciaEnMateria(materia);
		materia.agregarDocente(docente);
		
		assertEquals(docente, materia.getDocente());
	}
	
	@Test
	public void docenteEvaluaAlumnoDePrimerAnoDeLaMateriaDeProgramacion() throws RequisitoNoCumplidoException{
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Docente docente = new Docente(nombre, apellido, edad, dni);
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);
		alumno.getExpediente().setPrimaria(true);
		Materia materia = new Materia("Programación");
		Evaluacion evaluacion = new Evaluacion(null, primero, materia, 10);
		primero.agregarAlumno(alumno);	
		primero.getCargaAcademicaAnual().add(materia);
		docente.adoptarExperienciaEnMateria(materia);
		materia.agregarDocente(docente);
		
		docente.evaluarAlumnoPorMateria(alumno, evaluacion);
			
		assertEquals(1, alumno.getNotas().size());
	}
	
	@Test(expected = RequisitoNoCumplidoException.class)
	public void docenteNOEvaluaAlumnoDePrimerAnoDeLaMateriaDeProgramacionPorqueNoTieneExperiencia() throws RequisitoNoCumplidoException{
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Docente docente = new Docente(nombre, apellido, edad, dni);
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);
		alumno.getExpediente().setPrimaria(true);
		Materia materia = new Materia("Programación");
		Evaluacion evaluacion = new Evaluacion(null, primero, materia, 10);
		primero.agregarAlumno(alumno);	
		primero.getCargaAcademicaAnual().add(materia);
		materia.agregarDocente(docente);
		
		docente.evaluarAlumnoPorMateria(alumno, evaluacion);
			
	}
	
	@Test(expected = RequisitoNoCumplidoException.class)
	public void docenteNOEvaluaAlumnoDePrimerAnoDeLaMateriaDeProgramacionPorqueEstaEnPrimerAño() throws RequisitoNoCumplidoException{
		Secundaria secundaria = new Secundaria();
		Division primero = (Division) secundaria.getDivisiones().get("Primero");
		Division segundo = (Division) secundaria.getDivisiones().get("Segundo");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 12, dni = 1111;
		Docente docente = new Docente(nombre, apellido, edad, dni);
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);
		alumno.getExpediente().setPrimaria(true);
		Materia materia = new Materia("Programación");
		Evaluacion evaluacion = new Evaluacion(null, primero, materia, 10);
		segundo.agregarAlumno(alumno);	
		primero.getCargaAcademicaAnual().add(materia);
		materia.agregarDocente(docente);
		
		docente.evaluarAlumnoPorMateria(alumno, evaluacion);
			
		assertEquals(0, alumno.getNotas().size());
	}
	
	

	
	
}
