package nivel3;

public class Seat {
    private int row;
    private int seat;
    private String personName;

    public Seat(int row, int seat, String personName) {
        this.row = row;
        this.seat = seat;
        this.personName = personName;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "Seat= " + seat +
                ", Name= '" + personName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seatObj = (Seat) o;
        return row == seatObj.row && seat == seatObj.seat;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(row, seat);
    }
}
