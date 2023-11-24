package com.Task.Tareas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor


@Document(collection = "Tarea")

public class Tarea {
    @Id
    private Integer id;

    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private boolean completada;

    public Tarea() {

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}

