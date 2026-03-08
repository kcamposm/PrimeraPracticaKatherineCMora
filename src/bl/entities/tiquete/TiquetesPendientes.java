package bl.entities.tiquete;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public class TiquetesPendientes {


    //Clase Cola Dinamica


    private static ArrayList<Tiquete> colaTiquetes = new ArrayList<>();

    //Metodos

    public TiquetesPendientes(){
        colaTiquetes = new ArrayList<>();
    }

    //Operaciones
    private static boolean estaVacia(){
        return colaTiquetes.isEmpty();
    }

    public static boolean insertar(String descripcion, String usuarioCreador, Date fechaCreacion){
        int tiquetId = colaTiquetes.size() + 1;
        Tiquete nuevoTiquete = new Tiquete(descripcion,usuarioCreador,fechaCreacion,tiquetId);
        nuevoTiquete.setEstado(true);
        colaTiquetes.add(nuevoTiquete);

        return true;
    }
    //dequeue()
    public static Tiquete remover(){
        if(estaVacia()){
            System.out.println("Cola de tiquetes pendientes esta vacia");
            return null;
        }

        return colaTiquetes.removeFirst();
    }

    public static Tiquete verFrente(){
        if(estaVacia()){
            System.out.println("Cola de tiquetes pendientes esta vacia");
            return null;
        }
        return colaTiquetes.getFirst();
    }
}
