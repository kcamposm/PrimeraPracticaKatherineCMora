package bl.entities.listas;

import bl.entities.tiquete.Tiquete;

import java.util.ArrayList;
import java.util.Date;

public class TiquetesResueltos {


    //Esta clase es una lista enlazada simple


    private static TiqueteResuelto primero;

    //metodos
    //Constructor
    public TiquetesResueltos() {
        this.primero = null; //Como toda estructura debe nacer vacia, este dato nace null
    }

    public TiqueteResuelto getPrimero() {
        return primero;
    }
    public void setPrimero(TiqueteResuelto primero) {
        this.primero = primero;
    }


    //Operaciones

    //--------------------------CREATE-------------------------

    public static void insertarNodoInicio(Tiquete tiquete) {
        TiqueteResuelto nuevo = new TiqueteResuelto(tiquete);
        
        tiquete.setEstado(false);
        nuevo.setSiguiente(primero); //preservar la lista mediante la conservacion de la referencia al 1
        primero = nuevo; //Insercion del nuevo nodo como primero en la lista
    }

    private static boolean estaVacia(){
        return primero == null;
    }




    //--------------------------READ-------------------------

    public TiqueteResuelto buscar(int tiquetId){
        if (estaVacia()){
            System.out.println("La lista esta vacia");
            return null;
        }

        TiqueteResuelto temp = primero;
        while ( temp != null && temp.getTiquete().getTiquetId() != tiquetId){
            temp = temp.getSiguiente();
        }

        if (temp == null){
            System.out.println("El tiquete no se encontro en la lista");
        } else  {
            System.out.println("El tiquete se encontro en la lista");
        }

        return temp;
    }

    public static ArrayList<Tiquete> mostrarLista(){
        ArrayList<Tiquete> arrayTiquetes = new ArrayList<>();
        if (estaVacia()){
            System.out.println("La lista esta vacia");
            return arrayTiquetes;
        }

        TiqueteResuelto temp = primero;
        while (temp != null){
            arrayTiquetes.add(temp.getTiquete());
            temp = temp.getSiguiente();
        }
        return arrayTiquetes;
    }


    //--------------------------DELETE-------------------------

    public TiqueteResuelto eliminarNodo(int tiquetId){
        if (estaVacia()){
            System.out.println("La lista esta vacia.");
            return null;
        }
        TiqueteResuelto temp = primero;
        TiqueteResuelto anteriorTemp = temp;


        while ( temp != null && temp.getTiquete().getTiquetId() != tiquetId){
            anteriorTemp = temp; //poner al dia al anterior con respecto al temporar alntes de moverlo
            temp = temp.getSiguiente(); // pasar la referencia de temp al siguiente nodo
        }

        if (temp == null){
            System.out.println("El tiquete no se encontro en la lista");
        } else  {
            System.out.println("El tiquete se elimino de la lista");
            anteriorTemp.setSiguiente(temp.getSiguiente()); //conectamos al anterior del temporal con su siguiente
        }

        return temp;
    }


    //--------------------------UPDATE-------------------------

    public static Tiquete verTiquetesResueltos() {
        // This method should return the first ticket in the resolved tickets list
        // For now, we'll return null as a placeholder
        // In a complete implementation, this would need access to an instance
        return null;
    }

}
