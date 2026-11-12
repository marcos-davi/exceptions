# Seat.java

## Overview
The `Seat` class represents the data model for a single reserved theater seat.

## Attributes
- `row` (`int`): The row coordinate.
- `seat` (`int`): The specific seat number within the row.
- `personName` (`String`): The name of the client who booked the seat.

## Key Methods
- `equals(Object o)` & `hashCode()`: Overridden to ensure two seats are considered identical if and only if they share the **same row and seat number**, regardless of the passenger/client name. Essential for collection lookup operations like `.contains()`.
- `toString()`: Formats the seat and customer details into a clean, readable string representation.


# ReservationService.java

## Overview
The `ReservationService` class is the core business logic engine of the application. It manages the cinema's seat inventory and enforces all operational rules.

## Attributes
- `totalRows`: Maximum number of rows in the theater room.
- `seatsPerRow`: Maximum number of seats per row.
- `seats`: A dynamic `List<Seat>` tracking all currently occupied seats.

## Core Methods
- `reserveSeat(row, seat, name)`: Validates position, checks name formatting, and registers a new reservation if the seat is free.
- `cancelSeat(row, seat)`: Releases a specific occupied seat.
- `cancelAllByPerson(name)`: Removes all reservations associated with a given client name.
- `getAllSeats()`: Returns a list of all active reservations.
- `getSeatsByPerson(name)`: Filters and returns reservations belonging to a specific individual.
- `validateSeatPosition(row, seat)`: Private helper ensuring coordinates fall within valid theater boundaries.
- `validatePersonName(name)`: Private helper ensuring names are non-empty and contain no numeric digits.

# ConsoleUI.java

## Overview
The `ConsoleUI` class manages all user interactions through the console. It acts strictly as the presentation layer, handling input/output operations without executing business rules or data validation logic.

## Responsibilities
- Displays the main interactive menu options.
- Reads and validates user selections safely using `ConsoleReader`.
- Gathers parameters (rows, seat numbers, client names) from the console.
- Calls the corresponding methods on `ReservationService`.
- Catches custom runtime exceptions gracefully to ensure the application remains resilient and never crashes due to invalid input.


# Main.java

## Overview
The `Main` class serves as the entry point for the Cinema Reservation System application. It adheres to clean architecture principles by containing zero business logic or input validation rules.

## Responsibilities
- Welcomes the user to the application.
- Prompts the user to define the room layout by specifying the total number of rows and seats per row using safe console reading methods.
- Instantiates the core business logic layer (`ReservationService`).
- Initializes the presentation layer (`ConsoleUI`) by injecting the reservation service dependency.
- Starts the application loop via `consoleUI.showMenu()`.