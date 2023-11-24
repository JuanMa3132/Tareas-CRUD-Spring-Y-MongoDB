package com.Task.Tareas.Controller;

import com.Task.Tareas.models.Tarea;
import com.Task.Tareas.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// Anotación para indicar que esta clase es un controlador
@Controller
// Anotación para mapear las solicitudes web
@RequestMapping
public class TareaController {
    // Inyección de dependencias para el servicio de tareas
    @Autowired
    private TareaService service;

    // Método para listar todas las tareas
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Tarea> Tareas = service.listar();
        model.addAttribute("Tareas", Tareas);
        model.addAttribute("Tarea", new Tarea());
        return "index";
    }

    private static Integer ID_COUNTER = 0;

    // Método para agregar una tarea
    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Tarea tarea) {
        if (tarea.getId() == null) {
            tarea.setId(++ID_COUNTER);
        }
        tarea.setFechaCreacion(new Date());
        service.save(tarea);
        return "redirect:/listar";
    }

    // Método para editar una tarea
// Método para editar una tarea
    @GetMapping("/editar/{id}")
    public String editar (@PathVariable int id, Model model){
        Optional<Tarea> tareaOptional = service.listarId(id);
        if(tareaOptional.isPresent()) {
            Tarea tarea = tareaOptional.get();
            tarea.setFechaCreacion(new Date());
            service.save(tarea);  // Guarda la tarea actualizada en la base de datos
            model.addAttribute("Tarea", tarea);
        }
        return "form";
    }

    // Método para guardar una tarea
// Método para guardar una tarea
    @PostMapping("/save")
    public String save(Tarea tarea, Model model){
        if(tarea.getId() != null) {
            tarea.setFechaCreacion(new Date());
        }
        service.save(tarea);
        return "redirect:/listar";
    }

    // Método para marcar una tarea como completada
    @PostMapping("/completar/{id}")
    public String completar(@PathVariable int id, @RequestParam(required = false) Boolean completada) {
        Optional<Tarea> tareaOptional = service.listarId(id);
        if(tareaOptional.isPresent() && completada != null) {
            Tarea tarea = tareaOptional.get();
            tarea.setCompletada(completada);
            service.save(tarea);
        }
        return "redirect:/listar";
    }

    // Método para eliminar una tarea
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.delete(id);
        return "redirect:/listar";
    }
}
