import java.util.*;

public class TravelItineraryPlanner {

    // Static scanner for input
    private static final Scanner scanner = new Scanner(System.in);

    // Data structure to hold itinerary details
    private static final List<Destination> itinerary = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Welcome to Travel Itinerary Planner ===");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1 -> addDestination();
                case 2 -> viewItinerary();
                case 3 -> calculateBudget();
                case 4 -> {
                    isRunning = false;
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addDestination() {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();

        System.out.print("Enter travel start date (yyyy-mm-dd): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter travel end date (yyyy-mm-dd): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter estimated budget for this destination: $");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Clear the buffer

        itinerary.add(new Destination(name, startDate, endDate, budget));
        System.out.println("Destination added successfully!");
    }

    private static void viewItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is currently empty.");
        } else {
            System.out.println("\nYour Travel Itinerary:");
            for (int i = 0; i < itinerary.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, itinerary.get(i));
            }
        }
    }

    private static void calculateBudget() {
        if (itinerary.isEmpty()) {
            System.out.println("No destinations added yet. Add destinations to calculate the budget.");
        } else {
            double totalBudget = itinerary.stream().mapToDouble(Destination::getBudget).sum();
            System.out.printf("Total estimated budget for your trip: $%.2f%n", totalBudget);
        }
    }

    // Inner class to represent a destination
    static class Destination {
        private final String name;
        private final String startDate;
        private final String endDate;
        private final double budget;

        public Destination(String name, String startDate, String endDate, double budget) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.budget = budget;
        }

        public double getBudget() {
            return budget;
        }

        @Override
        public String toString() {
            return String.format("Destination: %s, Start Date: %s, End Date: %s, Budget: $%.2f",
                    name, startDate, endDate, budget);
        }
    }
}
