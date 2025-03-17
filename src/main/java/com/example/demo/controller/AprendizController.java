package com.example.demo.controller;

import com.example.demo.dao.AprendizDAO;
import com.example.demo.model.Aprendiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aprendices")
public class AprendizController {

    @Autowired
    private AprendizDAO aprendizDAO;

    // Listar todos los aprendices
    @GetMapping
    public String listarAprendices(Model model) {
        model.addAttribute("aprendices", aprendizDAO.findAll());
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
        aprendizDAO.save(aprendiz);
        return "redirect:/aprendices";
    }

    // Mostrar formulario para editar un aprendiz existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Aprendiz aprendiz = aprendizDAO.findById(id);
        model.addAttribute("aprendiz", aprendiz);
        return "aprendices/formulario";
    }

    // Actualizar un aprendiz existente
    @PostMapping("/actualizar/{id}")
    public String actualizarAprendiz(@PathVariable Integer id, @ModelAttribute Aprendiz aprendiz) {
        aprendiz.setId(id);
        aprendizDAO.update(aprendiz);
        return "redirect:/aprendices";
    }

    // Eliminar un aprendiz
    @GetMapping("/eliminar/{id}")
    public String eliminarAprendiz(@PathVariable Integer id) {
        aprendizDAO.deleteById(id);
        return "redirect:/aprendices";
    }
}