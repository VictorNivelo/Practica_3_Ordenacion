/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.ListaDinamica;

import Controlador.Tda.listas.Exepciones.ListaVacia;
import Controlador.Tda.listas.Exepciones.PosicionNoEncontrada;

/**
 *
 * @author Victor
 * @param <E>
 */
public class ListaDinamica<E> {

    private Nodo<E> cabezera;
    private Nodo<E> ultimo;
    private Integer Longitud;

    public ListaDinamica() {
        cabezera = null;
        ultimo = null;
        Longitud = 0;
    }
    
    public Boolean EstaVacio(){
        return(cabezera == null || Longitud == 0 );
    }
    
    public void AgregarCabeza(E info){
        Nodo<E> Ayuda ;
        if(EstaVacio()){
            Ayuda = new Nodo<>(info);
            cabezera = Ayuda;
            ultimo = Ayuda;
            Longitud++;
        }
        else{
            Nodo<E> CabezaAyuda = cabezera;
            Ayuda = new Nodo<>(info, CabezaAyuda);
            cabezera = Ayuda;
            Longitud++;
        }
    }
    
    public void AgregarFinal(E info){
        Nodo<E> Ayuda;
        if(EstaVacio()){
            AgregarCabeza(info);
//            Ayuda = new Nodo<>(info);
//            cabezera = Ayuda;
//            ultimo = Ayuda;
//            Longitud++;
        }
        else{
            Ayuda = new Nodo<>(info, null);
            ultimo.setSiguiente(Ayuda);
            ultimo = Ayuda;
            Longitud++;
        }
    }
    
    public void Agregar(E info){
        AgregarFinal(info);
    }
    
    private E getPrimero() throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
    }
        return cabezera.getInfo();
    }
    
//    public E ObtenerPrimero(Integer pos) throws EstaVacia{
//        
//        if (!EstaVacio()) {
//            E info = null;
//            if (pos >= 0 && pos < Longitud) {
//                if (pos == 0) {
//                    info = cabezera.getInfo();
//                } 
//                else {
//                    Nodo<E> ayuda = cabezera;
//                    for (int i = 0; i < pos; i++) {
//                        ayuda = ayuda.getSiguiente();
//                    }
//                    info = ayuda.getInfo();
//                }
//
//            } 
//            else {
//                throw new EstaVacia("La lista esta vacia");
//            }
//            return cabezera.getInfo();
//        } 
//        else {
//            throw new EstaVacia("La lista esta vacia");
//        }
//    }
    
    private E getFinal() throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
        }
        return ultimo.getInfo();
    }
    
    public E getInfo(Integer indice)throws ListaVacia, IndexOutOfBoundsException{
        return getNodo(indice).getInfo();
    }
    
    private Nodo<E> getNodo(Integer indice)throws ListaVacia, IndexOutOfBoundsException{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
        }
        else if(indice < 0 || indice.intValue() == Longitud){
            throw new IndexOutOfBoundsException("Fuera de nodo");
        }
        else if(indice == 0){
            return cabezera;
        }
        else if(indice == (Longitud -1)){
            return ultimo;
        }
        else{
            Nodo<E> Buscar = cabezera;
            int contador =0;
            while(contador < indice){
                contador++;
                Buscar = Buscar.getSiguiente();
            }
            return Buscar;
        }
    }
       
    public void Agregar (E info, Integer indice)throws ListaVacia{
        if(EstaVacio() || indice == 0){
            AgregarCabeza(info);
        }
        else if(indice.intValue() == Longitud){
            AgregarFinal(info);
        }
        else{
            Nodo<E> BuscarPrevio = getNodo(indice - 1);
            Nodo<E> Buscar= getNodo(indice);
            Nodo<E> Ayuda = new Nodo<>(info, Buscar);
            BuscarPrevio.setSiguiente(Ayuda);
            Longitud++;
        }
    }
    
    public void modificarPosicion(E dato, Integer pos) throws PosicionNoEncontrada{
        if(EstaVacio()){
            Agregar(dato);
        }
        else if(pos>=0 && pos < Longitud){
            if(pos == 0){
                cabezera.setInfo(dato);
            } 
            else{
    
                Nodo<E> aux = cabezera;
    
                for (int i = 0; i < pos; i++ ){
                    aux = aux.getSiguiente();
                }
                aux.setInfo(dato);
            }
        }
        else{
            throw new PosicionNoEncontrada();
        }
    }
    
    public ListaDinamica<E> obtenerLista() {
        ListaDinamica<E> lista = new ListaDinamica<>();
        Nodo<E> actual = cabezera;

        while (actual != null) {
            lista.AgregarFinal(actual.getInfo());
            actual = actual.getSiguiente();
        }

        return lista;
    }
    
    public Object[] CovertirEnArreglo() {
        Object[] Arreglos = new Object[Longitud];
        Nodo<E> actual = cabezera;

        for (int i = 0; i < Longitud; i++) {
            Arreglos[i] = actual.getInfo();
            actual = actual.getSiguiente();
        }

        return Arreglos;
    }
    
    public E extractFirst() throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("Lista vacia");
        }
        else{
            E element = cabezera.getInfo();
            Nodo<E> help = cabezera.getSiguiente();
            cabezera = null;
            cabezera = help;
            if(Longitud ==1)
                ultimo = null;
            Longitud--;
            return element;
        }
    }
    
    public E extractLast() throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("Lista vacia");
        }
        else{
            E element = ultimo.getInfo();
            Nodo<E> help = getNodo(Longitud-2);
            if(help == null){
                ultimo =null;
                if(Longitud == 2){
                    ultimo = cabezera;
                }
                else{
                    cabezera = null;
                }
            }
            else{
               ultimo = null;
               ultimo = help;
               ultimo.setSiguiente(null);
            }
            Longitud--;
            return element;
        }
    }
    
    public E extract(Integer indice) throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
        }
        else if(indice < 0 || indice.intValue() == Longitud){
            throw new IndexOutOfBoundsException("Fuera de nodo");
        }
        else if(indice == 0){
            return extractFirst();
        }
        else if(indice == (Longitud -1)){
            return extractLast();
        }
        else{
            Nodo<E> nodo_previo = getNodo(indice-1);
            Nodo<E> nodo_actual = getNodo(indice);
            E info = nodo_actual.getInfo();
            Nodo<E> help_next = nodo_actual.getSiguiente();
            nodo_actual = null;
            nodo_previo.setSiguiente(help_next);
            Longitud--;
            return info;
        }
    }
    
    public E eliminar(Integer pos) throws ListaVacia, IndexOutOfBoundsException {
        if (!EstaVacio()) {
            E dato = null;
            if (pos >= 0 && pos < Longitud) {
                if (pos == 0) {
                    dato = cabezera.getInfo();
                    cabezera = cabezera.getSiguiente();
                    Longitud--;
                } 
                else {
                    Nodo<E> aux = cabezera;
                    
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    
                    dato = aux.getInfo();
                    Nodo<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    Longitud--;
                }
            } 
            else {
                throw new IndexOutOfBoundsException();
            }
            return dato;
        } 
        else {
            throw new ListaVacia();
        }
    }
    
    public void resetear(){
        cabezera = null;
        ultimo = null;
        Longitud = 0;
    }
    
    public E[] toArray() {
        Class clazz;
        E[] matriz = null;
        if (Longitud > 0) {
            clazz = cabezera.getInfo().getClass();
            matriz = (E[]) java.lang.reflect.Array.newInstance(clazz, Longitud);
            Nodo<E> actual = cabezera;
            for (int i = 0; i < Longitud; i++) {
                matriz[i] = actual.getInfo();
                actual = actual.getSiguiente();
            }
        }
        return matriz;
    }
//    
//    public E[] toArray(){
//        Class clazz = null;
//        E[] matriz = null;
//        if(Longitud > 0 ){
//            clazz = cabezera.getInfo().getClass();
//            matriz = (E[])java.lang.reflect.Array.newInstance(clazz, Longitud);      
//        }
//        return matriz;
//    }
    
    public ListaDinamica<E> toList(E[] listaMatriz) {
        resetear();
        for (E elemento : listaMatriz) {
            AgregarFinal(elemento);
        }
        return this;
    }
    
//    public ListaDinamica<E> toList(E[] ListaMatriz){
//        resetear();
//        for(int i = 0; i < ListaMatriz.length; i ++){
//         this.Agregar(ListaMatriz[i]);        
//        }
//        return this;
//    }
    
    @Override
    public String toString() {
        StringBuilder StringB = new StringBuilder("Datos de lista \n");
        try {
            EstaVacio();
            
            Nodo<E> ayuda = cabezera;
            
            while(ayuda != null){
                StringB.append(ayuda.getInfo().toString());
                ayuda = ayuda.getSiguiente();
            }
        } 
        catch (Exception e) {
            StringB.append(e.getMessage());
        }
        return StringB.toString();
    }

    public Nodo<E> getCabezera() {
        return cabezera;
    }

    public void setCabezera(Nodo<E> cabezera) {
        this.cabezera = cabezera;
    }

    public Nodo<E> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<E> ultimo) {
        this.ultimo = ultimo;
    }

    public Integer getLongitud() {
        return Longitud;
    }

    public void setLongitud(Integer Longitud) {
        this.Longitud = Longitud;
    }

}
