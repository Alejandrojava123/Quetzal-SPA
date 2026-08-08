package com.mycompany.quetzalspa.modelo;

import java.util.Date;

public class MedicionIMC {

    private int idMedicion;
    private int idUsuario;
    private double peso;
    private double imc;
    private String clasificacion;
    private Date fecha;

    public MedicionIMC() {
    }

    public MedicionIMC(int idMedicion, int idUsuario, double peso,
            double imc, String clasificacion, Date fecha) {

        this.idMedicion = idMedicion;
        this.idUsuario = idUsuario;
        this.peso = peso;
        this.imc = imc;
        this.clasificacion = clasificacion;
        this.fecha = fecha;
    }

    public int getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}