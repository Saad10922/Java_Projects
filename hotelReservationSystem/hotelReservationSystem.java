import java.util.*;

public class hotelReservationSystem {

    // Static scanner for user input
    private static final Scanner scanner = new Scanner(System.in);

    // List to store available rooms
    private static final List<Room> rooms = new ArrayList<>();

    // List to store bookings
    private static final List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms();
        System.out.println("=== Welcome to the Hotel Reservation System ===");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1 -> viewAvailableRooms();
                case 2 -> makeReservation();
                case 3 -> viewBookings();
                case 4 -> {
                    isRunning = false;
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Initialize the room list with some dummy data
    private static void initializeRooms() {
        rooms.add(new Room(101, "Standard", 100.00));
        rooms.add(new Room(102, "Standard", 100.00));
        rooms.add(new Room(201, "Deluxe", 200.00));
        rooms.add(new Room(202, "Deluxe", 200.00));
        rooms.add(new Room(301, "Suite", 500.00));
        rooms.add(new Room(302, "Suite", 500.00));
    }

    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation() {
        System.out.println("\nEnter the room number you want to book:");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Room selectedRoom = findRoomByNumber(roomNumber);
        if (selectedRoom == null || selectedRoom.isBooked()) {
            System.out.println("Room is not available. Please try again.");
        } else {
            System.out.print("Enter your name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter payment amount: $");
            double payment = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer

            if (payment < selectedRoom.getPrice()) {
                System.out.println("Insufficient payment. Reservation failed.");
            } else {
                double change = payment - selectedRoom.getPrice();
                selectedRoom.setBooked(true);
                bookings.add(new Booking(customerName, selectedRoom));
                System.out.printf("Reservation successful! Your change: $%.2f%n", change);
            }
        }
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings found.");
        } else {
            System.out.println("\nBooking Details:");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    private static Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // Inner class to represent a room
    static class Room {
        private final int roomNumber;
        private final String category;
        private final double price;
        private boolean isBooked;

        public Room(int roomNumber, String category, double price) {
            this.roomNumber = roomNumber;
            this.category = category;
            this.price = price;
            this.isBooked = false;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public boolean isBooked() {
            return isBooked;
        }

        public void setBooked(boolean booked) {
            isBooked = booked;
        }

        @Override
        public String toString() {
            return String.format("Room Number: %d, Category: %s, Price: $%.2f, Status: %s",
                    roomNumber, category, price, isBooked ? "Booked" : "Available");
        }
    }

    // Inner class to represent a booking
    static class Booking {
        private final String customerName;
        private final Room room;

        public Booking(String customerName, Room room) {
            this.customerName = customerName;
            this.room = room;
        }

        @Override
        public String toString() {
            return String.format("Customer: %s, Room Number: %d (%s), Price: $%.2f",
                    customerName, room.getRoomNumber(), room.getCategory(), room.getPrice());
        }
    }
}
