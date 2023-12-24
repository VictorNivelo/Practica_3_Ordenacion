/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Censo {
    private String Motivo;
    private String Fecha;
    private String EstadoEmocional;

    public Censo() {
    }

    public Censo(String Motivo, String Fecha, String EstadoEmocional) {
        this.Motivo = Motivo;
        this.Fecha = Fecha;
        this.EstadoEmocional = EstadoEmocional;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstadoEmocional() {
        return EstadoEmocional;
    }

    public void setEstadoEmocional(String EstadoEmocional) {
        this.EstadoEmocional = EstadoEmocional;
    }

    @Override
    public String toString() {
        return "Censo{" + "Motivo=" + Motivo + ", Fecha=" + Fecha + ", EstadoEmocional=" + EstadoEmocional + '}';
    }
    
    
}
