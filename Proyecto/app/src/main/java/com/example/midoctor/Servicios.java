package com.example.midoctor;

public class Servicios {

    private int id;
    private String nombreservicio;
    private String descripcion;
    private String precio;
    private int idusuario;

    // Constructor
    public Servicios() {
    }

    public Servicios(int id, String nombreservicio, String descripcion, String precio, int idusuario) {
        this.id = id;
        this.nombreservicio = nombreservicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idusuario = idusuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
}
