/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class RegistroCenso {
    private String Divorciados;
    private String Separados;

    public RegistroCenso() {
    }

    public RegistroCenso(String Divorciados, String Separados) {
        this.Divorciados = Divorciados;
        this.Separados = Separados;
    }

    public String getDivorciados() {
        return Divorciados;
    }

    public void setDivorciados(String Divorciados) {
        this.Divorciados = Divorciados;
    }

    public String getSeparados() {
        return Separados;
    }

    public void setSeparados(String Separados) {
        this.Separados = Separados;
    }

    @Override
    public String toString() {
        return "RegistroCenso{" + "Divorciados=" + Divorciados + ", Separados=" + Separados + '}';
    }
    
    
}
