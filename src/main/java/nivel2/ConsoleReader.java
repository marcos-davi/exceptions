package nivel2;

import java.util.Scanner;

public class ConsoleReader {
    static Scanner sc = new Scanner(System.in);

    public static byte readByte(String message) {
        while (true) {
            try {
                System.out.println(message);
                return sc.nextByte();
            } catch (Exception e) {
                System.out.println(errorMessage());
                sc.nextLine(); // Clear the invalid input
            }
        }
    }

    private static String errorMessage() {
        return "Invalid input. Please enter a valid option.";
    }


    public static int readInt(String message) {
        while (true) {
            try {
                System.out.println(message);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println(errorMessage());
                sc.nextLine(); // Clear the invalid input
            }
        }
    }

    public static float readFloat(String message) {
        while (true) {
            try {
                System.out.println(message);
                return sc.nextFloat();
            } catch (Exception e) {
                System.out.println(errorMessage());
                sc.nextLine(); // Clear the invalid input
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            try {
                System.out.println(message);
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.println(errorMessage());
                sc.nextLine(); // Clear the invalid input
            }
        }
    }

    public static char readChar(String message) throws IllegalInputException {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.next();
                return validateChar(input);
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static String readString(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.next();
                return validateString(input);
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }


    public static boolean readYesNo(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.next();
                return validateBoolean(input);
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static char validateChar(String input) throws IllegalInputException {
        if (input.length() != 1) {
            throw new IllegalInputException(errorMessage());
        }
        return input.charAt(0);
    }

    public static boolean validateBoolean(String input) throws IllegalInputException {
        boolean isValid;
        if (!input.equals("s") && !input.equals("n")) {
            throw new IllegalInputException(errorMessage());
        } else if (input.equals("s")) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }

    public static String validateString(String input) throws IllegalInputException {
        if (input.length() < 2) {
            throw new IllegalInputException(errorMessage());
        }
        return input;
    }


}
