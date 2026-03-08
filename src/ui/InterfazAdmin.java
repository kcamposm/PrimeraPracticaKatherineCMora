package ui;

import bl.entities.listas.TiquetesResueltos;
import bl.entities.tiquete.Tiquete;
import bl.entities.tiquete.TiquetesPendientes;

import java.util.Date;
import java.lang.System;

public class InterfazAdmin {


    public static void menuAdministrador() {
        int opcion;
        do {
            System.out.println("Menu de administrador");
            System.out.println("1. Ver el tiquete al frente de la cola");
            System.out.println("2. Salir");
            opcion = Integer.parseInt(System.console().readLine());
            switch (opcion) {
                case 1:
                    // ver el tiquete al frente de la cola
                    Tiquete tiqueteFrente = TiquetesPendientes.verFrente();
                    if (tiqueteFrente != null) {
                        System.out.println("Primero del Queue");
                        System.out.println(tiqueteFrente.toString());
                        System.out.println("---------------------------------");
                        System.out.println("1. Resolver tiquete");
                        System.out.println("2. No resolver tiquete");
                        int opcionAdmin = Integer.parseInt(System.console().readLine());
                        switch (opcionAdmin) {
                            case 1:
                                Tiquete tiqueteResuelto;
                                tiqueteResuelto =  resolverTiquete(tiqueteFrente);

                                break;
                            case 2:
                                System.out.println("Tiquete no resuelto");
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }
                    } else {
                        System.out.println("No hay tiquetes en la cola");

                    }
                    break;
                case 2:
                    // salir del menu
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 2);
    }

    public static Tiquete resolverTiquete(Tiquete tiquete) {
        System.out.print("Ingrese un comentario: ");
        String comentario = System.console().readLine();
        tiquete.setFechaResolucion(new Date());
        tiquete.setCommentarioResolucion(comentario);
        tiquete.setEstado(false);

        //Remueve el tiquete de pendientes y lo asigna a tiqueteResuelto
        Tiquete tiqueteResuelto = TiquetesPendientes.remover();

        //Aca lo inserta como un nodo al inicio de la lista enlazada "Tiquetes resueltos"
        TiquetesResueltos.insertarNodoInicio(tiqueteResuelto);
        System.out.println("Tiquete resuelto");
        return tiqueteResuelto;
    }
}

