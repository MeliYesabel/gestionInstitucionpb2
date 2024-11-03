package ar.edu.unlam.gestionInstitucion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testPrimaria {

	@Test
	public void anotarUnAlumnoAPrimerGrado() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado primero = (Grado) primaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 6, dni = 1111;
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);
		
		primero.agregarAlumno(alumno);
		
		assertEquals(1, primero.alumnos.size());

	}

	@Test
	public void anotarDosAluminoAPrimerGrado() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado primero = (Grado) primaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 6, dni = 1111;
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		Alumno alumno2 = new Alumno("Ami", "lulu", 6, 222);
		alumno.getExpediente().setJardin(true);
		alumno2.getExpediente().setJardin(true);

		
		primero.agregarAlumno(alumno);
		primero.agregarAlumno(alumno2);
		
		assertEquals(2, primero.alumnos.size());

	}

	@Test (expected = RequisitoNoCumplidoException.class)
	public void noAnotarUnAlumnoAPrimerGradoSiNoTieneLaEdadMinima() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado primero = (Grado) primaria.getDivisiones().get("Primero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 5, dni = 1111;

		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);

		primero.agregarAlumno(alumno);
		
		assertEquals(0, primero.alumnos.size()); 

	}

	@Test
	public void registrarEnAlumnoGradoAprobados() {
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 6, dni = 1111;
		Alumno alumno = new Alumno(nombre, apellido, edad, dni);

		Grado primerGrado = new Grado("Primero", 6);
		Grado segundoGrado = new Grado("Segundo", 6);
		Grado tercerGrado = new Grado("Tercero", 6);

		alumno.getExpediente().agregarGrado(primerGrado);
		alumno.getExpediente().agregarGrado(segundoGrado);
		alumno.getExpediente().agregarGrado(tercerGrado);

		assertEquals(3, alumno.getExpediente().getGrados().size());
	}

	@Test
	public void anotarUnAluminoASegundoGradoConElCursoPrevioAprobado() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado segundo = (Grado) primaria.getDivisiones().get("Segundo");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 7, dni = 1111;

		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);
		Grado grado = new Grado("Primero", 6);
		alumno.getExpediente().agregarGrado(grado);

		
		segundo.agregarAlumno(alumno);
		
		assertEquals(1, segundo.alumnos.size());
	}

	@Test (expected = RequisitoNoCumplidoException.class)
	public void NOanotarUnAluminoASegundoGradoConElCursoPrevioAprobado() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado segundo = (Grado) primaria.getDivisiones().get("Segundo");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 7, dni = 1111;

		Alumno alumno = new Alumno(nombre, apellido, edad, dni);
		alumno.getExpediente().setJardin(true);

		segundo.agregarAlumno(alumno);
		
		assertEquals(0, segundo.alumnos.size());
	}

	@Test
	public void anotarUnDocenteACuarto() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado cuarto = (Grado) primaria.getDivisiones().get("Cuarto");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 7, dni = 1111;

		Docente docente = new Docente(nombre, apellido, edad, dni);
		Grado grado = new Grado("Cuarto", 9);
		docente.agregarExperienciaPrimaria(grado);

		cuarto.agregarDocente(docente);

		assertEquals(1, cuarto.getDocentes().size());
		assertTrue(cuarto.getDocentes().contains(docente));
	}

	@Test (expected = RequisitoNoCumplidoException.class)
	public void noAnotarUnDocenteACuartoSiNoTieneExperiencienciaEnCuarto() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado cuarto = (Grado) primaria.getDivisiones().get("Cuarto");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 7, dni = 1111;

		Docente docente = new Docente(nombre, apellido, edad, dni);

		cuarto.agregarDocente(docente);

		assertEquals(0, cuarto.getDocentes().size());

	}

	@Test (expected = RequisitoNoCumplidoException.class)
	public void noAgregarMasDeDosProfesoresATercerGrado() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado tercero = (Grado) primaria.getDivisiones().get("Tercero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 7, dni = 1111;

		Docente docente = new Docente(nombre, apellido, edad, dni);
		Docente docente2 = new Docente(nombre, apellido, edad, 222);
		Grado grado = new Grado("Tercero", 8);
		docente.agregarExperienciaPrimaria(grado);
		docente2.agregarExperienciaPrimaria(grado);

		tercero.agregarDocente(docente);
		tercero.agregarDocente(docente2);
		
	}

	@Test
	public void evaluarUnAlumno() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado tercero = (Grado) primaria.getDivisiones().get("Tercero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 7, dni = 1111, nota = 10, dniDeAlumno = 222;
		Alumno alumno = new Alumno(nombre, apellido, 9, dniDeAlumno);
		Docente docente = new Docente(nombre, apellido, edad, dni);
		docente.agregarExperienciaPrimaria(tercero);

		Evaluacion evaluacion = new Evaluacion(null, tercero, nota);
		Grado grado = new Grado("Segundo", 7);
		alumno.getExpediente().agregarGrado(grado);
		tercero.agregarAlumno(alumno);
		docente.evaluarAlumnoDePrimari(alumno, evaluacion);

		assertTrue(alumno.getNotas().contains(evaluacion));
	}

	@Test
	public void noevaluarUnAlumnoSiElProfesorNoEstaCapacitado() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado tercero = (Grado) primaria.getDivisiones().get("Tercero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 7, dni = 1111, nota = 10, dniDeAlumno = 222;
		Alumno alumno = new Alumno(nombre, apellido, 9, dniDeAlumno);
		Docente docente = new Docente(nombre, apellido, edad, dni);

		Evaluacion evaluacion = new Evaluacion(null, tercero, nota);
		Grado grado = new Grado("Segundo", 7);
		alumno.getExpediente().agregarGrado(grado);
		tercero.agregarAlumno(alumno);

		assertThrows(RequisitoNoCumplidoException.class, () -> {
			docente.evaluarAlumnoDePrimari(alumno, evaluacion);
		});
	}

	@Test
	public void noevaluarUnAlumnoSiElNoEstaEnElCurso() throws RequisitoNoCumplidoException {
		Primaria primaria = new Primaria();
		Grado tercero = (Grado) primaria.getDivisiones().get("Tercero");
		String nombre = "pepe", apellido = "pepon";
		Integer edad = 7, dni = 1111, nota = 10, dniDeAlumno = 222;
		Alumno alumno = new Alumno(nombre, apellido, 9, dniDeAlumno);
		Docente docente = new Docente(nombre, apellido, edad, dni);

		Evaluacion evaluacion = new Evaluacion(null, tercero, nota);
		Grado grado = new Grado("Segundo", 7);
		alumno.getExpediente().agregarGrado(grado);
		tercero.agregarAlumno(alumno);

		assertThrows(RequisitoNoCumplidoException.class, () -> {
			docente.evaluarAlumnoDePrimari(alumno, evaluacion);
		});

	}


}
