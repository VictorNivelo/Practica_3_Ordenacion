/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;

import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private ListaDinamica<Persona> personasTabla;

    public ListaDinamica<Persona> getPersonasTabla() {
        return personasTabla;
    }

    public void setPersonasTabla(ListaDinamica<Persona> personasTabla) {
        this.personasTabla = personasTabla;
    }
    
    @Override
    public int getRowCount() {
        return personasTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Persona p = personasTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdPersona() : "";
                case 1:
                    return (p != null) ? p.getNombre() : "";
                case 2:
                    return (p != null) ? p.getApellido(): "";
                case 3:
                    return (p != null) ? p.getGenero(): "";
                case 4:
                    return (p != null) ? p.getEstadoCivil(): "";
                case 5:
                    return (p != null) ? p.getMotivo(): "";
                case 6:
                    return (p != null) ? p.getFecha(): "";
                case 7:
                    return (p != null) ? p.getEstadoEmocional(): "";
                case 8:
                    return (p != null) ? p.getCensador(): "";
                default:
                    return null;
            }
        } 
        catch (ListaVacia | IndexOutOfBoundsException ex) {
        }
        return personasTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id persona";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Genero";
            case 4:
                return "Estado civil";
            case 5:
                return "Motivo";
            case 6:
                return "Fecha";
            case 7:
                return "Estado emocional";
            case 8:
                return "Censador";
            default:
                return null;
        }
    }
    
    public double sumarColumna(int columna) {
        double suma = 0.0;

        for (int fila = 0; fila < getRowCount(); fila++) {
            try {
                Object valor = getValueAt(fila, columna);

                if (valor instanceof Number) {
                    suma += ((Number) valor).doubleValue();
                }
            } 
            catch (Exception e) {
            }
        }

        return suma;
    }
    
    public int contarPersonasPorEstadoCivil(int columnaEstadoCivil, String estadoCivil) {
    int contador = 0;

    for (int fila = 0; fila < getRowCount(); fila++) {
        try {
            Object valorEstadoCivil = getValueAt(fila, columnaEstadoCivil);

            if (valorEstadoCivil instanceof String && ((String) valorEstadoCivil).equalsIgnoreCase(estadoCivil)) {
                contador++;
            }
        } catch (Exception e) {
        }
    }

    return contador;
}
}
