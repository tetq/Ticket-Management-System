import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketManagementSystem ticketManagementSystem = new TicketManagementSystem();
        UserManager userManager = new UserManager();

        while (true) {
            System.out.println("\nticket management system menu:");
            System.out.println("1. add new event");
            System.out.println("2. book ticket");
            System.out.println("3. cancel ticket");
            System.out.println("4. list all events");
            System.out.println("5. create new user");
            System.out.println("6. list all users");
            System.out.println("0. exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // add new event
                    try {
                        System.out.println("enter event details: ");
                        System.out.print("event ID: ");
                        int eventID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("event name: ");
                        String eventName = scanner.nextLine();
                        System.out.print("venue: ");
                        String venue = scanner.nextLine();
                        System.out.print("date: ");
                        String date = scanner.nextLine();
                        System.out.print("time: ");
                        String time = scanner.nextLine();
                        System.out.print("total seats: ");
                        int totalSeats = scanner.nextInt();
                        scanner.nextLine();

                        Event event = new Event(eventID, eventName, venue, date, time, totalSeats);
                        ticketManagementSystem.addEvent(event);
                        System.out.println("event successfully added");
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input, please try again.");
                        scanner.nextLine(); // clear the input buffer
                        }
                        break;

                case 2: // ticket booking
                    System.out.println("enter event ID to book ticket: ");
                    int eventIDtoBook = scanner.nextInt();
                    scanner.nextLine();
                    Event eventToBook = ticketManagementSystem.findEventByID(eventIDtoBook);
                    if (eventToBook != null) {
                        System.out.println("enter user ID to book ticket: ");
                        int userIDtoBook = scanner.nextInt();
                        scanner.nextLine();
                        User userToBook = userManager.findUserByID(userIDtoBook);
                        if (userToBook != null) {
                            eventToBook.bookTicket(userToBook);
                        } else {
                            System.out.println("user not fount with ID: " + userIDtoBook);
                        }
                    } else {
                        System.out.println("event not found with ID: " + eventIDtoBook);
                    }
                    break;

                case 3: // ticket cancelation
                    System.out.println("enter user ID to cancel ticket: ");
                    int userIDtoCancel = scanner.nextInt();
                    scanner.nextLine();
                    User userToCancel = userManager.findUserByID(userIDtoCancel);
                    if (userToCancel != null) {
                        System.out.println("enter event ID to cancel: ");
                        int eventIDtoCancel = scanner.nextInt();
                        scanner.nextLine();
                        Event eventToCancel = ticketManagementSystem.findEventByID(eventIDtoCancel);
                        if (eventToCancel != null) {
                            eventToCancel.cancelTicket();
                        } else {
                            System.out.println("event not found with ID: " + eventIDtoCancel);
                        }
                    } else {
                        System.out.println("user not found ID: " + userIDtoCancel);
                    }
                    break;

                case 4: // list all events
                    Event[] allEvents = ticketManagementSystem.getAllEvents();
                    Event.heapSort(allEvents);
                    System.out.println("all events: ");
                    for (Event e : allEvents) {
                        System.out.println("event ID: " + e.getEventID() + ", name: " + e.getName() + ", date: " + e.getDate() + ", time: " + e.getTime() + ", total seats: " + e.getTotalSeats());
                    }
                    break;

                case 5: // create new user
                    try {
                        System.out.println("enter user details: ");
                        System.out.print("user ID: ");
                        int userID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("name: ");
                        String name = scanner.nextLine();
                        System.out.print("email: ");
                        String email = scanner.nextLine();

                        User user = new User(userID, name, email);
                        userManager.addUsers(user);
                        System.out.println("user created successfully");
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input, please try again.");
                        scanner.nextLine(); // clear the input buffer
                    }
                    break;

                case 6: // list all users
                    userManager.listUsers();
                    break;

                case 0:                   
                    System.out.println("exiting...");
                    System.out.println("thank you for choosing ticket management app!");
                    System.exit(0);
            
                default:
                System.out.println("invalid choice, please input correct choice.");
            }
        }
    }
}