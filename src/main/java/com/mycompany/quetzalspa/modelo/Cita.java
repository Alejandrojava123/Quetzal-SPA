package com.mycompany.quetzalspa.modelo;

import java.sql.Date;
import java.sql.Time;

public class Cita {

    private int idCita;
    private int idCliente;
    private int idServicio;

    private Date fecha;
    private Time hora;

    private String estado;

    // Estos dos campos los usaremos para mostrar
    // los nombres en la tabla de citas.
    private String nombreCliente;
    private String nombreServicio;

    public Cita() {
    }

    public Cita(int idCita, int idCliente, int idServicio,
                Date fecha, Time hora, String estado) {

        this.idCita = idCita;
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
}