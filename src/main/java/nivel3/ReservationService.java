package nivel3;

import nivel3.exceptions.SeatAlreadyEmptyException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationService {
    private final int totalRows;
    private final int seatsPerRow;
    private final List<Seat> seats;

    public ReservationService(int totalRows, int seatsPerRow) {
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new ArrayList<>();
    }


    public void reserveSeat(int row, int seat, String personName) {
        validateSeatPosition(row, seat);
        validatePersonName(personName);
        Seat targetSeat = new Seat(row, seat, personName);

        if (seats.contains(targetSeat)) {
            throw new IllegalArgumentException("Error: Seat (Row: " + row + ", Seat: " + seat + ") is already reserved.");
        }
        seats.add(targetSeat);
    }

    public void cancelSeat(int row, int seat) {
        validateSeatPosition(row, seat);
        Seat targetSeat = new Seat(row, seat, " ");

        if (!seats.contains(targetSeat)) {
            throw new IllegalArgumentException("Error: Seat (Row: " + row + ", Seat: " + seat + ") is not reserved.");
        }
        seats.remove(targetSeat);
    }

    public void cancelAllByPerson(String personName) {
        validatePersonName(personName);

        boolean removed = seats.removeIf(seat -> seat.getPersonName().equalsIgnoreCase(personName.trim()));

        if (!removed) {
            throw new SeatAlreadyEmptyException("Error: No reservations found under the name: " + personName);
        }

    }

    public List<Seat> getAllSeats() {
        return new ArrayList<>(seats);
    }

    public List<Seat> getSeatsByPerson(String name) {
        validatePersonName(name);
        return seats.stream()
                .filter(seat -> seat.getPersonName().equalsIgnoreCase(name.trim()))
                .collect(Collectors.toList());
    }

    private void validateSeatPosition(int row, int seat) {
        if (seat < 1 || seat > seatsPerRow || row < 1 || row > totalRows) {
            throw new IllegalArgumentException("Invalid seat position.");
        }
        for (Seat s : seats) {
            if (s.getRow() == row && s.getSeat() == seat) {
                throw new IllegalArgumentException("Seat is already reserved.");
            }
        }
    }

    private void validatePersonName(String personName) {
        if (personName == null || personName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid person name.");
        }
    }
}
