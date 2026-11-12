package nivel3;
import nivel2.ConsoleReader;
import nivel2.IllegalInputException;

import java.util.List;

public class ConsoleUI {
    private final ReservationService reservationService;

    public ConsoleUI(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void showMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Reservation Service ===");
            System.out.println("1. Show all reserved seats.");
            System.out.println("2. Show the seats reserved by a person.");
            System.out.println("3. Reserve a seat.");
            System.out.println("4. Cancel a seat reservation.");
            System.out.println("5. Cancel all reservations for a person.");
            System.out.println("0. Exit");


            int choice = ConsoleReader.readInt("Enter your choice (0-5): ");

            switch (choice) {
                case 1:
                   showAllSeats();
                    break;
                case 2:
                    showSeatsByPerson();
                    break;
                case 3:
                    reserveSeat();
                    break;
                case 4:
                    cancelSeat();
                    break;
                case 5:
                    cancelAllByPerson();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 0 and 7.");
            }
        }
    }


}
