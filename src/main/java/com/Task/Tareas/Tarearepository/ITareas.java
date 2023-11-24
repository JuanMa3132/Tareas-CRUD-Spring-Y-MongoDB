package com.Task.Tareas.Tarearepository;

import com.Task.Tareas.models.Tarea;

import org.springframework.data.mongodb.repository.MongoRepository;

// Esta interfaz extiende MongoRepository, que es una interfaz específica de Spring Data MongoDB
// para operaciones de repositorio de MongoDB. Tarea es la clase de entidad y Integer es el tipo
// del ID de la entidad.
public interface ITareas extends MongoRepository<Tarea, Integer> {

}
