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

    private void showAllSeats() {
        List<Seat> seats = reservationService.getAllSeats();
        if (seats.isEmpty()) {
            System.out.println("No reservations found yet.");
        } else {
            System.out.println("\n--- All Reserved Seats ---");
            for (Seat seat : seats) {
                System.out.println(seat);
            }
        }
    }

    private void showSeatsByPerson() {
        try {
            String name = ConsoleReader.readString("Enter the person's name: ");
            List<Seat> seats = reservationService.getSeatsByPerson(name);

            if (seats.isEmpty()) {
                System.out.println("No reservations found for: " + name);
            } else {
                System.out.println("\n--- Reservations for " + name + " ---");
                for (Seat seat : seats) {
                    System.out.println(seat);
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void reserveSeat() {
        try {
            int row = ConsoleReader.readInt("Enter row number: ");
            int seat = ConsoleReader.readInt("Enter seat number: ");
            String name = ConsoleReader.readString("Enter person name: ");

            reservationService.reserveSeat(row, seat, name);
            System.out.println("Success! Seat reserved successfully.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelSeat() {
        try {
            int row = ConsoleReader.readInt("Enter row number to cancel: ");
            int seat = ConsoleReader.readInt("Enter seat number to cancel: ");

            reservationService.cancelSeat(row, seat);
            System.out.println("Success! Seat reservation cancelled.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelAllByPerson() {
        try {
            String name = ConsoleReader.readString("Enter the person's name to cancel all reservations: ");
            reservationService.cancelAllByPerson(name);
            System.out.println("Success! All reservations for " + name + " have been cancelled.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
