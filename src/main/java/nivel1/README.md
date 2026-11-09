# Level 1: Custom Exceptions and Error Control

## Overview
This module demonstrates the basics of exception handling in Java, focusing on collections (`ArrayList`), custom exceptions, and catching standard runtime errors.

## Key Concepts: Checked vs Unchecked Exceptions
- **Checked Exceptions (extends `Exception`):** Java forces the programmer to handle them explicitly using `try-catch` or `throws` at compile time. They are typically used for external, predictable issues (like file I/O or network failures).
- **Unchecked Exceptions (extends `RuntimeException`):** The compiler does not force you to catch them. They usually represent programming bugs or logical errors (like `IndexOutOfBoundsException` or our custom `EmptySaleException`).

## Components

### 1. `Product.java`
- **Purpose:** Represents an individual product with a name and a price.
- **Key Features:** Encapsulated attributes with standard getter and setter methods.

### 2. `EmptySaleException.java`
- **Purpose:** A custom unchecked exception that extends `RuntimeException`.
- **Key Features:** Triggered when an operation is performed on a sale without any products added, representing a business logic error.

### 3. `Sales.java`
- **Purpose:** Manages a collection of products and calculates the total price.
- **Key Features:** 
  - Validates if the product list is empty before calculating the total, throwing the custom `EmptySaleException` if necessary.
  - Implements a simulation method (`simulateIndexOutOfBoundsException`) wrapped in a `try-catch` block to handle out-of-bounds collection accesses safely without crashing the application.