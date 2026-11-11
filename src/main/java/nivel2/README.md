# Level 2: Robust Console Input Reader & Custom Validation

## Overview
This module implements a robust, fault-tolerant console reading utility (`ConsoleReader`) designed to prevent application crashes caused by invalid user inputs. It leverages infinite loops, exception handling, and custom validation rules.

## Key Concepts
- **Resilient Input Loops:** Continuous `while (true)` loops paired with `try-catch` blocks that force users to retry until valid data is provided.
- **Buffer Management:** Strategic use of scanner buffer cleanup (`sc.nextLine()`) to avoid infinite error loops caused by unconsumed invalid tokens.
- **Modular Validation:** Separation of reading logic from validation logic using custom validation methods and a custom exception (`IllegalInputException`).

## Components

### 1. `IllegalInputException.java`
- **Purpose:** A custom exception representing invalid format or constraint violations during console input reading.

### 2. `ConsoleReader.java`
- **Purpose:** A utility class providing static methods to read and validate various primitive types and objects safely from the standard input.
- **Key Features:**
  - **Numeric Readers:** Secure readers for `byte`, `int`, `float`, and `double` backed by `InputMismatchException` catching and buffer recovery.
  - **Character & String Readers:** Methods like `readChar`, `readString`, and `readYesNo` linked to custom validation logic (`validateChar`, `validateBoolean`, `validateString`) to ensure strict formatting constraints are met.