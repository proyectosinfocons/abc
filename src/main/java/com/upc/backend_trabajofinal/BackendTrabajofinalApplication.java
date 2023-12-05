package com.upc.backend_trabajofinal;

import com.upc.backend_trabajofinal.entidades.*;
import com.upc.backend_trabajofinal.negocio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class BackendTrabajofinalApplication implements CommandLineRunner {

    @Autowired
    ICursoNegocio cursoNegocio;
    @Autowired
    IHorarioNegocio horarioNegocio;
    @Autowired
    IPersonaNegocio personaNegocio;
    @Autowired
    IAlumnoNegocio alumnoNegocio;
    @Autowired
    ICalificacionNegocio calificacionNegocio;

    public static void main(String[] args) {
        SpringApplication.run(BackendTrabajofinalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cargarDatosIniciales();
    }

    private static final Random random = new Random();

    public static int obtenerNumeroAleatorio(int minimo, int maximo) {
        return random.nextInt(maximo - minimo + 1) + minimo;
    }

    private void cargarDatosIniciales() {
        // Insertar Cursos
        String[] arrayCurso = {"Matemáticas", "Literatura", "Química", "Física", "Religión", "Ciencias y Ambiente", "Economía", "Arte"};
        Long idCurso = 0L;

        for (var item : arrayCurso) {
            idCurso++;
            int creditos = obtenerNumeroAleatorio(2, 5);
            Curso curso = new Curso(idCurso, item, "Descripción de " + item, creditos);
            var insertCursos = cursoNegocio.registrarCurso(curso);
        }


        // Insertar Alumnos
        Persona personaAlumno1 = new Persona(1L,"Ricardo", "Trelles Mandingo", "42233301", "La Molina", "99888880", "ricardotm@abc.com", "12345678", "U2023001");
        Persona personaInsert1 = personaNegocio.registrarPersona(personaAlumno1);
        Alumno registAlumno1 = new Alumno(1L, personaInsert1, true);
        Alumno insertAlumno1 = alumnoNegocio.registrarAlumno(registAlumno1);

        Persona personaAlumno2 = new Persona(2L,"Roxana", "Llanos Quevedo", "42233302", "La Victoria", "99888881", "roxanallq@abc.com", "12345678", "U2023002");
        Persona personaInsert2 = personaNegocio.registrarPersona(personaAlumno2);
        Alumno registAlumno2 = new Alumno(2L, personaInsert2, true);
        Alumno insertAlumno2 = alumnoNegocio.registrarAlumno(registAlumno2);

        Persona personaAlumno3 = new Persona(3L,"Facundo", "Rabanal Moreno", "42233303", "San Luis", "99888882", "facundorm@abc.com", "12345678", "U2023003");
        Persona personaInsert3 = personaNegocio.registrarPersona(personaAlumno3);
        Alumno registAlumno3 = new Alumno(3L, personaInsert3, true);
        Alumno insertAlumno3 = alumnoNegocio.registrarAlumno(registAlumno3);

        Persona personaAlumno4 = new Persona(4L,"Marcelo", "Rojas Almandos", "42233304", "San Borja", "99888883", "marcelora@abc.com", "12345678", "U2023004");
        Persona personaInsert4 = personaNegocio.registrarPersona(personaAlumno4);
        Alumno registAlumno4 = new Alumno(4L, personaInsert4, true);
        Alumno insertAlumno4 = alumnoNegocio.registrarAlumno(registAlumno4);

        Persona personaAlumno5 = new Persona(5L,"Pedro", "Otiniano Lopez", "42233305", "Ate", "99888884", "pedrool@abc.com", "12345678", "U2023005");
        Persona personaInsert5 = personaNegocio.registrarPersona(personaAlumno5);
        Alumno registAlumno5 = new Alumno(5L, personaInsert5, true);
        Alumno insertAlumno5 = alumnoNegocio.registrarAlumno(registAlumno5);


        // Tratamiento de cursos
        List<Curso> cursos = cursoNegocio.obtenerCursos();
        //insertarHorarios
        String[] dias ={"Lunes","Martes","Miércoles","Jueves","Viernes"};
        Long idHorario = 0L;
        int i=7;
        for (var c:cursos){
            i++;
            for (var dia:dias){
                idHorario++;
                String inicio = String.format("%02d", i);
                String fin = String.format("%02d", i+1);
                Horario dataHorario = new Horario(idHorario, dia, inicio+":00", fin+":00", c);
                Horario insertHorario = horarioNegocio.registrarHorario(dataHorario);
            }
        }


        // Insert Calificacion del Alumno 1
        for (var c:cursos){
            AlumnoCursoPK _id = new AlumnoCursoPK(insertAlumno1.getCodigo(),c.getId()) ;
            int notas = obtenerNumeroAleatorio(11, 20);
            String _unico = insertAlumno1.getCodigo().toString()+c.getId().toString();
            Calificacion dataCalificacion = new Calificacion(_id,_unico, notas,"Sin observación", insertAlumno1,c);
            Calificacion insertCalificacion = calificacionNegocio.registrarCalificacion(dataCalificacion);

        }


        // Insert Calificacion del Alumno 2
        for (var c:cursos){
            AlumnoCursoPK _id = new AlumnoCursoPK(insertAlumno2.getCodigo(),c.getId()) ;
            int notas = obtenerNumeroAleatorio(9, 20);
            String _unico = insertAlumno2.getCodigo().toString()+c.getId().toString();
            Calificacion dataCalificacion = new Calificacion(_id,_unico, notas,"Sin observación", insertAlumno2,c);
            Calificacion insertCalificacion = calificacionNegocio.registrarCalificacion(dataCalificacion);
        }
        // Insert Calificacion del Alumno 3
        for (var c:cursos){
            AlumnoCursoPK _id = new AlumnoCursoPK(insertAlumno3.getCodigo(),c.getId()) ;
            int notas = obtenerNumeroAleatorio(9, 20);
            String _unico = insertAlumno3.getCodigo().toString()+c.getId().toString();
            Calificacion dataCalificacion = new Calificacion(_id,_unico, notas,"Sin observación", insertAlumno3,c);
            Calificacion insertCalificacion = calificacionNegocio.registrarCalificacion(dataCalificacion);
        }
        // Insert Calificacion del Alumno 4
        for (var c:cursos){
            AlumnoCursoPK _id = new AlumnoCursoPK(insertAlumno4.getCodigo(),c.getId()) ;
            int notas = obtenerNumeroAleatorio(9, 20);
            String _unico = insertAlumno4.getCodigo().toString()+c.getId().toString();
            Calificacion dataCalificacion = new Calificacion(_id,_unico, notas,"Sin observación", insertAlumno4,c);
            Calificacion insertCalificacion = calificacionNegocio.registrarCalificacion(dataCalificacion);
        }
        // Insert Calificacion del Alumno 5
        for (var c:cursos){
            AlumnoCursoPK _id = new AlumnoCursoPK(insertAlumno5.getCodigo(),c.getId()) ;
            int notas = obtenerNumeroAleatorio(9, 20);
            String _unico = insertAlumno5.getCodigo().toString()+c.getId().toString();
            Calificacion dataCalificacion = new Calificacion(_id,_unico, notas,"Sin observación", insertAlumno5,c);
            Calificacion insertCalificacion = calificacionNegocio.registrarCalificacion(dataCalificacion);
        }
    }
}
