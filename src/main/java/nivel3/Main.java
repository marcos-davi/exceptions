package nivel3;

import nivel2.ConsoleReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Cinema Reservation System ===");

        int totalRows = ConsoleReader.readInt("Enter the total number of rows in the cinema room: ");
        int seatsPerRow = ConsoleReader.readInt("Enter the number of seats per row: ");

        ReservationService reservationService = new ReservationService(totalRows, seatsPerRow);

        ConsoleUI consoleUI = new ConsoleUI(reservationService);

        consoleUI.showMenu();
    }
}