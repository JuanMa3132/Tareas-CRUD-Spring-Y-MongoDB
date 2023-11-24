package com.Task.Tareas.service;

import com.Task.Tareas.interfaceServices.ITareaService;
import com.Task.Tareas.Tarearepository.ITareas;
import com.Task.Tareas.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotación para indicar que esta clase es un servicio
@Service
public class TareaService implements ITareaService {
    // Inyección de dependencias para el repositorio de tareas
    @Autowired
    private ITareas repository;

    // Implementación del método para obtener una lista de todas las tareas
    @Override
    public List<Tarea> listar() {
        return repository.findAll();
    }

    // Implementación del método para obtener una tarea específica por su ID
    @Override
    public Optional<Tarea> listarId(int id) {
        return repository.findById(id);
    }

    // Implementación del método para guardar una tarea. Devuelve el ID de la tarea guardada
    @Override
    public int save(Tarea t) {
        Tarea tarea = repository.save(t);
        return tarea.getId();
    }

    // Implementación del método para eliminar una tarea por su ID
    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
