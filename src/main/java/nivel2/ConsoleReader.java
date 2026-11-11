package nivel2;

import java.util.Scanner;

public class ConsoleReader {
static Scanner sc = new Scanner(System.in);

    public static byte readByte(String message) {
        while (true){
            try {
                System.out.println(message);
                return sc.nextByte();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid ");
                sc.nextLine(); // Clear the invalid input
            }

        }

    }







    public static int readInt(String message) {
        return 0;
    }

    public static float readFloat(String message) {
        return 0;
    }

    public static double readDouble(String message) {
        return 0;
    }

    public static char readChar(String message) {
        // Només accepta un únic caràcter. Si se n’introdueix més d’un,
// llença una excepció personalitzada.
        return 0;
    }


    public static String readString(String message) {
        // Llegeix una cadena tal com es rep, però podries validar longitud
// mínima o contingut si cal.
        return null;
    }


    public static boolean readYesNo(String message) {
        // Si l’usuari/ària introdueix “s” (minúscula), retorna true.
        // Si introdueix “n”, retorna false.
        // Qualsevol altra entrada hauria de generar una excepció personalitzada.
        return false;
    }



}
