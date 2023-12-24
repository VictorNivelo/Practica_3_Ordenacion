/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.ListaDinamica.Exepciones;

/**
 *
 * @author Victor
 */
public class EstaVacia extends Exception{
    
    public EstaVacia(){
        
    }
    
    public EstaVacia(String msg) {
        super(msg);
    }
}

