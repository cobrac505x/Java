package com.example.demo.model;

public class Aprendiz {

    private Integer id; // Cambiado a Integer
    private String nombre;
    private String telefono;

    // Constructor vacío
    public Aprendiz() {}

    // Constructor con parámetros
    public Aprendiz(Integer id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}