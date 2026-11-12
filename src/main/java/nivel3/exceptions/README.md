# Custom Exceptions

## Overview
A set of unchecked exceptions extending `RuntimeException` designed to handle domain-specific error states cleanly across the application layers.

## Classes
- `SeatAlreadyTakenException`: Thrown when attempting to reserve a seat that is already occupied.
- `SeatAlreadyEmptyException`: Thrown when trying to cancel a reservation on a seat that is currently free.
- `InvalidSeatException`: Thrown when coordinates exceed the physical dimensions of the cinema room.
- `InvalidPersonNameException`: Thrown when a client name is null, blank, or contains numeric characters.