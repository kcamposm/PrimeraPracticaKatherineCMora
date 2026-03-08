package ui;

import bl.entities.tiquete.TiquetesPendientes;

import java.util.Date;
import java.util.Scanner;

public class InterfazPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        TiquetesPendientes.insertar("Tiquete 1", "usuario 1", new Date());
        TiquetesPendientes.insertar("Tiquete 2", "usuario 2", new Date());
        TiquetesPendientes.insertar("Tiquete 3", "usuario 3", new Date());

        while (opcion != 3) {
            System.out.println("1. Iniciar sesión como usuario");
            System.out.println("2. Iniciar sesión como administrador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    InterfazUsuario.menuUsuario();
                    break;
                case 2:
                    InterfazAdmin.menuAdministrador();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }
        scanner.close();
    }

}