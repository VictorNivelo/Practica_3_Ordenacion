/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Tda.listas.Exepciones;

/**
 *
 * @author Victor
 */
public class PosicionNoEncontrada extends Exception{
    
    public PosicionNoEncontrada(String msg){
        super(msg);
        
    }
    
    public PosicionNoEncontrada(){
        super("La posición dada está fuera de los límites");
    }
    
}
