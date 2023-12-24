/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Persona {
    private Integer idPersona;
    private String Nombre;
    private String Apellido;
    private String Genero;
    private String EstadoCivil;
    private String Motivo;
    private String Fecha;
    private String EstadoEmocional;
    private String Censador;

    public Persona() {
        
    }

    public Persona(Integer idPersona, String Nombre, String Apellido, String Genero, String EstadoCivil, String Motivo, String Fecha, String EstadoEmocional, String Censador) {
        this.idPersona = idPersona;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Genero = Genero;
        this.EstadoCivil = EstadoCivil;
        this.Motivo = Motivo;
        this.Fecha = Fecha;
        this.EstadoEmocional = EstadoEmocional;
        this.Censador = Censador;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
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

    public String getCensador() {
        return Censador;
    }

    public void setCensador(String Censador) {
        this.Censador = Censador;
    }
    
    public Boolean comparar(Persona p, String campo, Integer tipo) {
        switch (tipo) {
            case 0:
                return compararCampo(p, campo) < 0;
            case 1:
                return compararCampo(p, campo) > 0;
            default:
                throw new IllegalArgumentException("Tipo de comparación no válido");
        }
    }

    private int compararCampo(Persona p, String campo) {
        switch (campo.toLowerCase()) {
            case "apellido":
                return Apellido.compareTo(p.getApellido());
            case "nombre":
                return Nombre.compareTo(p.getNombre());
            case "estado civil":
                return EstadoCivil.compareTo(p.getEstadoCivil());
            case "genero":
                return Genero.compareTo(p.getGenero());
            default:
                throw new IllegalArgumentException("Campo no válido para la comparación");
        }
    }

    @Override
    public String toString() {
        return "id:" + idPersona + ", Nombre:" + Nombre + ", Apellido:" + Apellido + ", Genero:" + Genero + ", Estado Civil:" + EstadoCivil + ", Motivo:" + Motivo + ", Fecha:" + Fecha + ", Estado Emocional:" + EstadoEmocional + ", Censador:" + Censador +"\n";
    }
    
    

    
}
