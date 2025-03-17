package com.example.demo.controller;

import com.example.demo.model.Aprendiz;
import com.example.demo.repository.AprendizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aprendices")
public class AprendizController {

    @Autowired
    private AprendizRepository aprendizRepository;

    // Mostrar lista de aprendices
    @GetMapping
    public String listarAprendices(Model model) {
        model.addAttribute("aprendices", aprendizRepository.findAll());
        return "aprendices/listar";
    }

    // Mostrar formulario para crear un nuevo aprendiz
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("aprendiz", new Aprendiz());
        return "aprendices/formulario";
    }

    // Guardar un nuevo aprendiz
    @PostMapping("/guardar")
    public String guardarAprendiz(@ModelAttribute Aprendiz aprendiz) {
        aprendizRepository.save(aprendiz);
        return "redirect:/aprendices";
    }

    // Mostrar formulario para editar un aprendiz existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        Aprendiz aprendiz = aprendizRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de aprendiz inválido: " + id));
        model.addAttribute("aprendiz", aprendiz);
        return "aprendices/formulario";
    }

    // Eliminar un aprendiz
    @GetMapping("/eliminar/{id}")
    public String eliminarAprendiz(@PathVariable int id) {
        aprendizRepository.deleteById(id);
        return "redirect:/aprendices";
    }
}


//get leer aprendices /aprendices listar aprendices
//ger leer aprendices /aprendices/editar/{iid} mostrar form para editar aprendice
//post crear /aprendices/guardar
//psot actualizar aprendices/guardar actualizar un aprendiz existente
//get eliminar /aprendices/eliminar/{id}