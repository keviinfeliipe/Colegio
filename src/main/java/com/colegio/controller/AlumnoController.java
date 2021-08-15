package com.colegio.controller;

import com.colegio.model.dao.AlumnosImpl;
import com.colegio.model.entity.Alumnos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumno")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
public class AlumnoController {

    @PostMapping
    public ResponseEntity crearUsuario(@RequestBody Alumnos alumno) throws Exception{
        new AlumnosImpl().crear(alumno);
        System.out.println("xxx");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity actualizarAlumno(@RequestBody Alumnos alumno) throws Exception{
        new AlumnosImpl().actualizar(alumno);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarAlumno(@PathVariable("id") int id) throws Exception{
        new AlumnosImpl().eliminar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Alumnos>> listarAlumnos() throws Exception{
        List<Alumnos> listaAlumnos = new AlumnosImpl().listar();
        return new ResponseEntity<>(listaAlumnos,HttpStatus.OK);
    }

}
