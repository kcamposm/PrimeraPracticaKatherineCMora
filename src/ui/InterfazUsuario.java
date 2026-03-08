package ui;

import bl.entities.tiquete.Tiquete;
import bl.entities.tiquete.TiquetesPendientes;
import bl.entities.listas.TiquetesResueltos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InterfazUsuario {

    public static void menuUsuario(){
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu de usuario");
            System.out.println("1. Crear un nuevo tiquete");
            System.out.println("2. Buscar un tiquete resuelto");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crearNuevoTiquete(scanner);
                    break;
                case 2:
                    System.out.println("Tiquetes resueltos");
                    ArrayList<Tiquete> tiquetesResueltos = TiquetesResueltos.mostrarLista();
                    for (int i = 0; i < tiquetesResueltos.size(); i++) {
                        System.out.println((i+1) + ". " + tiquetesResueltos.get(i).getDescripcion());
                    }
                    System.out.print("Seleccione el numero del tiquete que desea ver en detalle: ");
                    int seleccion = scanner.nextInt();
                    if (seleccion > 0 && seleccion <= tiquetesResueltos.size()) {
                        Tiquete tiqueteActual = tiquetesResueltos.get(seleccion - 1);
                        System.out.println("Tiquete encontrado");
                        System.out.println("Descripcion: " + tiqueteActual.getDescripcion());
                        System.out.println("Comentario: " + tiqueteActual.getCommentarioResolucion());
                        System.out.println("Usuario creador: " + tiqueteActual.getUsuarioCreador());
                        System.out.println("Fecha de creacion: " + tiqueteActual.getFechaCreacion());
                        System.out.println("Fecha de resolucion: " + tiqueteActual.getFechaResolucion());
                    } else {
                        System.out.println("Tiquete no encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (opcion != 3);
    }

    public static void crearNuevoTiquete(Scanner scanner){
        System.out.print("Ingrese la descripcion del tiquete: ");
        String descripcion = scanner.next();
        System.out.print("Ingrese el usuario que creo el tiquete: ");
        String usuarioCreador = scanner.next();
        Date fechaCreacion = new Date();
        scanner.nextLine(); //esto es para consumir el salto de linea que se genera al usar next()
        boolean exito = TiquetesPendientes.insertar(descripcion, usuarioCreador, fechaCreacion);
        if(exito) {
            System.out.println("Tiquete creado con exito");
        } else {
            System.out.println("Error al crear el tiquete");
        }
    }
}
