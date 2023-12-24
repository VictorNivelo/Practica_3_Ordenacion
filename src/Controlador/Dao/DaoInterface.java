/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import Controlador.TDA.ListaDinamica.ListaDinamica;

/**
 *
 * @author Victor
 * @param <T>
 */
public interface DaoInterface <T> {
    public Boolean Persist(T dato);
    public Boolean Merge(T data, Integer index);
    public ListaDinamica<T> all();
    public T get(Integer id);
    
}
