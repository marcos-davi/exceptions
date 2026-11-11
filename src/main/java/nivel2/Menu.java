package nivel2;

public class Menu {

    public static void showMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== ConsoleReader Test Menu ===");
            System.out.println("1. Test readByte");
            System.out.println("2. Test readInt");
            System.out.println("3. Test readFloat");
            System.out.println("4. Test readDouble");
            System.out.println("5. Test readChar");
            System.out.println("6. Test readString");
            System.out.println("7. Test readYesNo");
            System.out.println("0. Exit");

            int choice = ConsoleReader.readInt("Choose an option (0-7): ");

            switch (choice) {
                case 1:
                    byte b = ConsoleReader.readByte("Enter a byte: ");
                    System.out.println("-> Result received: " + b);
                    break;
                case 2:
                    int i = ConsoleReader.readInt("Enter an integer: ");
                    System.out.println("-> Result received: " + i);
                    break;
                case 3:
                    float f = ConsoleReader.readFloat("Enter a float: ");
                    System.out.println("-> Result received: " + f);
                    break;
                case 4:
                    double d = ConsoleReader.readDouble("Enter a double: ");
                    System.out.println("-> Result received: " + d);
                    break;
                case 5:
                    char c = ConsoleReader.readChar("Enter a character: ");
                    System.out.println("-> Result received: " + c);
                    break;
                case 6:
                    String s = ConsoleReader.readString("Enter a string (min 2 chars): ");
                    System.out.println("-> Result received: " + s);
                    break;
                case 7:
                    boolean yn = ConsoleReader.readYesNo("Do you want to continue?");
                    System.out.println("-> Result received: " + yn);
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