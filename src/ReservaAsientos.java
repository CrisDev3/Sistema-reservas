import java.util.*;

public class ReservaAsientos {
    public static void main(String[] args) {
        //Declaracion de variables
        char asientos[][] = new char[10][10];
        Scanner teclado = new Scanner(System.in);
        int fila = 0;
        int asiento = 0;
        String opcion;
        String verAsientos;
        boolean bandera = false;
        boolean estaOk = false;
        //Carga de la matriz
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                asientos[f][c] = 'L';
            }
        }
        //Bienvenida al sistema
        System.out.println("----Bienvenido al sistema de reservas----");
        while (bandera != true) {
            System.out.println("¿Desea ver los asientos disponibles? S: Si, cualquier otra letra: NO");
            verAsientos = teclado.next();
            //visualizacion de las butacas
            if (verAsientos.equalsIgnoreCase("s")) {
                mostrarAsientos(asientos);
            }
            estaOk= false;
            //Reserva
            while (estaOk != true) {
                System.out.println("\nIngresa fila y asiento a reservar:");
                System.out.println("Fila (entre 0 y 9):");
                fila = teclado.nextInt();
                System.out.println("Asiento (entre 0 y 9):");
                asiento = teclado.nextInt();
                //validacion de la matriz
                if (fila <= 9 && fila >= 0) {
                    if (asiento <= 9 && asiento >= 0) {
                        estaOk = true;
                    } else {
                        System.out.println("Asiento no disponible");
                    }
                } else {
                    System.out.println("Fila no disponible");
                }
            }

            if (asientos[fila][asiento] == 'L') {
                asientos[fila][asiento] = 'X';
                System.out.println("Reserva realizada con exito!");
            } else {
                System.out.println("Asiento no disponible. Por favor elija otro");
            }
            System.out.println("¿Desea finalizar la  reserva? S: si, cualquier otra tecla: NO");
            opcion = teclado.next();
            if (opcion.equalsIgnoreCase("s")) {
                bandera = true;
            }
        }
    }

    //metodo para mostrar butacas
    static void mostrarAsientos(char asientos[][]) {
        for (int f = 0; f < 10; f++) {
            System.out.print(f + "");
            for (int c = 0; c < 10; c++) {
                System.out.print("[" + asientos[f][c] + "]");
            }
            System.out.println("");
        }
    }
}