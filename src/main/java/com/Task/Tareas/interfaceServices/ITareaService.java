package com.Task.Tareas.interfaceServices;

import com.Task.Tareas.models.Tarea;

import java.util.List;
import java.util.Optional;

// Definimos una interfaz para los servicios de las tareas
public interface ITareaService {
    // Método para obtener una lista de todas las tareas
    public List<Tarea>listar();
    // Método para obtener una tarea específica por su ID
    public Optional<Tarea>listarId(int id);
    // Método para guardar una tarea. Devuelve el ID de la tarea guardada
    public int save(Tarea t);
    // Método para eliminar una tarea por su ID
    public void delete(int id);
}
