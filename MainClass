package RailwayReservationSystem;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Book ticket");
            System.out.println("2. Cancel ticket");
            System.out.println("3. Display confirmed list");
            System.out.println("4. Display RAC list");
            System.out.println("5. Display waiting list");
            System.out.println("6. Exit");

            int choice = getValidatedInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    bookTicket(scanner);
                    break;
                case 2:
                    cancelTicket(scanner);
                    break;
                case 3:
                    TicketBooking.displayConfirmed();
                    break;
                case 4:
                    TicketBooking.displayRAC();
                    break;
                case 5:
                    TicketBooking.displayWaiting();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void bookTicket(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = getValidatedInput(scanner, "Enter a valid age: ");
        System.out.print("Enter berth preference (U/M/L): ");
        char preference = scanner.next().toUpperCase().charAt(0);

        if (preference == 'U' || preference == 'M' || preference == 'L') {
            TicketBooking.bookTicket(new Passenger(name, age, preference));
        } else {
            System.out.println("Invalid berth preference. Please enter U, M, or L.");
        }
    }

    private static void cancelTicket(Scanner scanner) {
        int id = getValidatedInput(scanner, "Enter your Ticket ID: ");
        System.out.println(TicketCanceling.cancelTicket111(id));
    }

    private static int getValidatedInput(Scanner scanner, String prompt) {
        while (!scanner.hasNextInt()) {
            System.out.print(prompt);
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();
    }
}
